package com.cs403.LoanManagementSystem.entities;

import java.sql.SQLException;

import com.cs403.LoanManagementSystem.controllers.LoanController;

public class User {

	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String password;
	private String gender;
	private int securityPossesed;
	private double creditScore;
	private double income;

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public void applyLoan(Loan loan, double principleAmount) throws SQLException {
		LoanController.getInstance().applyLoan(this, loan, principleAmount);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(double creditScore) {
		this.creditScore = creditScore;
	}

	public int getSecurityPossesed() {
		return securityPossesed;
	}

	public void setSecurityPossesed(int securityPossesed) {
		this.securityPossesed = securityPossesed;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [ firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email="
				+ email + ", password=" + password + ", gender=" + gender + ", securityPossesed=" + securityPossesed
				+ ", creditScore=" + creditScore + "]";
	}

}
