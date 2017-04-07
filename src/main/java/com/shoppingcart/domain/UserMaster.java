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
 * UserMaster is user. This contains all the information of user.
 *
 */
@Entity
@Table(catalog = CommonConstants.DB_NAME, name = "user_master")
public class UserMaster implements Serializable {

	/** The Constant _31. */
	private static final int RANDOM_PRIME_NO = 31;

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constant for user name length.
	 */
	private static final int USERNAME_LENGTH = 200;

	/**
	 * Constant for password length.
	 */
	private static final int PASSWORD_LENGTH = 100;

	/**
	 * Constant for first name length.
	 */
	private static final int FIRSTNAME_LENGTH = 200;

	/**
	 * Constant for last name length.
	 */
	private static final int LASTNAME_LENGTH = 200;

	/**
	 * Constant for gender length.
	 */
	private static final int GENDER_LENGTH = 100;

	/**
	 * Constant for user address length.
	 */
	private static final int USER_ADDRESS_LENGTH = 500;

	/**
	 * Constant for user contact length.
	 */
	private static final int USER_CONTACT_LENGTH = 100;

	/**
	 * Constant for email id length.
	 */
	private static final int EMAILID_LENGTH = 200;

	/** The user id. */
	@Column(name = "user_id")
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	/** The user name. */
	@Column(name = "user_name", length = USERNAME_LENGTH, unique = true)
	@Basic(fetch = FetchType.EAGER)
	private String userName;

	/** The password. */
	@Column(name = "password", length = PASSWORD_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private String password;

	/** The first name. */
	@Column(name = "first_name", length = FIRSTNAME_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private String firstName;

	/** The last name. */
	@Column(name = "last_name", length = LASTNAME_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private String lastName;

	/** The gender. */
	@Column(name = "gender", length = GENDER_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private String gender;

	/** The user address. */
	@Column(name = "user_address", length = USER_ADDRESS_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private String userAddress;

	/** The user contact. */
	@Column(name = "user_contact", length = USER_CONTACT_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private String userContact;

	/** The email id. */
	@Column(name = "email_id", length = EMAILID_LENGTH)
	@Basic(fetch = FetchType.EAGER)
	private String emailId;

	/** The dob. */
	@Column(name = "dob")
	@Basic(fetch = FetchType.EAGER)
	private String dob;

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(final String gender) {
		this.gender = gender;
	}

	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(final String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * @return the userContact
	 */
	public String getUserContact() {
		return userContact;
	}

	/**
	 * @param userContact the userContact to set
	 */
	public void setUserContact(final String userContact) {
		this.userContact = userContact;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(final String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(final Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
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
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
			if (null == obj) {
				result = false;
			}
			if (getClass() != obj.getClass()) {
				result = false;
			}
			UserMaster other = (UserMaster) obj;
			if (null == userName) {
				if (null != other.userName) {
					result = false;
				}
			} else if (!userName.equals(other.userName)) {
				result = false;
			}
			if (null == userId) {
				if (null != other.userId) {
					result = false;
				}
			} else if (!userId.equals(other.userId)) {
				result = false;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserMaster [userId=" + userId + ", userName=" + userName + "]";
	}
}
