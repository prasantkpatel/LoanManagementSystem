package com.cs403.LoanManagementSystem;


import java.util.Stack;

import com.cs403.LoanManagementSystem.controllers.AdminScreenController;
import com.cs403.LoanManagementSystem.controllers.UserScreenController;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import animatefx.animation.FadeInLeft;
import animatefx.animation.SlideInLeft;
import animatefx.animation.ZoomIn;

public class View extends Application{
	/*public static void browseLoans(User user, Loan[] loans) {
		System.out.println(user.toString() + " is browsing loans...");
		for (Loan loan : loans) {
			if (Math.random() > 0.5) {
				user.applyLoan(loan, Math.random() * 1000000);
			}
		}
	}

	public static void reviewLoans(Admin admin, UserLoan[] userloans) {
		
		System.out.println(admin.getEmail() + " is reviewing loans...");
		
		for (UserLoan userloan : userloans) {
			
			User Applicant = UserManager.getInstance().getUser(userloan.getUserId());
			Loan loan = LoanManager.getInstance().getLoan(userloan.getLoanId());
			double amountNeeded = userloan.getAmountNeeded();
			String status = userloan.getStatus();

			if (status.equals(LoanStatus.UNKNOWN)) {
				int[] amountRange = loan.getAmountRange();
				if (amountNeeded <= amountRange[1] && amountNeeded >= amountRange[0]) {
					
					String securityPossesed = Integer.toString(Applicant.getSecurityPossesed()); // p-np-co
					String securityNeeded = loan.getSecurityDemand();
					
					switch (securityNeeded) {
						case Security.PERSONAL:
							if (securityPossesed.charAt(0) == '1') {
								int[] ageRange = loan.getAgeRange();
								if (Applicant.getIncome() < loan.getMinIncome() || Applicant.getAge() > ageRange[1]
										|| Applicant.getAge() < ageRange[0]) {
									admin.rejectLoan(Applicant, loan);
								} else {
									admin.sanctionLoan(Applicant, loan);
								}
							} else {
								admin.rejectLoan(Applicant, loan);
							}
							break;
	
						case Security.NON_PERSONAL:
							if (securityPossesed.charAt(1) == '1') {
								int[] ageRange = loan.getAgeRange();
								if (Applicant.getIncome() < loan.getMinIncome() || Applicant.getAge() > ageRange[1]
										|| Applicant.getAge() < ageRange[0]) {
									admin.rejectLoan(Applicant, loan);
								} else {
									admin.sanctionLoan(Applicant, loan);
								}
							} else {
								admin.rejectLoan(Applicant, loan);
							}
							break;
	
						case Security.COLLATERAL:
							if (securityPossesed.charAt(2) == '1') {
								int[] ageRange = loan.getAgeRange();
								if (Applicant.getIncome() < loan.getMinIncome() || Applicant.getAge() > ageRange[1]
										|| Applicant.getAge() < ageRange[0]) {
									admin.rejectLoan(Applicant, loan);
								} else {
									admin.sanctionLoan(Applicant, loan);
								}
							} else {
								admin.rejectLoan(Applicant, loan);
							}
							break;
					}

				} else {
					admin.rejectLoan(Applicant, loan);
				}
			}
		}
	}

	*/ //Simulating user interaction prior to GUI development
	
	private static Stack<String> sceneStack=new Stack<>(); 
	private static Stage PrimaryStage;
	
	public static Stage getPrimaryStage() {
		return PrimaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		PrimaryStage = primaryStage;
	}

	public static void launchApplication(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		loadHeadScreen();
	}
	
