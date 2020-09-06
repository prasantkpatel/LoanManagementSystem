package com.cs403.LoanManagementSystem.entities;

import java.sql.SQLException;

import com.cs403.LoanManagementSystem.controllers.LoanController;

public class Admin extends User{

	public void sanctionLoan(User user, Loan loan) throws SQLException {
		LoanController.getInstance().sanctionLoan(user, loan);
	}
	
	public void rejectLoan(User user, Loan loan) throws SQLException {
		LoanController.getInstance().rejectLoan(user, loan);
	}
}
