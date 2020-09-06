package com.cs403.LoanManagementSystem.managers;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import com.cs403.LoanManagementSystem.constants.LoanStatus;
import com.cs403.LoanManagementSystem.dao.LoanDao;
import com.cs403.LoanManagementSystem.entities.Loan;
import com.cs403.LoanManagementSystem.entities.User;
import com.cs403.LoanManagementSystem.entities.UserLoan;

public class LoanManager {
	private LoanManager() {
	}

	private static LoanManager instance = new LoanManager();
	private static LoanDao dao = new LoanDao();

	public static LoanManager getInstance() {
		return instance;
	}

	public Loan createLoan(double interestRate, int[] amountRange, String securityDemand, String source,
			String loanType, int[] repaymentPeriod, double minIncome, int[] ageRange) {
		Loan loan = new Loan();

		loan.setInterestRate(interestRate);
		loan.setSecurityDemand(securityDemand);
		loan.setRepaymentPeriod(repaymentPeriod);
		loan.setLoanType(loanType);
		loan.setSource(source);
		loan.setAgeRange(ageRange);
		loan.setAmountRange(amountRange);
		loan.setMinIncome(minIncome);

		return loan;
	}
	
	public Loan[] getLoans(String loanType) throws SQLException {
		return dao.getLoans(loanType);
	}
	
	public Loan getLoan(int id) throws SQLException {
		return dao.getLoan(id);
	}
	
	public UserLoan[] getUserLoans() throws SQLException {
		return dao.getUserLoans();
	}
	
	public void sanctionLoan(User user, Loan loan) throws SQLException {
		Date date=new Date(System.currentTimeMillis());
		Time time=new Time(System.currentTimeMillis());
		dao.updateLoanStatus(user, loan, date, time, LoanStatus.ACCEPTED);
	}

	public void applyLoan(User user, Loan loan, double principleAmount) throws SQLException {
		Date date=new Date(System.currentTimeMillis());
		Time time=new Time(System.currentTimeMillis());
		dao.addUserLoan(user, loan, principleAmount, date, time, LoanStatus.UNKNOWN);
	}

	public void rejectLoan(User user, Loan loan) throws SQLException {
		Date date=new Date(System.currentTimeMillis());
		Time time=new Time(System.currentTimeMillis());
		dao.updateLoanStatus(user, loan, date, time, LoanStatus.REJECTED);
	}
}
