package com.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingcart.constants.CommonConstants;
import com.shoppingcart.domain.UserMaster;
import com.shoppingcart.dto.CartDto;
import com.shoppingcart.dto.OrderDto;
import com.shoppingcart.exception.GenericException;
import com.shoppingcart.exception.ServiceException;
import com.shoppingcart.service.ItemOrderMasterService;
import com.shoppingcart.util.logger.ShoppingCartLogger;
import com.shoppingcart.util.logger.ShoppingCartLoggerFactory;

/**
 * The Class OrderController.
 */
@Controller
public class OrderController {

	/** The item order master service. */
	@Autowired
	private ItemOrderMasterService itemOrderMasterService;

	/**
	 * Logger instance to log messages in log file.
	 */
	private static final ShoppingCartLogger LOGGER = ShoppingCartLoggerFactory.getLogger(OrderController.class);

	/**
	 * Gets the orders for user.
	 *
	 * @param req the req
	 * @param model the model
	 * @param session the session
	 * @return the orders for user
	 * @throws GenericException
	 */
	@RequestMapping(value = "getOrders", method = {RequestMethod.POST, RequestMethod.GET })
	public final String getOrdersForUser(final Model model, final HttpSession session) throws GenericException {
		String url = null;
		try {
			final UserMaster userMaster = (UserMaster) session.getAttribute(CommonConstants.USER_MASTER);
			LOGGER.debug("In get order for user master" + userMaster);
			if (null == userMaster) {
				url = invalidUser(model);
			} else {
				List<OrderDto> orderList = null;
				orderList = itemOrderMasterService.fetchAllOrders(userMaster);
				model.addAttribute("orderList", orderList);
				url = "getOrders";
				LOGGER.info("Order item list is populated successfully for user name " + userMaster.getUserName());
			}
		} catch (ServiceException serviceException) {
			LOGGER.error(serviceException.getMessage(), serviceException);
			throw new GenericException(serviceException.getMessage(), serviceException);
		}
		return url;
	}

	/**
	 * Order item.
	 *
	 * @param req the req
	 * @param model the model
	 * @param session the session
	 * @return the string
	 * @throws GenericException
	 */
	@RequestMapping(value = "orderItems", method = {RequestMethod.POST })
	public final String orderItem(final HttpServletRequest req, final Model model, final HttpSession session) throws GenericException {
		String url = null;
		try {
			final UserMaster userMaster = (UserMaster) session.getAttribute(CommonConstants.USER_MASTER);
			CartDto cartDto = (CartDto) session.getAttribute(CommonConstants.CART_SESSION_OBJECT);
			LOGGER.debug("In orderItems for user master" + userMaster);
			LOGGER.debug("In orderItems for cart" + cartDto);
			if (null == userMaster || cartDto == null) {
				url = invalidUser(model);
			} else {
				OrderDto orderDto = null;
				orderDto = itemOrderMasterService.processOrder(userMaster);
				req.setAttribute(CommonConstants.ORDER, orderDto);
				LOGGER.debug("In orderItems order is successful with details " + orderDto);
				LOGGER.debug("In or`derItems order is successful. Setting Empty cart.");
				session.setAttribute(CommonConstants.CART_SESSION_OBJECT, new CartDto());
				url = CommonConstants.ORDER_ITEMS;
			}
		} catch (ServiceException serviceException) {
			LOGGER.error(serviceException.getMessage(), serviceException);
			throw new GenericException(serviceException.getMessage(), serviceException);
		}
		return url;
	}

	/**
	 * Invalid user.
	 *
	 * @param model the model
	 * @return the string
	 */
	private String invalidUser(final Model model) {
		String url;
		model.addAttribute(CommonConstants.ERROR, CommonConstants.LOGIN_ERROR_MSG);
		url = CommonConstants.LOGIN_PAGE_URL;
		LOGGER.debug("No user is present in current seesion");
		return url;
	}
}
