package com.cs403.LoanManagementSystem.controllers;

import java.sql.SQLException;

import com.cs403.LoanManagementSystem.entities.Loan;
import com.cs403.LoanManagementSystem.entities.User;
import com.cs403.LoanManagementSystem.managers.LoanManager;

public class LoanController {
	private LoanController() {
	}

	public static LoanController instance = new LoanController();

	public static LoanController getInstance() {
		return instance;
	}

	public void sanctionLoan(User user, Loan loan) throws SQLException {
		LoanManager.getInstance().sanctionLoan(user, loan);
	}

	public void applyLoan(User user, Loan loan, double principleAmount) throws SQLException {
		LoanManager.getInstance().applyLoan(user, loan, principleAmount);
	}
	
	public void rejectLoan(User user, Loan loan) throws SQLException {
		LoanManager.getInstance().rejectLoan(user, loan);
	}
}
