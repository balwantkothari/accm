package com.balwant.account.accm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the DEPOSITS database table.
 * 
 */
@Entity
@Table(name="ACCOUNTS.DEPOSITS")
public class Deposit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPOSIT_ID")
	private int depositId;

	@Column(name="DEPOSIT_AMOUNT")
	private double depositAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="DEPOSIT_DATE")
	private Date depositDate;

	@Column(name="DEPOSITS_BY")
	private String depositsBy;

	@Column(name="DEPOSITS_USER")
	private String depositsUser;

	//bi-directional many-to-one association to Loan
	@ManyToOne
	@JoinColumn(name="LOAN_ID")
	@JsonBackReference
	private Loan loan;

	public int getDepositId() {
		return depositId;
	}

	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}

	public double getDepositAmount() {
		return this.depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Date getDepositDate() {
		return this.depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public String getDepositsBy() {
		return this.depositsBy;
	}

	public void setDepositsBy(String depositsBy) {
		this.depositsBy = depositsBy;
	}

	public String getDepositsUser() {
		return this.depositsUser;
	}

	public void setDepositsUser(String depositsUser) {
		this.depositsUser = depositsUser;
	}

	public Loan getLoan() {
		return this.loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}