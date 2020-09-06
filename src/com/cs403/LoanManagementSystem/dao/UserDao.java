package com.cs403.LoanManagementSystem.dao;

import java.sql.SQLException;

import com.cs403.LoanManagementSystem.DataStore;
import com.cs403.LoanManagementSystem.entities.User;

public class UserDao {
	public User[] getUsers() throws SQLException{
		return DataStore.getUsers();
	}

	public void addUser(User user) throws SQLException {
		DataStore.addUser(user);
	}
	
	public User getUser(String email) throws SQLException {
		return DataStore.getUser(email);
	}
}
