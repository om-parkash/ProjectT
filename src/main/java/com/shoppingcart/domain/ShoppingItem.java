package com.shoppingcart.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shoppingcart.constants.CommonConstants;

/**
 * This is to save item name, description, price.
 *
 */
@Entity
@Table(catalog = CommonConstants.DB_NAME, name = "shopping_items")
public class ShoppingItem implements Serializable, Comparable<ShoppingItem> {

	/** The Constant _31. */
	private static final int RANDOM_PRIME_NO = 31;

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ` Constant for item name length.
	 */
	private static final int ITEM_NAME_LENGTH = 200;

	/**
	 * Constant for item description length.
	 */
	private static final int ITEM_DESCRIPTION_LENGTH = 500;

	/** The item id. */
	@Column(name = "item_id")
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;

	/** The item name. */
	@Column(name = "item_name", length = ITEM_NAME_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private String itemName;

	/** The item description. */
	@Column(name = "item_description", length = ITEM_DESCRIPTION_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private String itemDescription;

	/** The item price. */
	@Column(name = "item_price")
	@Basic(fetch = FetchType.EAGER)
	private Float itemPrice;

	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(final Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(final String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setItemDescription(final String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * @return the itemPrice
	 */
	public Float getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(final Float itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
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
			if (!(obj instanceof ShoppingItem)) {
				result = false;
			}
			final ShoppingItem other = (ShoppingItem) obj;
			if (itemId == null) {
				if (other.itemId != null) {
					result = false;
				}
			} else if (!itemId.equals(other.itemId)) {
				result = false;
			}
			if (itemName == null) {
				if (other.itemName != null) {
					result = false;
				}
			} else if (!itemName.equals(other.itemName)) {
				result = false;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "ShoppingItem [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", itemPrice="
				+ itemPrice + "]";
	}

	public int compareTo(final ShoppingItem o) {

		return this.itemId.compareTo(o.itemId);
	}

}
