package com.shoppingcart.constants;

/**
 * Contains all constants that are to be used throughout the application.
 * 
 */
public final class CommonConstants {

	public static final String DB_NAME = "shoppingcart";
	/**
	 * String constant for first parameter in named query.
	 */
	public static final String FIRST_PARAMETER = "1";

	/**
	 * String constant for second parameter in named query.
	 */
	public static final String SECOND_PARAMETER = "2";

	/**
	 * String constant for third parameter in named query.
	 */
	public static final String THIRD_PARAMETER = "3";

	/**
	 * String constant for one space.
	 */
	public static final String SPACE = " ";

	/**
	 * String constant for login error message.
	 */
	public static final String LOGIN_ERROR_MSG = "Please login first.";

	/**
	 * Constant for error string.
	 */
	public static final String ERROR = "error";

	/**
	 * userMaster string constant.
	 */
	public static final String USER_MASTER = "userMaster";

	/**
	 * String constant for login page url.
	 */
	public static final String LOGIN_PAGE_URL = "loginPage";

	/**
	 * String constant for cart session object.
	 */
	public static final String CART_SESSION_OBJECT = "cart";

	/**
	 * String constant for redirection to home page URL.
	 */
	public static final String REDIRECT_TO_HOME_PAGE = "redirect:getHomePage.do";

	/**
	 * String constant for redirection to show cart URL.
	 */
	public static final String REDIRECT_TO_SHOW_CART = "redirect:showCart.do";

	/**
	 * String constant for home page URL.
	 */
	public static final String HOME_PAGE_URL = "homePage";

	/**
	 * String constant for item page url.
	 */
	public static final String ITEM_PAGE_URL = "item";

	/**
	 * Constant for itemList string.
	 */
	public static final String ITEM_LIST = "itemList";

	/**
	 * Constant for password string.
	 */
	public static final String PASSWORD = "password";

	/**
	 * Constant for username string.
	 */
	public static final String USERNAME = "username";

	/**
	 * String constant to redirect login page url.
	 */
	public static final String REDIRECT_TO_LOGIN_PAGE = "redirect:getLoginPage.do";

	/**
	 * String constant for order.
	 */
	public static final String ORDER = "order";

	/**
	 * String constant for order items.
	 */
	public static final String ORDER_ITEMS = "orderItems";

	/**
	 * String constant for item.
	 */
	public static final String ITEM = "item";

	private CommonConstants() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Default constructor private as this is final class.
	}

}
