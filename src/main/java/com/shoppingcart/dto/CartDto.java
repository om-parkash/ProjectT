package com.shoppingcart.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shoppingcart.domain.ShoppingItem;
import com.shoppingcart.domain.UserMaster;

public class CartDto {

	/** The user master. */
	private UserMaster userMaster;

	/** The shopping item with quantity. */
	private Map<ShoppingItem, Integer> shoppingItemWithQuantity = new LinkedHashMap<>(0);

	/** The no of items. */
	private Integer noOfItems = 0;

	/**
	 * Instantiates a new cart dto.
	 */
	public CartDto() {
		super();
	}

	/**
	 * Instantiates a new cart dto.
	 *
	 * @param userMaster the user master
	 * @param shoppingItemWithQuantity the shopping item with quantity
	 */
	public CartDto(UserMaster userMaster, Map<ShoppingItem, Integer> shoppingItemWithQuantity) {
		super();
		this.userMaster = userMaster;
		this.shoppingItemWithQuantity = shoppingItemWithQuantity;
	}

	/**
	 * Gets the user master.
	 *
	 * @return the user master
	 */
	public UserMaster getUserMaster() {
		return userMaster;
	}

	/**
	 * Sets the user master.
	 *
	 * @param userMaster the new user master
	 */
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	/**
	 * Gets the shopping item with quantity.
	 *
	 * @return the shopping item with quantity
	 */
	public Map<ShoppingItem, Integer> getShoppingItemWithQuantity() {
		return shoppingItemWithQuantity;
	}

	/**
	 * Sets the shopping item with quantity.
	 *
	 * @param shoppingItemWithQuantity the shopping item with quantity
	 */
	public void setShoppingItemWithQuantity(Map<ShoppingItem, Integer> shoppingItemWithQuantity) {
		this.shoppingItemWithQuantity = shoppingItemWithQuantity;
	}

	public Integer getNoOfItems() {
		noOfItems = shoppingItemWithQuantity.keySet().size();
		return noOfItems;
	}

	public void setNoOfItems(Integer noOfItems) {
		this.noOfItems = noOfItems;
	}

}
