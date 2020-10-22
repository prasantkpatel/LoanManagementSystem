package com.cs403.LoanManagementSystem.controllers;

import java.sql.SQLException;

import com.cs403.LoanManagementSystem.constants.Message;
import com.cs403.LoanManagementSystem.entities.Admin;
import com.cs403.LoanManagementSystem.entities.User;
import com.cs403.LoanManagementSystem.managers.UserManager;

public class UserController {
	private UserController() {}
	
	private static UserController instance = new UserController();
	
	public static UserController getInstance() {
		return instance;
	}
	
	public String userLogin(String email, String password) throws SQLException {
		User user = UserManager.getInstance().getUser(email);
		
		if(user!=null) {
			if(!user.getPassword().equals(password)) {
				return Message.INCORRECT_PASSWORD;
			}
			else {
				return Message.SUCCESS;
			}
		}
		else {
			return Message.USER_NOT_FOUND;
		}
	}

	public String adminLogin(String email, String password) throws SQLException {
		User user = UserManager.getInstance().getUser(email);
		
		if(user!=null && user instanceof Admin) {
			if(!user.getPassword().equals(password)) {
				return Message.INCORRECT_PASSWORD;
			}
			else {
				return Message.SUCCESS;
			}
		}
		else {
			return Message.USER_NOT_FOUND;
		}
	}
}
