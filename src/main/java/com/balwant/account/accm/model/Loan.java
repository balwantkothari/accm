package com.balwant.account.accm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.balwant.account.accm.util.AccmUtils;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the LOAN database table.
 * 
 */
@Entity
@Table(name="ACCOUNTS.LOAN")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Transient
	private final StringBuilder builder = new StringBuilder();

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOAN_ID")
	private Integer loanId;

	@Column(name="COMMENT")
	private String comment;

	private String item;

	@Column(name="LOAN_AMOUNT")
	private Double loanAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="LOAN_DATE")
	private Date loanDate;

	@Column(name="LOAN_STATUS")
	private LoanStatus loanStatus;

	@Column(name="LOAN_TYPE")
	private Integer loanType;

	@Transient
	Map<Date, Double> amountDetails;
	
	private Float rate;

	//bi-directional many-to-one association to Deposit
	@OneToMany(mappedBy="loan")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	private Set<Deposit> deposits;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	@JsonBackReference
	private Customer customer;

	public Integer getLoanId() {
		return this.loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanDate() {
		return this.loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public LoanStatus getLoanStatus() {
		return this.loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

	public Integer getLoanType() {
		return this.loanType;
	}

	public void setLoanType(Integer loanType) {
		this.loanType = loanType;
	}

	public Float getRate() {
		return this.rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Set<Deposit> getDeposits() {
		return this.deposits;
	}

	public void setDeposits(Set<Deposit> deposits) {
		this.deposits = deposits;
	}

	public Deposit addDeposit(Deposit deposit) {
		getDeposits().add(deposit);
		deposit.setLoan(this);

		return deposit;
	}

	public Deposit removeDeposit(Deposit deposit) {
		getDeposits().remove(deposit);
		deposit.setLoan(null);

		return deposit;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Map<Date, Double> getAmountDetails() {
		return amountDetails;
	}

	public void setAmountDetails(Map<Date, Double> amountDetails) {
		this.amountDetails = amountDetails;
	}

	
	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		
		if(!(obj instanceof Loan))
			return false;
		
		Loan loan = (Loan)obj;
		if(this.getLoanId() == loan.getLoanId()) 
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		builder.setLength(0);
		builder.append("Loan [loanId=");
		builder.append(loanId);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", item=");
		builder.append(item);
		builder.append(", loanAmount=");
		builder.append(loanAmount);
		builder.append(", loanDate=");
		builder.append(loanDate);
		builder.append(", loanStatus=");
		builder.append(loanStatus);
		builder.append(", loanType=");
		builder.append(loanType);
		builder.append(", amountDetails={ ");
		if(!AccmUtils.isNullOrEmpty(amountDetails)) {
			 builder.append(amountDetails.entrySet().stream()
			  .map(entry -> "[Date :" + entry.getKey() + ", Amount :" + entry.getValue() + "]")
			  .collect(Collectors.joining(", ")));
		} 
		builder.append(" }");
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", deposits={ ");
		if(!AccmUtils.isNullOrEmpty(deposits)) {
			builder.append(deposits.stream().map(deposit -> "[Deposit Date : "+ deposit.getDepositDate() + ", Amount : " + deposit.getDepositAmount())
					.collect(Collectors.joining("], ")));
		}
		builder.append(" }");
		builder.append(", customerId=");
		builder.append(customer.getCustId());
		builder.append("]");
		return builder.toString();
	}		
}