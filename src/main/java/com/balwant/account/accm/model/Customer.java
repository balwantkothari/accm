package com.balwant.account.accm.model;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.balwant.account.accm.util.AccmUtils;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name="ACCOUNTS.CUSTOMER")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Transient
	private final StringBuilder builder = new StringBuilder();

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUST_ID")
	private Integer custId;

	private String address;

	private String name;

	@Column(name="PARENT_NAME")
	private String parentName;

	private Integer phone;

	private String village;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="customer")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	private Set<Loan> loans;

	public Integer getCustId() {
		return this.custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getVillage() {
		return this.village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public Set<Loan> getLoans() {
		return this.loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	public Loan addLoan(Loan loan) {
		getLoans().add(loan);
		loan.setCustomer(this);

		return loan;
	}

	public Loan removeLoan(Loan loan) {
		getLoans().remove(loan);
		loan.setCustomer(null);

		return loan;
	}

	@Override
	public String toString() {
		builder.setLength(0);
		builder.append("Customer [custId=");
		builder.append(custId);
		builder.append(", address=");
		builder.append(address);
		builder.append(", name=");
		builder.append(name);
		builder.append(", parentName=");
		builder.append(parentName);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", village=");
		builder.append(village);
		builder.append(", loanIds = {");
		if(!AccmUtils.isNullOrEmpty(loans)) {
			builder.append(loans.stream().map(loan -> (loan.getLoanId()).toString()).collect(Collectors.joining(",")));			
		}
		builder.append("}");
		builder.append("]");
		return builder.toString();
	}
	
}