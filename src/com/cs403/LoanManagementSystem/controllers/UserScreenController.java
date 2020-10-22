package com.cs403.LoanManagementSystem.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.cs403.LoanManagementSystem.View;
import com.cs403.LoanManagementSystem.constants.LoanType;
import com.cs403.LoanManagementSystem.entities.Loan;
import com.cs403.LoanManagementSystem.entities.LoanModel;
import com.cs403.LoanManagementSystem.entities.User;
import com.cs403.LoanManagementSystem.managers.LoanManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class UserScreenController implements Initializable {

	@FXML
	public Button btnHomeLoans;
	@FXML
	public Button btnEducationLoans;
	@FXML
	public Button btnCarLoans;
	@FXML
	public Button btnMyLoans;
	@FXML
	public Label lblButtonInfo;
	@FXML
	public Pane pnButtonInfo;
	@FXML
	public GridPane educationLoansGrid;
	@FXML
	public GridPane carLoansGrid;
	@FXML
	public GridPane homeLoansGrid;
	@FXML
	public TableView<LoanModel> homeLoansTable;
	@FXML
	public TableView<LoanModel> educationLoansTable;
	@FXML
	public TableView<LoanModel> carLoansTable;
	@FXML
	public TableColumn<LoanModel, Integer> HloanUniqueId;
	@FXML
	public TableColumn<LoanModel, String> Hsource;
	@FXML
	public TableColumn<LoanModel, String> HamountRange;
	@FXML
	public TableColumn<LoanModel, String> HsecurityDemand;
	@FXML
	public TableColumn<LoanModel, Double> HinterestRate;
	@FXML
	public TableColumn<LoanModel, Double> HminimumIncome;
	@FXML
	public TableColumn<LoanModel, String> HageRange;
	@FXML
	public TableColumn<LoanModel, String> Htenure;
	@FXML
	public TableColumn<LoanModel, Integer> EloanUniqueId;
	@FXML
	public TableColumn<LoanModel, String> Esource;
	@FXML
	public TableColumn<LoanModel, String> EamountRange;
	@FXML
	public TableColumn<LoanModel, String> EsecurityDemand;
	@FXML
	public TableColumn<LoanModel, Double> EinterestRate;
	@FXML
	public TableColumn<LoanModel, Double> EminimumIncome;
	@FXML
	public TableColumn<LoanModel, String> EageRange;
	@FXML
	public TableColumn<LoanModel, String> Etenure;
	@FXML
	public TableColumn<LoanModel, Integer> CloanUniqueId;
	@FXML
	public TableColumn<LoanModel, String> Csource;
	@FXML
	public TableColumn<LoanModel, String> CamountRange;
	@FXML
	public TableColumn<LoanModel, String> CsecurityDemand;
	@FXML
	public TableColumn<LoanModel, Double> CinterestRate;
	@FXML
	public TableColumn<LoanModel, Double> CminimumIncome;
	@FXML
	public TableColumn<LoanModel, String> CageRange;
	@FXML
	public TableColumn<LoanModel, String> Ctenure;
	@FXML
	public TextField HtextFieldId;
	@FXML
	public TextField HtextFieldAmount;
	@FXML
	public TextField EtextFieldId;
	@FXML
	public TextField EtextFieldAmount;
	@FXML
	public TextField CtextFieldId;
	@FXML
	public TextField CtextFieldAmount;
	@FXML
	public TextField resultField;

	public static User user = new User();

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		UserScreenController.user = user;
	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		HloanUniqueId.setCellValueFactory(new PropertyValueFactory<>("loanUniqueId"));
		Hsource.setCellValueFactory(new PropertyValueFactory<>("source"));
		HamountRange.setCellValueFactory(new PropertyValueFactory<>("amountRange"));
		HsecurityDemand.setCellValueFactory(new PropertyValueFactory<>("securityDemand"));
		HinterestRate.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
		HminimumIncome.setCellValueFactory(new PropertyValueFactory<>("minimumIncome"));
		HageRange.setCellValueFactory(new PropertyValueFactory<>("ageRange"));
		Htenure.setCellValueFactory(new PropertyValueFactory<>("tenure"));

		EloanUniqueId.setCellValueFactory(new PropertyValueFactory<>("loanUniqueId"));
		Esource.setCellValueFactory(new PropertyValueFactory<>("source"));
		EamountRange.setCellValueFactory(new PropertyValueFactory<>("amountRange"));
		EsecurityDemand.setCellValueFactory(new PropertyValueFactory<>("securityDemand"));
		EinterestRate.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
		EminimumIncome.setCellValueFactory(new PropertyValueFactory<>("minimumIncome"));
		EageRange.setCellValueFactory(new PropertyValueFactory<>("ageRange"));
		Etenure.setCellValueFactory(new PropertyValueFactory<>("tenure"));

		CloanUniqueId.setCellValueFactory(new PropertyValueFactory<>("loanUniqueId"));
		Csource.setCellValueFactory(new PropertyValueFactory<>("source"));
		CamountRange.setCellValueFactory(new PropertyValueFactory<>("amountRange"));
		CsecurityDemand.setCellValueFactory(new PropertyValueFactory<>("securityDemand"));
		CinterestRate.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
		CminimumIncome.setCellValueFactory(new PropertyValueFactory<>("minimumIncome"));
		CageRange.setCellValueFactory(new PropertyValueFactory<>("ageRange"));
		Ctenure.setCellValueFactory(new PropertyValueFactory<>("tenure"));

	}

	@FXML
	public void loadHomeLoans(ActionEvent e) throws SQLException {
		setLabelAndBackground(e);
		homeLoansGrid.toFront();

		Loan[] homeLoans = LoanManager.getInstance().getLoans(LoanType.HOME_LOAN);
		ObservableList<LoanModel> homeLoansList = FXCollections.observableArrayList();

		for (Loan homeLoan : homeLoans) {
			LoanModel model = new LoanModel(homeLoan.getId(), homeLoan.getSource(),
					integerRangeToString(homeLoan.getAmountRange()), homeLoan.getSecurityDemand(),
					homeLoan.getInterestRate(), homeLoan.getMinIncome(), integerRangeToString(homeLoan.getAgeRange()),
					integerRangeToString(homeLoan.getRepaymentPeriod()));
			homeLoansList.add(model);
		}
		homeLoansTable.setItems(homeLoansList);
	}

	@FXML
	public void loadCarLoans(ActionEvent e) throws SQLException {
		setLabelAndBackground(e);
		carLoansGrid.toFront();

		Loan[] carLoans = LoanManager.getInstance().getLoans(LoanType.CAR_LOAN);
		ObservableList<LoanModel> carLoansList = FXCollections.observableArrayList();

		for (Loan carLoan : carLoans) {
			LoanModel model = new LoanModel(carLoan.getId(), carLoan.getSource(),
					integerRangeToString(carLoan.getAmountRange()), carLoan.getSecurityDemand(),
					carLoan.getInterestRate(), carLoan.getMinIncome(), integerRangeToString(carLoan.getAgeRange()),
					integerRangeToString(carLoan.getRepaymentPeriod()));
			carLoansList.add(model);
		}
		carLoansTable.setItems(carLoansList);
	}

	@FXML
	public void loadEducationLoans(ActionEvent e) throws SQLException {
		setLabelAndBackground(e);
		educationLoansGrid.toFront();

		Loan[] educationLoans = LoanManager.getInstance().getLoans(LoanType.EDUCATION_LOAN);
		ObservableList<LoanModel> educationLoansList = FXCollections.observableArrayList();

		for (Loan educationLoan : educationLoans) {
			LoanModel model = new LoanModel(educationLoan.getId(), educationLoan.getSource(),
					integerRangeToString(educationLoan.getAmountRange()), educationLoan.getSecurityDemand(),
					educationLoan.getInterestRate(), educationLoan.getMinIncome(),
					integerRangeToString(educationLoan.getAgeRange()),
					integerRangeToString(educationLoan.getRepaymentPeriod()));
			educationLoansList.add(model);
		}
		educationLoansTable.setItems(educationLoansList);
	}
	public void setLabelAndBackground(ActionEvent e) {
		if (e.getSource() == btnHomeLoans) {
			lblButtonInfo.setText("Home Loans");
			pnButtonInfo.setBackground(
					new Background(new BackgroundFill(Color.rgb(188, 19, 254), CornerRadii.EMPTY, Insets.EMPTY)));

		} else if (e.getSource() == btnEducationLoans) {
			lblButtonInfo.setText("Education Loans");
			pnButtonInfo.setBackground(
					new Background(new BackgroundFill(Color.rgb(229, 96, 36), CornerRadii.EMPTY, Insets.EMPTY)));

		} else if (e.getSource() == btnCarLoans) {
			lblButtonInfo.setText("Car Loans");
			pnButtonInfo.setBackground(
					new Background(new BackgroundFill(Color.rgb(143, 0, 241), CornerRadii.EMPTY, Insets.EMPTY)));

		} else if (e.getSource() == btnMyLoans) {
			lblButtonInfo.setText("My Loans");
			pnButtonInfo.setBackground(
					new Background(new BackgroundFill(Color.rgb(6, 194, 172), CornerRadii.EMPTY, Insets.EMPTY)));

		}
	}

	@FXML
	public void HhandleApply() {
		try {
			int loanId = Integer.parseInt(HtextFieldId.getText());
			double amount = Double.parseDouble(HtextFieldAmount.getText());
			Loan loan = LoanManager.getInstance().getLoan(loanId);

			user.applyLoan(loan, amount);
		} catch (NumberFormatException e) {
			HtextFieldId.clear();
			HtextFieldAmount.clear();
			HtextFieldId.setPromptText("Enter the Loan Unique Id");
			HtextFieldAmount.setPromptText("Enter the Amount");
			resultField.setText("Please enter a valid id and amount");
		} catch (SQLIntegrityConstraintViolationException e) {
			resultField.setText("You have already applied for this loan");
		} catch (SQLException e) {
			HtextFieldId.clear();
			HtextFieldAmount.clear();
			HtextFieldId.setPromptText("Enter the Loan Unique Id");
			HtextFieldAmount.setPromptText("Enter the Amount");
			resultField.setText("Loan with given id is not available");
		}
	}

	@FXML
	public void EhandleApply() {
		try {
			int loanId = Integer.parseInt(EtextFieldId.getText());
			double amount = Double.parseDouble(EtextFieldAmount.getText());
			Loan loan = LoanManager.getInstance().getLoan(loanId);

			user.applyLoan(loan, amount);
		} catch (NumberFormatException e) {
			EtextFieldId.clear();
			EtextFieldAmount.clear();
			EtextFieldId.setPromptText("Enter the Loan Unique Id");
			EtextFieldAmount.setPromptText("Enter the Amount");
			resultField.setText("Please enter a valid id and amount");
		} catch (SQLIntegrityConstraintViolationException e) {
			resultField.setText("You have already applied for this loan");
		} catch (SQLException e) {
			EtextFieldId.clear();
			EtextFieldAmount.clear();
			EtextFieldId.setPromptText("Enter the Loan Unique Id");
			EtextFieldAmount.setPromptText("Enter the Amount");
			resultField.setText("Loan with given id is not available");
		}
	}

	@FXML
	public void ChandleApply() {
		try {
			int loanId = Integer.parseInt(CtextFieldId.getText());
			double amount = Double.parseDouble(CtextFieldAmount.getText());
			Loan loan = LoanManager.getInstance().getLoan(loanId);

			user.applyLoan(loan, amount);
		} catch (NumberFormatException e) {
			CtextFieldId.clear();
			CtextFieldAmount.clear();
			CtextFieldId.setPromptText("Enter the Loan Unique Id");
			CtextFieldAmount.setPromptText("Enter the Amount");
			resultField.setText("Please enter a valid id and amount");
		} catch (SQLIntegrityConstraintViolationException e) {
			resultField.setText("You have already applied for this loan");
		} catch (SQLException e) {
			CtextFieldId.clear();
			CtextFieldAmount.clear();
			CtextFieldId.setPromptText("Enter the Loan Unique Id");
			CtextFieldAmount.setPromptText("Enter the Amount");
			resultField.setText("Loan with given id is not available");
		}
	}

	public void handleLogout() throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Logout");

		Optional<ButtonType> result = alert.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {
			setUser(null);
			new View().back();
		}
	}

	public static String integerRangeToString(int[] range) {
		StringBuilder build = new StringBuilder();

		build.append(range[0]);
		build.append((range[1] == -1) ? " and above" : ("- " + range[1]));

		return build.toString();
	}

	public static String securityPossesedToString(int securityPossesed) {
		String arr = Integer.toString(securityPossesed);
		StringBuilder returnSecVal = new StringBuilder();

		if (arr.charAt(0) == '1') {
			returnSecVal.append("Personal");
		} else {
			returnSecVal.append("");
		}

		if (arr.charAt(1) == '1') {
			returnSecVal.append(" Non-Personal");
		}

		else {
			returnSecVal.append("");
		}

		if (arr.charAt(2) == '1') {
			returnSecVal.append(" Collateral");
		} else {
			returnSecVal.append("");
		}

		return returnSecVal.toString();
	}
}
