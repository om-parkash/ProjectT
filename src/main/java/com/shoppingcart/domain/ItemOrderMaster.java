package com.shoppingcart.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shoppingcart.constants.CommonConstants;

/**
 * ItemOrderMaster is used to store orders for the users.
 *
 */
@Entity
@Table(catalog = CommonConstants.DB_NAME, name = "item_order_master")
public class ItemOrderMaster implements Serializable {

	/** The Constant _31. */
	private static final int RANDOM_PRIME_NO = 31;

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/** The Constant ORDER_AMOUNT_LENGTH. */
	private static final int ORDER_AMOUNT_LENGTH = 11;

	/** The item order id. */
	@Column(name = "order_id")
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	/** The user master. */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserMaster userMaster;

	/** The list of order item. */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "order_order_items", joinColumns = {@JoinColumn(name = "order_id")}, inverseJoinColumns = {@JoinColumn(name = "order_item_id")})
	private List<OrderItem> listOfOrderItem = new ArrayList<OrderItem>();

	/** The order amount. */
	@Column(name = "order_amount", length = ORDER_AMOUNT_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private Float orderAmount;

	/** The order date. */
	@Column(name = "order_date")
	@Basic(fetch = FetchType.EAGER)
	private Date orderDate;

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * Gets the order amount.
	 *
	 * @return the order amount
	 */
	public Float getOrderAmount() {
		return orderAmount;
	}

	/**
	 * Sets the order amount.
	 *
	 * @param orderAmount the new order amount
	 */
	public void setOrderAmount(final Float orderAmount) {
		this.orderAmount = orderAmount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = RANDOM_PRIME_NO;
		int result = 1;
		result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
		result = prime * result + ((userMaster == null || userMaster.getUserId() == null) ? 0 : userMaster.getUserId().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		boolean result = true;
		if (this != obj) {
			if (obj == null) {
				result = false;
			}
			if (!(obj instanceof ItemOrderMaster)) {
				result = false;
			}
			final ItemOrderMaster other = (ItemOrderMaster) obj;

			if (userMaster == null) {
				if (other.userMaster.getUserId() != null) {
					result = false;
				}
			} else if (!userMaster.getUserId().equals(other.userMaster.getUserId())) {
				result = false;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "ItemOrderMaster [orderId=" + orderId + ", userMaster=" + userMaster + ", listOfOrderItem=" + listOfOrderItem
				+ ", orderAmount=" + orderAmount + ", orderDate=" + orderDate + "]";
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(final Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(final Integer orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getListOfOrderItem() {
		return listOfOrderItem;
	}

	public void setListOfOrderItem(final List<OrderItem> listOfOrderItem) {
		this.listOfOrderItem = listOfOrderItem;
	}

}
