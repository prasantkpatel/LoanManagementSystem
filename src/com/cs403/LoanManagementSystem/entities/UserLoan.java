package com.cs403.LoanManagementSystem.entities;

import java.sql.Date;
import java.sql.Time;

public class UserLoan {

	private String userEmail;
	private int loanId;
	private double amountNeeded;
	private Date lastDateReviewed; // by default date of application
	private Time lastTimeReviewed; // by default time of application
	private String status;

	public double getAmountNeeded() {
		return amountNeeded;
	}

	public void setAmountNeeded(double amountNeeded) {
		this.amountNeeded = amountNeeded;
	}

	public Date getLastDateReviewed() {
		return lastDateReviewed;
	}

	public void setLastDateReviewed(Date lastDateReviewed) {
		this.lastDateReviewed = lastDateReviewed;
	}

	public Time getLastTimeReviewed() {
		return lastTimeReviewed;
	}

	public void setLastTimeReviewed(Time lastTimeReviewed) {
		this.lastTimeReviewed = lastTimeReviewed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UserLoan [userEmail=" + userEmail + ", loanId=" + loanId + ", amountNeeded=" + amountNeeded
				+ ", lastDateReviewed=" + lastDateReviewed + ", lastTimeReviewed=" + lastTimeReviewed + ", status="
				+ status + "]";
	}
}
