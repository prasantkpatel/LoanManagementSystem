package com.cs403.LoanManagementSystem.entities;

public class UserModel {
	private String firstName;
	private String lastName;
	private Integer age;
	private String email;
	private String gender;
	private Double income;
	private Double creditScore;
	private String securityPossesed;
	
	public UserModel(String firstName, String lastName, Integer age, String email, String gender, Double income,
			Double creditScore, String securityPossesed) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.income = income;
		this.creditScore = creditScore;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Double getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(Double creditScore) {
		this.creditScore = creditScore;
	}
	public String getSecurityPossesed() {
		return securityPossesed;
	}
	public void setSecurityPossesed(String securityPossesed) {
		this.securityPossesed = securityPossesed;
	}
}
