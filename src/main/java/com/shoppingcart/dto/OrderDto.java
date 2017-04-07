package com.shoppingcart.dto;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import com.shoppingcart.domain.ShoppingItem;

/**
 * The Class OrderDto.
 */
public class OrderDto {

	/** The order id. */
	private Integer orderId;

	/** The amount. */
	private Float amount;

	/** The order date. */
	private Date orderDate;

	/** The shopping items with quantity. */
	private Map<ShoppingItem, Integer> shoppingItemsWithQuantity = new TreeMap<>();

	/**
	 * Instantiates a new order dto.
	 */
	public OrderDto() {
	}

	/**
	 * Instantiates a new order dto.
	 *
	 * @param orderId the order id
	 * @param amount the amount
	 * @param orderDate the order date
	 */
	public OrderDto(Integer orderId, Float amount, Date orderDate) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.orderDate = orderDate;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the new order id
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Float getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	/**
	 * Gets the order date.
	 *
	 * @return the order date
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate the new order date
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets the shopping items with quantity.
	 *
	 * @return the shopping items with quantity
	 */
	public Map<ShoppingItem, Integer> getShoppingItemsWithQuantity() {
		return shoppingItemsWithQuantity;
	}

	/**
	 * Sets the shopping items with quantity.
	 *
	 * @param shoppingItemsWithQuantity the shopping items with quantity
	 */
	public void setShoppingItemsWithQuantity(Map<ShoppingItem, Integer> shoppingItemsWithQuantity) {
		this.shoppingItemsWithQuantity = shoppingItemsWithQuantity;
	}

	/**
	 * Adds the shopping item with quantity.
	 *
	 * @param item the item
	 * @param quantity the quantity
	 */
	public void addShoppingItemWithQuantity(ShoppingItem item, Integer quantity) {
		if (shoppingItemsWithQuantity == null) {
			shoppingItemsWithQuantity = new TreeMap<>();
		}
		shoppingItemsWithQuantity.put(item, quantity);
	}

}
