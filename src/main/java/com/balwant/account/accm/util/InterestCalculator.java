package com.balwant.account.accm.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.balwant.account.accm.model.Deposit;
import com.balwant.account.accm.model.Loan;

public class InterestCalculator {
	
	private boolean calculateSimpleInterest;
	
	private int reviseInMonths;
	
	public boolean isCalculateSimpleInterest() {
		return calculateSimpleInterest;
	}

	public void setCalculateSimpleInterest(boolean calculateSimpleInterest) {
		this.calculateSimpleInterest = calculateSimpleInterest;
	}

	public int getReviseInMonths() {
		return reviseInMonths;
	}

	public void setReviseInMonths(int compoundedInMonths) {
		this.reviseInMonths = compoundedInMonths;
	}

	public Map<Date, Double> getFinalAmount(Loan loan) {
		double principal = loan.getLoanAmount();
		Date loanDate = loan.getLoanDate();
		Set<Deposit> deposits = loan.getDeposits();
		float rate = loan.getRate();
		return calculateAmount(principal, rate, loanDate, deposits);
	}
	
	private Map<Date, Double> calculateAmount(double principal, float rate, Date loanDate, Set<Deposit> deposits) {
		Date finalDate = new Date(System.currentTimeMillis());
		Map<Date,Double> amountDetails = new LinkedHashMap<Date, Double>();
		double amount = principal;
		Date initialLoanDate = loanDate;
		Calendar cal = Calendar.getInstance();
		for(Deposit deposit : deposits) {
			getInterestAmount(amount, rate, initialLoanDate, deposit.getDepositDate(), amountDetails);
			cal.setTime(deposit.getDepositDate());
			cal.add(Calendar.DATE, 1);
			initialLoanDate= cal.getTime();
		}
		return getInterestAmount(amount, rate, initialLoanDate, finalDate, amountDetails);
		
	}
	
	private Map<Date, Double> getInterestAmount(double principal, float rate, Date loanDate, Date depositDate, Map<Date, Double> amountDetails) {
		if(isCalculateSimpleInterest()) {
			return getSimpleInterestAmount(principal, rate, loanDate, depositDate, amountDetails);
		} else {
			return getComoundInterestAmount(principal, rate, loanDate, depositDate, amountDetails);
		}
	}
	
	private Map<Date, Double> getComoundInterestAmount(double principal, float rate, Date loanDate, Date depositDate, Map<Date, Double> amountDetails) {
		Calendar loanCal = new GregorianCalendar();
		loanCal.setTime(loanDate);
		
		Calendar depositCal = new GregorianCalendar();
		depositCal.setTime(depositDate);
		
		int loanYear = loanCal.get(Calendar.YEAR);
		int loanMonth = loanCal.get(Calendar.MONTH);
		int loanDay = loanCal.get(Calendar.DAY_OF_MONTH);
		
		int depositYear = depositCal.get(Calendar.YEAR);
		int depositMonth = depositCal.get(Calendar.MONTH);
		int depositDay = depositCal .get(Calendar.DAY_OF_MONTH);
		
		double amount = principal;
		double timeInMonths = (((depositYear - loanYear )*12 + (depositMonth-loanMonth) + (depositDay-loanDay)/30));
		System.out.println("Loan Date :" + loanDate.toGMTString());
		System.out.println("Final Date :" + depositDate.toGMTString());		
		System.out.println("Time in Months :" + timeInMonths);
		if(timeInMonths > getReviseInMonths()) {
			while(timeInMonths > getReviseInMonths()) {
				loanCal.add(Calendar.MONTH, getReviseInMonths());
				amount = amount + (amount * getReviseInMonths() * rate)/100;
				amountDetails.put(loanCal.getTime(), amount);
				timeInMonths = timeInMonths - getReviseInMonths();
			}
		}
		amount = amount + (amount * timeInMonths * rate)/100;
		amountDetails.put(depositDate, amount);
		
		return amountDetails;
	}
	
	private Map<Date, Double> getSimpleInterestAmount(double principal, float rate, Date loanDate, Date depositDate, Map<Date, Double> amountDetails) {
		Calendar loanCal = new GregorianCalendar();
		loanCal.setTime(loanDate);
		
		Calendar depositCal = new GregorianCalendar();
		depositCal.setTime(depositDate);
		
		int loanYear = loanCal.get(Calendar.YEAR);
		int loanMonth = loanCal.get(Calendar.MONTH);
		int loanDay = loanCal.get(Calendar.DAY_OF_MONTH);
		
		int depositYear = depositCal.get(Calendar.YEAR);
		int depositMonth = depositCal.get(Calendar.MONTH);
		int depositDay = depositCal .get(Calendar.DAY_OF_MONTH);
		
		double amount = 0;
		double timeInMonths = (((loanYear - depositYear)*12 + (loanMonth-depositMonth) + (loanDay-depositDay)/30));
		if(timeInMonths > getReviseInMonths()) {
			while(timeInMonths > getReviseInMonths()) {
				loanCal.add(Calendar.MONTH, getReviseInMonths());
				amount = amount + (principal * getReviseInMonths() * rate)/100;
				amountDetails.put(loanCal.getTime(), amount);
				timeInMonths = timeInMonths - getReviseInMonths();
			}
		}
		amount = amount + (principal * timeInMonths * rate)/100;
		amountDetails.put(depositDate, amount);
		return amountDetails;
	}

	
	
}
