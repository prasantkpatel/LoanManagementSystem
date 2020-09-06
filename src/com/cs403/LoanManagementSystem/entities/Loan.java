package com.cs403.LoanManagementSystem.entities;

import java.util.Arrays;

public class Loan {
	private double interestRate;
	private int[] amountRange;
	private String securityDemand;
	private String source;
	private String loanType;
	private int[] repaymentPeriod;
	private double minIncome;
	private int[] ageRange;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getAmountRange() {
		return amountRange;
	}

	public void setAmountRange(int[] amountRange) {
		this.amountRange = amountRange;
	}

	public int[] getAgeRange() {
		return ageRange;
	}

	public int[] getRepaymentPeriod() {
		return repaymentPeriod;
	}

	public void setRepaymentPeriod(int[] repaymentPeriod) {
		this.repaymentPeriod = repaymentPeriod;
	}

	public void setAgeRange(int[] ageRange) {
		this.ageRange = ageRange;
	}

	public double getMinIncome() {
		return minIncome;
	}

	public void setMinIncome(double minIncome) {
		this.minIncome = minIncome;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getSecurityDemand() {
		return securityDemand;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public void setSecurityDemand(String securityDemand) {
		this.securityDemand = securityDemand;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", ageRange=" + Arrays.toString(ageRange) + ", minIncome=" + minIncome
				+ ", interestRate=" + interestRate + ", repaymentPeriod=" + Arrays.toString(repaymentPeriod)
				+ ", amountRange=" + Arrays.toString(amountRange) + ", securityDemand=" + securityDemand + ", source="
				+ source + ", loanType=" + loanType + "]";
	}
}
