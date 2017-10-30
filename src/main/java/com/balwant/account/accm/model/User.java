package com.balwant.account.accm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="ACCOUNTS.USERS")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private final StringBuilder builder = new StringBuilder();

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer userId;

	private String password;

	private String username;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		builder.setLength(0);
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", password=");
		builder.append(password);
		builder.append(", username=");
		builder.append(username);
		builder.append("]");
		return builder.toString();
	}

}