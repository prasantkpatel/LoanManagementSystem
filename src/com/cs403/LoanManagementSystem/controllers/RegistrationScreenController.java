package com.cs403.LoanManagementSystem.controllers;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

import com.cs403.LoanManagementSystem.View;
import com.cs403.LoanManagementSystem.constants.Gender;
import com.cs403.LoanManagementSystem.entities.User;
import com.cs403.LoanManagementSystem.managers.UserManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationScreenController {
	@FXML
	public TextField firstName;
	@FXML
	public TextField lastName;
	@FXML
	public TextField age;
	@FXML
	public TextField income;
	@FXML
	public TextField email;
	@FXML
	public PasswordField password;
	@FXML
	public TextField creditScore;
	@FXML
	public MenuButton gender;
	@FXML
	public MenuItem male;
	@FXML
	public MenuItem female;
	@FXML
	public MenuItem transgender;
	@FXML
	public CheckBox personal;
	@FXML
	public CheckBox nonPersonal;
	@FXML
	public CheckBox collateral;

	Alert alert = new Alert(AlertType.NONE);

	@FXML
	public void Register() throws Exception {
		User user;

		if (getFirstName() == null || getLastName() == null || getAge() == -1 || getEmail() == null
				|| getPassword() == null || getGender() == null || getIncome() == -1 || getCreditScore() == -1) {
			return;
		} else {
			user = UserManager.getInstance().createUser(getFirstName(), getLastName(), getAge(), getEmail(),
					getPassword(), getGender(), getSecurityPossesed(), getCreditScore(), getIncome());
			try {
				UserManager.getInstance().addUser(user);
				succuessfulRegistrationHandler();
			} catch (SQLIntegrityConstraintViolationException e) {
				existingUserHandler();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public String getFirstName() {
		if (firstName.getText().equals("")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText("Fields marked mandatory can't be left empty.");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			return null;
		} else {
			return firstName.getText();
		}
	}

	public String getLastName() {
		if (lastName.getText().equals("")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText("Fields marked mandatory can't be left empty.");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			return null;
		} else {
			return lastName.getText();
		}
	}

	public int getAge() {
		if (age.getText().equals("")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText("Fields marked mandatory can't be left empty.");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			return -1;
		} else {
			try {
				return Integer.parseInt(age.getText());
			} catch (Exception e) {
				age.clear();
				alert.setAlertType(AlertType.ERROR);
				alert.setContentText("Age is filled with an invalid value.");
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.showAndWait();
				return -1;
			}
		}
	}

	public double getIncome() {
		if (income.getText().equals("")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText("Fields marked mandatory can't be left empty.");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			return -1;
		} else {
			try {
				return Double.parseDouble(income.getText());
			} catch (Exception e) {
				income.clear();
				alert.setAlertType(AlertType.ERROR);
				alert.setContentText("Income is filled with an invalid value.");
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.showAndWait();
				return -1;
			}
		}
	}

	public String getEmail() {
		if (email.getText().equals("")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText("Fields marked mandatory can't be left empty.");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			return null;
		} else {
			return email.getText();
		}
	}

	public String getPassword() {
		if (password.getText().equals("")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText("Fields marked mandatory can't be left empty.");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			return null;
		} else {
			return password.getText();
		}
	}

	public double getCreditScore() {
		if (creditScore.getText().equals("")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText("Fields marked mandatory can't be left empty.");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			return -1;
		} else {
			try {
				return Double.parseDouble(creditScore.getText());
			} catch (Exception e) {
				creditScore.clear();
				alert.setAlertType(AlertType.ERROR);
				alert.setContentText("Credit Score is filled with an invalid value.");
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.showAndWait();
				return -1;
			}
		}
	}

	public String getGender() {
		if (!gender.getText().equals(Gender.MALE) && !gender.getText().equals(Gender.FEMALE)
				&& !gender.getText().equals(Gender.TRANSGENDER)) {
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText("Fields marked mandatory can't be left empty.");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.showAndWait();
			return null;
		} else {
			return gender.getText();
		}
	}

	public int getSecurityPossesed() {
		StringBuilder build = new StringBuilder();
		if (personal.isSelected()) {
			build.append('1');
		} else {
			build.append('0');
		}
		if (nonPersonal.isSelected()) {
			build.append('1');
		} else {
			build.append('0');
		}
		if (collateral.isSelected()) {
			build.append(1);
		} else {
			build.append('0');
		}

		return Integer.parseInt(build.toString());
	}

	public void existingUserHandler() {
		email.clear();
		alert.setAlertType(AlertType.ERROR);
		alert.setHeaderText("Email is taken!");
		alert.setContentText("User with the provided email already exists. Please choose another email.");
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.showAndWait();
	}

	public void clearAllFields() {
		firstName.clear();
		lastName.clear();
		age.clear();
		income.clear();
		email.clear();
		password.clear();
		creditScore.clear();
		gender.setText("Choose");
		personal.setSelected(false);
		nonPersonal.setSelected(false);
		collateral.setSelected(false);
	}

	public void succuessfulRegistrationHandler() throws Exception {
		clearAllFields();
		alert.setAlertType(AlertType.CONFIRMATION);
		alert.setHeaderText("Registeration Successful!");
		alert.setContentText("Head to login page?");
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {
			new View().loadUserLoginScreen();
		}
	}

	@FXML
	public void setMenuButtonText(ActionEvent e) {
		if (((MenuItem) e.getSource()).getText().equals(Gender.MALE)) {
			gender.setText(Gender.MALE);
		} else if (((MenuItem) e.getSource()).getText().equals(Gender.FEMALE)) {
			gender.setText(Gender.FEMALE);
		} else {
			gender.setText(Gender.TRANSGENDER);
		}
	}

	@FXML
	public void back() throws Exception {
		new View().back();
	}
}
