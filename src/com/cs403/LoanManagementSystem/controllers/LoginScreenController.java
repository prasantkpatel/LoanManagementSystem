package com.cs403.LoanManagementSystem.controllers;

import java.util.Optional;
import com.cs403.LoanManagementSystem.View;
import com.cs403.LoanManagementSystem.constants.Message;
import com.cs403.LoanManagementSystem.entities.Admin;
import com.cs403.LoanManagementSystem.managers.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class LoginScreenController {
	@FXML
	public TextField email;
	@FXML
	public PasswordField password;
	
	public Alert alert = new Alert(AlertType.NONE);

	@FXML
	public void userLogin() throws Exception {
		String Email = email.getText();
		String Password = password.getText();
		String loginStatus = UserController.getInstance().userLogin(Email, Password);
		

		if (loginStatus.equals(Message.SUCCESS)) {
			UserScreenController.setUser(UserManager.getInstance().getUser(Email));
			new View().loadUserScreen();
			
		} else if (loginStatus.equals(Message.INCORRECT_PASSWORD)) {
			password.clear();
			alert.setAlertType(AlertType.ERROR);
			alert.setHeaderText(Message.INCORRECT_PASSWORD);
			alert.setContentText("Try Again!");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			    
		} else {
			email.clear();
			password.clear();
			alert.setAlertType(AlertType.CONFIRMATION);
			alert.setHeaderText(Message.USER_NOT_FOUND);
			alert.setContentText("Register ?");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			
			Optional<ButtonType> result = alert.showAndWait();
			
			if(result.isPresent() && result.get() == ButtonType.OK) {
				new View().loadRegistrationScreen();
			}
		}
	}

	@FXML
	public void adminLogin() throws Exception {
		String Email = email.getText();
		String Password = password.getText();
		String loginStatus = UserController.getInstance().adminLogin(Email, Password);

		if (loginStatus.equals(Message.SUCCESS)) {
			AdminScreenController.setAdmin((Admin)UserManager.getInstance().getUser(Email));
			new View().loadAdminScreen();
			
		} else if (loginStatus.equals(Message.INCORRECT_PASSWORD)) {
			password.clear();
			alert.setAlertType(AlertType.ERROR);
			alert.setHeaderText(Message.INCORRECT_PASSWORD);
			alert.setContentText("Try Again!");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			
		} else {
			email.clear();
			password.clear();
			alert.setAlertType(AlertType.WARNING);
			alert.setHeaderText(Message.ADMIN_NOT_FOUND);
			alert.setContentText("Make sure that the Username and Password you entered are correct.");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
		}
	}

	@FXML
	public void back() throws Exception {
		new View().back();
	}
}
