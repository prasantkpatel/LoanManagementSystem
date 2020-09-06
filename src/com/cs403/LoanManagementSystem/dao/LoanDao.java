package com.cs403.LoanManagementSystem.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import com.cs403.LoanManagementSystem.DataStore;
import com.cs403.LoanManagementSystem.entities.Loan;
import com.cs403.LoanManagementSystem.entities.User;
import com.cs403.LoanManagementSystem.entities.UserLoan;

public class LoanDao {

	public void addUserLoan(User user, Loan loan, double principleAmount, Date date, Time time, String status)
			throws SQLException {
		DataStore.addUserLoan(user, loan, principleAmount, date, time, status);
	}

	public void updateLoanStatus(User user, Loan loan, Date date, Time time, String status) throws SQLException {
		DataStore.updateLoanStatus(user, loan, date, time, status);
	}

	public Loan[] getLoans(String loanType) throws SQLException {
		return DataStore.getLoans(loanType);
	}

	public Loan getLoan(int id) throws SQLException {
		return DataStore.getLoan(id);
	}

	public UserLoan[] getUserLoans() throws SQLException {
		return DataStore.getUserLoans();
	}

}
