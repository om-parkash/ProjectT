package com.shoppingcart.controller;

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
import com.shoppingcart.exception.GenericException;
import com.shoppingcart.exception.InvalidItemException;
import com.shoppingcart.exception.InvalidQuantityException;
import com.shoppingcart.exception.ServiceException;
import com.shoppingcart.service.CartService;
import com.shoppingcart.util.logger.ShoppingCartLogger;
import com.shoppingcart.util.logger.ShoppingCartLoggerFactory;

/**
 * Controller for shopping cart available in shopping cart.
 * 
 * <p>
 * Following utilities have been provided:-
 * <li>Retrieve all shopping items present in database.
 * 
 */
@Controller
public class CartController {

	/**
	 * Constants for quantity attribute.
	 */
	private static final String QUANTITY_ATTRIBUTE = "quantity";

	/**
	 * Logger instance to log messages in log file.
	 */
	private static final ShoppingCartLogger LOGGER = ShoppingCartLoggerFactory.getLogger(CartController.class);

	/** The cart service. */
	@Autowired
	private CartService cartService;

	/**
	 * Fetches all shopping items from database and if no user present in current session then error url is returned.
	 * 
	 * @param {@link Model} model.
	 * @param {@link HttpSession} current session object.
	 * @return error url if no user is present in current session else homepage url.
	 */
	@RequestMapping(value = "showCart", method = RequestMethod.GET)
	public final String showCart(final Model model, final HttpSession session) {
		final UserMaster userMaster = (UserMaster) session.getAttribute(CommonConstants.USER_MASTER);
		LOGGER.debug("Executing showCart for user master " + userMaster);
		String url;
		if (null == userMaster) {
			url = invalidUser(model);
		} else {
			url = "showCart";
		}
		LOGGER.debug("Exiting showCart for user master " + userMaster + " url : " + url);
		return url;
	}

	/**
	 * Adds the to cart.
	 *
	 * @param model the model
	 * @param session the session
	 * @param request the request
	 * @return the string
	 * @throws GenericException the generic exception
	 */
	@RequestMapping(value = "/addToCart", method = {RequestMethod.POST })
	public final String addToCart(final Model model, final HttpSession session, final HttpServletRequest request)
			throws GenericException {
		String url = null;
		Integer itemId = null;
		Integer quantity = null;
		UserMaster userMaster = null;
		try {
			userMaster = (UserMaster) session.getAttribute(CommonConstants.USER_MASTER);
			CartDto cartDto = (CartDto) session.getAttribute(CommonConstants.CART_SESSION_OBJECT);
			if (null == userMaster) {
				url = invalidUser(model);
			} else {
				LOGGER.info("In add to cart item id is " + request.getParameter("id"));
				LOGGER.info("In add to cart quantity is " + request.getParameter(QUANTITY_ATTRIBUTE));
				if (request.getParameter("id") != null && request.getParameter(QUANTITY_ATTRIBUTE) != null) {
					itemId = Integer.parseInt(request.getParameter("id"));
					quantity = parseQuantity(request, userMaster);
					cartDto = cartService.addItemToCart(userMaster, itemId, quantity, cartDto);
					session.setAttribute(CommonConstants.CART_SESSION_OBJECT, cartDto);
					url = CommonConstants.REDIRECT_TO_HOME_PAGE;
					LOGGER.debug("Item successfully added to cart.");
				} else {
					url = redirectToHomePage(userMaster);
				}
			}
		} catch (NumberFormatException formatException) {
			LOGGER.debug("In addToCart Exception is " + formatException);
			LOGGER.error("In addToCart Invalid item id entered by user master " + userMaster);
			throw new InvalidItemException(itemId);
		} catch (ServiceException serviceException) {
			LOGGER.error(serviceException.getMessage(), serviceException);
			throw new GenericException(serviceException.getMessage(), serviceException);
		}
		return url;
	}

