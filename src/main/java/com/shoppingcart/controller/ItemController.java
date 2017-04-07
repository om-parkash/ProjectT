package com.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingcart.constants.CommonConstants;
import com.shoppingcart.domain.ShoppingItem;
import com.shoppingcart.domain.UserMaster;
import com.shoppingcart.exception.GenericException;
import com.shoppingcart.exception.InvalidItemException;
import com.shoppingcart.exception.ServiceException;
import com.shoppingcart.service.ShoppingItemService;
import com.shoppingcart.util.logger.ShoppingCartLogger;
import com.shoppingcart.util.logger.ShoppingCartLoggerFactory;


/**
 * Controller for {@link ShoppingItem} available in shopping cart.
 * 
 * <p>
 * Following utilities have been provided:-
 * <li>Retrieve all shopping items present in database.
 * 
 */
@Controller
public class ItemController {

	/**
	 * Logger instance to log messages in log file.
	 */
	private static final ShoppingCartLogger LOGGER = ShoppingCartLoggerFactory.getLogger(ItemController.class);

	/**
	 * ShoppingItemService autowired.
	 */
	@Autowired
	private ShoppingItemService shoppingItemService;

	/**
	 * Fetches all shopping items from database and if no user present in current session then error url is returned.
	 * 
	 * @param {@link Model} object.
	 * @param {@link HttpSession} current session object.
	 * @return error url if no user is present in current session else homepage url.
	 * @throws GenericException
	 */
	@RequestMapping(value = "getHomePage", method = RequestMethod.GET)
	public final String getAllItems(final Model model, final HttpSession session) throws GenericException {
		String url = null;
		try {
			final UserMaster userMaster = (UserMaster) session.getAttribute(CommonConstants.USER_MASTER);
			if (null == userMaster) {
				url = invalidUser(model);
			} else {
				List<ShoppingItem> itemList = null;
				itemList = shoppingItemService.fetchAllItems();
				model.addAttribute(CommonConstants.ITEM_LIST, itemList);
				url = CommonConstants.HOME_PAGE_URL;
				LOGGER.debug("Shopping item list is populated successfully.");
			}
		} catch (ServiceException serviceException) {
			LOGGER.error(serviceException.getMessage(), serviceException);
			throw new GenericException(serviceException.getMessage(), serviceException);
		}
		return url;
	}

	@RequestMapping(value = "item", method = RequestMethod.POST)
	public final String addItem(final Model model, final HttpSession session, final HttpServletRequest request)
			throws GenericException {
		UserMaster userMaster = null;
		Integer itemId = null;
		String url;
		try {
			userMaster = (UserMaster) session.getAttribute(CommonConstants.USER_MASTER);
			if (null == userMaster) {
				url = invalidUser(model);
			} else {
				if (request.getParameter("id") != null) {
					itemId = Integer.parseInt(request.getParameter("id"));

					ShoppingItem item = null;
					item = shoppingItemService.fetchItemById(itemId);

					if (item == null) {
						throw new InvalidItemException(itemId);
					}
					model.addAttribute(CommonConstants.ITEM, item);
					url = CommonConstants.ITEM_PAGE_URL;

					LOGGER.debug("Shopping item list is populated successfully.");
				} else {
					LOGGER.info("Wrong url hit for username " + userMaster.getUserName());
					url = CommonConstants.HOME_PAGE_URL;
					throw new InvalidItemException(0);
				}
			}
		} catch (NumberFormatException formatException) {
			LOGGER.debug("Exception is " + formatException);
			LOGGER.error("Invalid item id entered by user name " + userMaster.getUserName());
			throw new InvalidItemException(itemId);
		} catch (ServiceException serviceException) {
			LOGGER.error(serviceException.getMessage(), serviceException);
			throw new GenericException(serviceException.getMessage(), serviceException);
		}
		return url;
	}

	private String invalidUser(final Model model) {
		String url;
		model.addAttribute(CommonConstants.ERROR, CommonConstants.LOGIN_ERROR_MSG);
		url = CommonConstants.LOGIN_PAGE_URL;
		LOGGER.debug("No user is present in current session");
		return url;
	}

}
