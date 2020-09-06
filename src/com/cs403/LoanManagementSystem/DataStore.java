package com.cs403.LoanManagementSystem;

import com.cs403.LoanManagementSystem.constants.UserType;
import com.cs403.LoanManagementSystem.entities.Admin;
import com.cs403.LoanManagementSystem.entities.Loan;
import com.cs403.LoanManagementSystem.entities.User;
import com.cs403.LoanManagementSystem.entities.UserLoan;
import com.cs403.LoanManagementSystem.managers.LoanManager;
import com.cs403.LoanManagementSystem.managers.UserManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class DataStore {
	private static Connection connect;

	public static void addUserLoan(User user, Loan loan, double principalTaken, Date date, Time time, String status)
			throws SQLException {
		String query = "INSERT INTO UserLoan VALUES(?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = connect.prepareStatement(query);
		statement.setString(1, user.getEmail());
		statement.setInt(2, loan.getId());
		statement.setDouble(3, principalTaken);
		statement.setDate(4, date);
		statement.setTime(5, time);
		statement.setString(6, status);

		statement.executeUpdate();
	}

	public static void addUser(User user) throws SQLException {
		String query = "INSERT INTO User VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = connect.prepareStatement(query);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setInt(3, user.getAge());
		statement.setString(4, user.getEmail());
		statement.setString(5, user.getPassword());
		statement.setString(6, user.getGender());
		statement.setInt(7, user.getSecurityPossesed());
		statement.setDouble(8, user.getCreditScore());
		statement.setDouble(10, user.getIncome());

		if (user instanceof Admin) {
			statement.setString(9, UserType.ADMIN);
		} else {
			statement.setString(9, UserType.GENERAL);
		}

		statement.executeUpdate();
	}

	public static User[] getUsers() throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		User[] users;
		String query = "SELECT * FROM User";
		Statement statement = connect.createStatement();
		ResultSet result = statement.executeQuery(query);

		while (result.next()) {
			User user;

			String firstName = result.getString(1);
			String lastName = result.getString(2);
			int age = result.getInt(3);
			String email = result.getString(4);
			String password = result.getString(5);
			String gender = result.getString(6);
			int securityPossesed = result.getInt(7);
			double creditScore = result.getDouble(8);
			String privilege = result.getString(9);
			double Income = result.getDouble(10);

			if (privilege.equals(UserType.ADMIN)) {
				user = UserManager.getInstance().createAdmin(firstName, lastName, age, email, password, gender,
						securityPossesed, creditScore, Income);
			} else {
				user = UserManager.getInstance().createUser(firstName, lastName, age, email, password, gender,
						securityPossesed, creditScore, Income);
			}

			list.add(user);
		}
		users = list.toArray(new User[list.size()]);
		return users;
	}

	public static Loan[] getLoans(String LoanType) throws SQLException {
		ArrayList<Loan> list = new ArrayList<>();
		Loan[] loans;
		String query;
		ResultSet result;

		if (LoanType.equals("*")) {
			query = "SELECT * FROM Loan";
			Statement statement = connect.createStatement();
			result = statement.executeQuery(query);
		} else {
			query = "SELECT * FROM Loan WHERE LoanType=?";
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setString(1, LoanType);
			result = statement.executeQuery();
		}

		while (result.next()) {
			Loan loan;

			double InterestRate = result.getDouble(1);
			int PrincipalLB = result.getInt(2);
			int PrincipalUB = result.getInt(3);
			String securityNeeded = result.getString(4);
			String loanSource = result.getString(5);
			String loanType = result.getString(6);
			int RepaymentPeriodLB = result.getInt(7);
			int RepaymentPeriodUB = result.getInt(8);
			double MinimumIncome = result.getDouble(9);
			int AgeLB = result.getInt(10);
			int AgeUB = result.getInt(11);
			int id = result.getInt(12);

			loan = LoanManager.getInstance().createLoan(InterestRate, new int[] { PrincipalLB, PrincipalUB },
					securityNeeded, loanSource, loanType, new int[] { RepaymentPeriodLB, RepaymentPeriodUB },
					MinimumIncome, new int[] { AgeLB, AgeUB });
			loan.setId(id);

			list.add(loan);
		}
		loans = list.toArray(new Loan[list.size()]);
		return loans;
	}

	public static UserLoan[] getUserLoans() throws SQLException {
		ArrayList<UserLoan> list = new ArrayList<>();
		UserLoan[] userLoan;
		String query = "SELECT * FROM UserLoan";

		Statement statement = connect.createStatement();
		ResultSet result = statement.executeQuery(query);

		while (result.next()) {
			UserLoan userloan = new UserLoan();

			userloan.setUserEmail(result.getString(1));
			userloan.setLoanId(result.getInt(2));
			userloan.setAmountNeeded(result.getDouble(3));
			userloan.setLastDateReviewed(result.getDate(4));
			userloan.setLastTimeReviewed(result.getTime(5));
			userloan.setStatus(result.getString(6));

			list.add(userloan);
		}
		userLoan = list.toArray(new UserLoan[list.size()]);
		return userLoan;
	}

	public static User getUser(String email) throws SQLException {
		String query = "SELECT * FROM User WHERE Email=?";

		PreparedStatement statement = connect.prepareStatement(query);
		statement.setString(1, email);

		ResultSet result = statement.executeQuery();

		if (result.next()) {

			User user;

			String firstName = result.getString(1);
			String lastName = result.getString(2);
			int age = result.getInt(3);
			String password = result.getString(5);
			String gender = result.getString(6);
			int securityPossesed = result.getInt(7);
			double creditScore = result.getDouble(8);
			String privilege = result.getString(9);
			double Income = result.getDouble(10);

			if (privilege.equals(UserType.ADMIN)) {
				user = UserManager.getInstance().createAdmin(firstName, lastName, age, email, password, gender,
						securityPossesed, creditScore, Income);

			} else {
				user = UserManager.getInstance().createUser(firstName, lastName, age, email, password, gender,
						securityPossesed, creditScore, Income);
			}

			return user;
		} else {
			return null;
		}
	}

	public static Loan getLoan(int id) throws SQLException {
		String query = "SELECT * FROM Loan WHERE id=?";

		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, id);

		ResultSet result = statement.executeQuery();
		result.next();

		Loan loan;

		double InterestRate = result.getDouble(1);
		int PrincipalLB = result.getInt(2);
		int PrincipalUB = result.getInt(3);
		String securityNeeded = result.getString(4);
		String loanSource = result.getString(5);
		String loanType = result.getString(6);
		int RepaymentPeriodLB = result.getInt(7);
		int RepaymentPeriodUB = result.getInt(8);
		double MinimumIncome = result.getDouble(9);
		int AgeLB = result.getInt(10);
		int AgeUB = result.getInt(11);

		loan = LoanManager.getInstance().createLoan(InterestRate, new int[] { PrincipalLB, PrincipalUB },
				securityNeeded, loanSource, loanType, new int[] { RepaymentPeriodLB, RepaymentPeriodUB }, MinimumIncome,
				new int[] { AgeLB, AgeUB });
		loan.setId(id);

		return loan;

	}

	public static void updateLoanStatus(User user, Loan loan, Date date, Time time, String status) throws SQLException {
		String query = "UPDATE UserLoan SET status = ?, Date=?, Time=? WHERE userEmail = ? AND loanId = ?";

		PreparedStatement statement = connect.prepareStatement(query);

		statement.setString(1, status);
		statement.setDate(2, date);
		statement.setTime(3, time);
		statement.setString(4, user.getEmail());
		statement.setInt(5, loan.getId());

		statement.executeUpdate();
	}

	public static void loadData(String database, String username, String password) {
		try {
			connect = DriverManager.getConnection(database, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
