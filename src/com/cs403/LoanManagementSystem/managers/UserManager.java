package com.cs403.LoanManagementSystem.managers;

import java.sql.SQLException;

import com.cs403.LoanManagementSystem.dao.UserDao;
import com.cs403.LoanManagementSystem.entities.Admin;
import com.cs403.LoanManagementSystem.entities.User;

public class UserManager {
	private UserManager() {
	}

	public static UserManager instance = new UserManager();
	public static UserDao dao = new UserDao();

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(String firstName, String lastName, int age, String email, String password, String gender,
			int securityPossesed, double creditScore, double income) {
		User user = new User();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAge(age);
		user.setEmail(email);
		user.setPassword(password);
		user.setGender(gender);
		user.setSecurityPossesed(securityPossesed);
		user.setCreditScore(creditScore);
		user.setIncome(income);

		return user;
	}

	public Admin createAdmin(String firstName, String lastName, int age, String email, String password, String gender,
			int securityPossesed, double creditScore, double income) {
		Admin admin = new Admin();

		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setAge(age);
		admin.setEmail(email);
		admin.setPassword(password);
		admin.setGender(gender);
		admin.setSecurityPossesed(securityPossesed);
		admin.setCreditScore(creditScore);
		admin.setIncome(income);

		return admin;
	}

	public void addUser(User user) throws SQLException {
		dao.addUser(user);
	}

	public User getUser(String email) throws SQLException {
		return dao.getUser(email);
	}

	public User[] getUsers() throws SQLException {
		return dao.getUsers();
	}
}