	private void loadHeadScreen() throws Exception{
		Stage primaryStage=getPrimaryStage();
		ZoomIn effect;
		Parent root = FXMLLoader.load(getClass().getResource("Resources/fxml/HeadScreen.fxml"));
		effect = new ZoomIn(root);
		Scene scene = new Scene(root, 1100, 643);
		String css = this.getClass().getResource("Resources/stylesheets/HeadScreen.css").toExternalForm(); 
		scene.getStylesheets().add(css);
		sceneStack.push("HeadScreen");
		effect.play();
		primaryStage.setTitle("Welcome");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public void loadUserLoginScreen() throws Exception{
		SlideInLeft effect;
		Stage primaryStage=getPrimaryStage();
		Parent root = FXMLLoader.load(getClass().getResource("Resources/fxml/UserLogin.fxml"));
		effect = new SlideInLeft(root);
		Scene scene = new Scene(root, 915, 603);
		String css = this.getClass().getResource("Resources/stylesheets/UserLogin.css").toExternalForm(); 
		scene.getStylesheets().add(css);
		sceneStack.push("UserLogin");
		effect.play();
		primaryStage.setTitle("User-Login");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public void loadAdminLoginScreen() throws Exception{
		SlideInLeft effect;
		Stage primaryStage=getPrimaryStage();
		Parent root = FXMLLoader.load(getClass().getResource("Resources/fxml/AdminLogin.fxml"));
		effect = new SlideInLeft(root);
		Scene scene = new Scene(root, 915, 603);
		String css = this.getClass().getResource("Resources/stylesheets/AdminLogin.css").toExternalForm(); 
		scene.getStylesheets().add(css);
		sceneStack.push("AdminLogin");
		effect.play();
		primaryStage.setTitle("Admin-Login");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public void loadRegistrationScreen() throws Exception {
		FadeInLeft effect;
		Stage primaryStage=getPrimaryStage();
		Parent root = FXMLLoader.load(getClass().getResource("Resources/fxml/RegistrationScreen.fxml"));
		effect = new FadeInLeft(root);
		Scene scene = new Scene(root, 1057, 756);
		String css = this.getClass().getResource("Resources/stylesheets/RegistrationScreen.css").toExternalForm(); 
		scene.getStylesheets().add(css);
		sceneStack.push("RegistrationScreen");
		effect.play();
		primaryStage.setTitle("Register");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public void loadUserScreen() throws Exception{
		ZoomIn effect;
		Stage primaryStage=getPrimaryStage();
		Parent root = FXMLLoader.load(getClass().getResource("Resources/fxml/UserScreen.fxml"));
		effect = new ZoomIn(root);
		Scene scene = new Scene(root, 1627, 1023);
		String css = this.getClass().getResource("Resources/stylesheets/UserScreen.css").toExternalForm(); 
		scene.getStylesheets().add(css);
		sceneStack.push("UserScreen");
		effect.play();
		primaryStage.setTitle("Welcome "+UserScreenController.getUser().getFirstName());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public void loadAdminScreen() throws Exception{
		ZoomIn effect;
		Stage primaryStage=getPrimaryStage();
		Parent root = FXMLLoader.load(getClass().getResource("Resources/fxml/AdminScreen.fxml"));
		effect = new ZoomIn(root);
		Scene scene = new Scene(root, 1627, 1023);
		String css = this.getClass().getResource("Resources/stylesheets/AdminScreen.css").toExternalForm(); 
		scene.getStylesheets().add(css);
		sceneStack.push("AdminScreen");
		effect.play();
		primaryStage.setTitle("Welcome "+AdminScreenController.getAdmin().getFirstName());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public void back() throws Exception {
		sceneStack.pop();
		switch(sceneStack.pop()) {
		
			case "HeadScreen":
				loadHeadScreen();
				break;
				
			case "UserLogin":
				loadUserLoginScreen();
				break;
				
			case "AdminLogin":
				loadAdminLoginScreen();
				break;
				
			case "Register":
				loadRegistrationScreen();
				break;	
			
			case "UserScreen":
				loadUserScreen();
				break;
			
			case "AdminScreen":
				loadAdminScreen();
				break;
			
			default:
				break;
		}
	}
}
