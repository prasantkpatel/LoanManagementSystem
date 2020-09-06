package com.cs403.LoanManagementSystem.controllers;

import com.cs403.LoanManagementSystem.View;
import javafx.fxml.FXML;

public class HeadScreenController {
	
	@FXML
	public void loadUserLoginScreen() throws Exception {
		new View().loadUserLoginScreen();
	}
	
	@FXML
	public void loadAdminLoginScreen() throws Exception {
		new View().loadAdminLoginScreen();
	}
	
	@FXML
	public void loadRegistrationScreen() throws Exception {
		new View().loadRegistrationScreen();
	}
}
