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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.shoppingcart.constants.CommonConstants;

/**
 * Cart is to save the list of shopping items with quantity for a particular user.
 *
 */
@Entity
@Table(catalog = CommonConstants.DB_NAME, name = "cart")
public class Cart implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cart id. */
	@Column(name = "cart_id")
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;

	/** The user master. */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserMaster userMaster;

	/** The item. */
	@ManyToOne
	@JoinColumn(name = "item_id")
	private ShoppingItem item;

	/** The quantity. */
	@Column(name = "quantity")
	@Basic(fetch = FetchType.EAGER)
	private Integer quantity;

	/**
	 * Instantiates a new cart.
	 */
	public Cart() {
		super();
	}

	/**
	 * Instantiates a new cart.
	 *
	 * @param cartId the cart id
	 * @param userMaster the user master
	 * @param item the item
	 * @param quantity the quantity
	 */
	public Cart(final UserMaster userMaster, final ShoppingItem item, final Integer quantity) {
		super();
		this.userMaster = userMaster;
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * Gets the cart id.
	 *
	 * @return the cart id
	 */
	public Integer getCartId() {
		return cartId;
	}

	/**
	 * Sets the cart id.
	 *
	 * @param cartId the new cart id
	 */
	public void setCartId(final Integer cartId) {
		this.cartId = cartId;
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
	public void setUserMaster(final UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public ShoppingItem getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 *
	 * @param item the new item
	 */
	public void setItem(final ShoppingItem item) {
		this.item = item;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userMaster=" + userMaster + ", item=" + item + ", quantity=" + quantity + "]";
	}

}