	private Integer parseQuantity(final HttpServletRequest request, final UserMaster userMaster) {
		Integer quantity = null;
		try {
			quantity = Integer.parseInt(request.getParameter(QUANTITY_ATTRIBUTE)); 
		} catch (NumberFormatException numberFormatException) {
			LOGGER.debug("Exception occurred is " + numberFormatException);
			LOGGER.error("Invalid quantity entered by user name " + userMaster.getUserName());
			throw new InvalidQuantityException(quantity);
		}
		return quantity;
	}

	@RequestMapping(value = "/removeItemFromCart", method = {RequestMethod.GET, RequestMethod.POST })
	public final String removeItemFromCart(final Model model, final HttpSession session, final HttpServletRequest request)
			throws GenericException {
		UserMaster userMaster = null;
		String url = null;
		Integer itemId = null;
		try {
			userMaster = (UserMaster) session.getAttribute(CommonConstants.USER_MASTER);
			if (null == userMaster) {
				url = invalidUser(model);
			} else {
				LOGGER.info("In remove item from cart " + request.getParameter("id"));
				if (request.getParameter("id") != null) {
					itemId = Integer.parseInt(request.getParameter("id"));
					CartDto cartDto = null;
					cartDto = cartService.removeItemFromCart(userMaster, itemId);
					session.setAttribute("cart", cartDto);
					url = CommonConstants.REDIRECT_TO_SHOW_CART;
					LOGGER.debug("Item successfully removed from cart.");
				} else {
					url = redirectToHomePage(userMaster);
				}
			}
		} catch (ServiceException serviceException) {
			LOGGER.error(serviceException.getMessage(), serviceException);
			throw new GenericException(serviceException.getMessage(), serviceException);
		} catch (NumberFormatException formatException) {
			LOGGER.error("In removeItemFromCart Exception is " + formatException);
			LOGGER.error("In removeItemFromCart Invalid item id entered by user name " + userMaster.getUserName());
			throw new InvalidItemException(itemId);
		}
		return url;
	}

	/**
	 * Redirect to home page.
	 *
	 * @param userMaster the user master
	 * @return the string
	 */
	private String redirectToHomePage(final UserMaster userMaster) {
		String url;
		LOGGER.info("Wrong url hit for username " + userMaster.getUserName());
		url = CommonConstants.REDIRECT_TO_HOME_PAGE;
		return url;
	}

	@RequestMapping(value = "/updateItemInCart", method = {RequestMethod.GET, RequestMethod.POST })
	public final String updateItemInCart(final Model model, final HttpSession session, final HttpServletRequest request)
			throws GenericException {
		UserMaster userMaster = null;
		String url = null;
		try {
			userMaster = (UserMaster) session.getAttribute(CommonConstants.USER_MASTER);
			if (null == userMaster) {
				url = invalidUser(model);
			} else {
				LOGGER.info("In update item from cart " + request.getParameter("id"));
				LOGGER.info("In update item from cart " + request.getParameter(QUANTITY_ATTRIBUTE));

				if (request.getParameter("id") != null && request.getParameter(QUANTITY_ATTRIBUTE) != null) {
					Integer itemId = null;
					Integer quantity = null;
					itemId = Integer.parseInt(request.getParameter("id"));
					quantity = parseQuantity(request, userMaster);

					if (itemId == null || itemId < 1 || quantity == null || quantity < 1) {
						throw new InvalidItemException(itemId);
					}

					CartDto cartDto = null;
					cartDto = cartService.updateItemQuantityInCart(userMaster, itemId, quantity);
					session.setAttribute("cart", cartDto);
					url = CommonConstants.REDIRECT_TO_SHOW_CART;
					LOGGER.debug("Item successfully updated in cart.");
				} else {
					url = redirectToHomePage(userMaster);
				}
			}
		} catch (ServiceException serviceException) {
			LOGGER.error(serviceException.getMessage(), serviceException);
			throw new GenericException(serviceException.getMessage(), serviceException);
		} catch (NumberFormatException formatException) {
			LOGGER.error("In updateItemInCart Exception is " + formatException);
			LOGGER.error("In updateItemInCart Invalid item id entered by user name " + userMaster.getUserName());
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
		LOGGER.debug("No user is present in current session");
		return url;
	}

}
