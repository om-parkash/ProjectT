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
import com.shoppingcart.exception.ServiceException;
import com.shoppingcart.service.CartService;
import com.shoppingcart.service.UserMasterService;
import com.shoppingcart.util.ShoppingCartStringUtil;
import com.shoppingcart.util.logger.ShoppingCartLogger;
import com.shoppingcart.util.logger.ShoppingCartLoggerFactory;

/**
 * Controller for {@link UserMaster} in shopping cart.
 * 
 * <p>
 * Following utilities have been provided:-
 * <li>Verify login.
 * <li>Invalidate session in case of user logs out.
 * 
 */
@Controller
public class LoginController {

	/**
	 * Logger instance to log messages in log file.
	 */
	private static final ShoppingCartLogger LOGGER = ShoppingCartLoggerFactory.getLogger(LoginController.class);

	/**
	 * UserMasterService autowired.
	 */
	@Autowired
	private UserMasterService userMasterService;

	/**
	 * CartService autowired.
	 */
	@Autowired
	private CartService cartService;

	/**
	 * Returns url of login page.
	 * 
	 * @return login page url as {@link String}.
	 */
	@RequestMapping(value = "/getLoginPage", method = RequestMethod.GET)
	public final String getLoginPage() {
		return CommonConstants.LOGIN_PAGE_URL;
	}

	/**
	 * Invalidate session in case of user logs out.
	 * 
	 * @param {@link HttpSession} current session object.
	 * @return login page url as {@link String}.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public final String logout(final HttpSession session) {
		LOGGER.debug("Call for logout. Invalidating session. ");
		session.invalidate();
		LOGGER.debug("User logs out successfully.");
		LOGGER.info("Redirecting to login screen.");
		return CommonConstants.REDIRECT_TO_LOGIN_PAGE;
	}

	/**
	 * Validates username and passwords entered on login.
	 * 
	 * @param {@link HttpServletRequest} object.
	 * @param {@link Model} object.
	 * @param {@link HttpSession} current session object.
	 * @return error page url if username or password is invalid else home page url.
	 * @throws GenericException
	 */
	@RequestMapping(value = "login")
	public final String validateLogin(final HttpServletRequest req, final Model model, final HttpSession session)
			throws GenericException {
		UserMaster userMaster = null;
		CartDto cartDto = null;
		String url = null;
		try {
			final String username = req.getParameter(CommonConstants.USERNAME);
			final String password = req.getParameter(CommonConstants.PASSWORD);
			LOGGER.info("In validating login. User name is " + username);
			if (!ShoppingCartStringUtil.isNullOrEmpty(username) && !ShoppingCartStringUtil.isNullOrEmpty(password)) {
				userMaster = userMasterService.fetchUserMasterByUserNamePassword(username, password);
			}
			if (null == userMaster) {
				LOGGER.debug("Invalid username and password entered by user. Showing error for same.");
				model.addAttribute(CommonConstants.ERROR, "Please check your Login Credentials.");
				url = CommonConstants.LOGIN_PAGE_URL;
			} else {
				cartDto = cartService.getCartForUser(userMaster);
				session.setAttribute(CommonConstants.USER_MASTER, userMaster);
				session.setAttribute("cart", cartDto);
				LOGGER.debug("Entered username and password are valid. Setting user object in session.");
				url = CommonConstants.REDIRECT_TO_HOME_PAGE;
			}
		} catch (ServiceException serviceException) {
			LOGGER.error(serviceException.getMessage(), serviceException);
			throw new GenericException(serviceException.getMessage(), serviceException);
		}
		return url;
	}
}
