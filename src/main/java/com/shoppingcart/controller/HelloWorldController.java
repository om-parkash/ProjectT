package com.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingcart.domain.UserMaster;
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
public class HelloWorldController {

	/**
	 * Logger instance to log messages in log file.
	 */
	private static final ShoppingCartLogger LOGGER = ShoppingCartLoggerFactory.getLogger(HelloWorldController.class);

	/**
	 * Returns url of login page.
	 * 
	 * @return login page url as {@link String}.
	 */
	@RequestMapping(value = "/HelloWorld", method = RequestMethod.POST)
	public final void getLoginPage() {
		System.out.println("in hello world");
	}

}
