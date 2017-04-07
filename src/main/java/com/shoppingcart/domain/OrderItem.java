package com.shoppingcart.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shoppingcart.constants.CommonConstants;

/**
 * OrderItem is used to save mapping between orders and items. It basically stores the shopping item and quantity associated with
 * order.
 *
 */
@Entity
@Table(catalog = CommonConstants.DB_NAME, name = "order_item")
public class OrderItem implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The order item id. */
	@Column(name = "order_item_id")
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderItemId;

	/** The shopping item. */
	@OneToOne
	@JoinColumn(name = "item_id")
	@Basic(fetch = FetchType.EAGER)
	private ShoppingItem shoppingItem;

	/** The quantity. */
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "quantity")
	private Integer quantity;

	public OrderItem(final ShoppingItem shoppingItem, final Integer quantity) {
		super();
		this.shoppingItem = shoppingItem;
		this.quantity = quantity;
	}

	public OrderItem() {
		//Empty Constructor for hibernate
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(final Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public ShoppingItem getShoppingItem() {
		return shoppingItem;
	}

	public void setShoppingItem(final ShoppingItem shoppingItem) {
		this.shoppingItem = shoppingItem;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + getOrderItemId() + /* ", itemOrderMaster=" + itemOrderMaster + */", shoppingItem="
				+ shoppingItem + ", quantity=" + quantity + "]";
	}
}
