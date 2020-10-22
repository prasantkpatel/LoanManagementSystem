package com.cs403.LoanManagementSystem.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.cs403.LoanManagementSystem.View;
import com.cs403.LoanManagementSystem.constants.LoanStatus;
import com.cs403.LoanManagementSystem.constants.LoanType;
import com.cs403.LoanManagementSystem.entities.Admin;
import com.cs403.LoanManagementSystem.entities.Loan;
import com.cs403.LoanManagementSystem.entities.LoanModel;
import com.cs403.LoanManagementSystem.entities.User;
import com.cs403.LoanManagementSystem.entities.UserLoan;
import com.cs403.LoanManagementSystem.entities.UserModel;
import com.cs403.LoanManagementSystem.managers.LoanManager;
import com.cs403.LoanManagementSystem.managers.UserManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class AdminScreenController implements Initializable {

	public static Admin admin = new Admin();
	@FXML
	public Button btnLoansApplied;
	@FXML
	public Button btnLoansRejected;
	@FXML
	public Button btnLoansSanctioned;
	@FXML
	public Button btnHomeLoans;
	@FXML
	public Button btnEducationLoans;
	@FXML
	public Button btnCarLoans;
	@FXML
	public Button btnMyLoans;
	@FXML
	public Button btnProfile;
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
	public GridPane loansSanctionedGrid;
	@FXML
	public GridPane loansRejectedGrid;
	@FXML
	public GridPane loansAppliedGrid;
	@FXML
	public GridPane RloanInfoTable;
	@FXML
	public GridPane RuserInfoTable;
	@FXML
	public GridPane SloanInfoTable;
	@FXML
	public GridPane SuserInfoTable;
	@FXML
	public GridPane AloanInfoTable;
	@FXML
	public GridPane AuserInfoTable;
	@FXML
	public TableView<LoanModel> homeLoansTable;
	@FXML
	public TableView<LoanModel> educationLoansTable;
	@FXML
	public TableView<LoanModel> carLoansTable;
	@FXML
	public TableView<UserModel> AuserInfoTableView;
	@FXML
	public TableView<LoanModel> AloanInfoTableView;
	@FXML
	public TableView<UserModel> SuserInfoTableView;
	@FXML
	public TableView<LoanModel> SloanInfoTableView;
	@FXML
	public TableView<UserModel> RuserInfoTableView;
	@FXML
	public TableView<LoanModel> RloanInfoTableView;
	@FXML
	public TableColumn<LoanModel, Integer> AloanUniqueId;
	@FXML
	public TableColumn<LoanModel, String> Asource;
	@FXML
	public TableColumn<LoanModel, String> AamountRange;
	@FXML
	public TableColumn<LoanModel, String> AsecurityDemand;
	@FXML
	public TableColumn<LoanModel, Double> AinterestRate;
	@FXML
	public TableColumn<LoanModel, Double> AminimumIncome;
	@FXML
	public TableColumn<LoanModel, String> AageRange;
	@FXML
	public TableColumn<LoanModel, String> Atenure;
	@FXML
	public TableColumn<UserModel, String> AfirstName;
	@FXML
	public TableColumn<UserModel, String> AlastName;
	@FXML
	public TableColumn<UserModel, Integer> Aage;
	@FXML
	public TableColumn<UserModel, String> Aemail;
	@FXML
	public TableColumn<UserModel, String> Agender;
	@FXML
	public TableColumn<UserModel, Double> Aincome;
	@FXML
	public TableColumn<UserModel, Double> AcreditScore;
	@FXML
	public TableColumn<UserModel, String> AsecurityPossesed;
	@FXML
	public TableColumn<LoanModel, Integer> SloanUniqueId;
	@FXML
	public TableColumn<LoanModel, String> Ssource;
	@FXML
	public TableColumn<LoanModel, String> SamountRange;
	@FXML
	public TableColumn<LoanModel, String> SsecurityDemand;
	@FXML
	public TableColumn<LoanModel, Double> SinterestRate;
	@FXML
	public TableColumn<LoanModel, Double> SminimumIncome;
	@FXML
	public TableColumn<LoanModel, String> SageRange;
	@FXML
	public TableColumn<LoanModel, String> Stenure;
	@FXML
	public TableColumn<UserModel, String> SfirstName;
	@FXML
	public TableColumn<UserModel, String> SlastName;
	@FXML
	public TableColumn<UserModel, Integer> Sage;
	@FXML
	public TableColumn<UserModel, String> Semail;
	@FXML
	public TableColumn<UserModel, String> Sgender;
	@FXML
	public TableColumn<UserModel, Double> Sincome;
	@FXML
	public TableColumn<UserModel, Double> ScreditScore;
	@FXML
	public TableColumn<UserModel, String> SsecurityPossesed;
	@FXML
	public TableColumn<LoanModel, Integer> RloanUniqueId;
	@FXML
	public TableColumn<LoanModel, String> Rsource;
	@FXML
	public TableColumn<LoanModel, String> RamountRange;
	@FXML
	public TableColumn<LoanModel, String> RsecurityDemand;
	@FXML
	public TableColumn<LoanModel, Double> RinterestRate;
	@FXML
	public TableColumn<LoanModel, Double> RminimumIncome;
	@FXML
	public TableColumn<LoanModel, String> RageRange;
	@FXML
	public TableColumn<LoanModel, String> Rtenure;
	@FXML
	public TableColumn<UserModel, String> RfirstName;
	@FXML
	public TableColumn<UserModel, String> RlastName;
	@FXML
	public TableColumn<UserModel, Integer> Rage;
	@FXML
	public TableColumn<UserModel, String> Remail;
	@FXML
	public TableColumn<UserModel, String> Rgender;
	@FXML
	public TableColumn<UserModel, Double> Rincome;
	@FXML
	public TableColumn<UserModel, Double> RcreditScore;
	@FXML
	public TableColumn<UserModel, String> RsecurityPossesed;
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
	@FXML
	public TextField txtEmailField;
	@FXML
	public TextField txtLoanId;

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

		AloanUniqueId.setCellValueFactory(new PropertyValueFactory<>("loanUniqueId"));
		Asource.setCellValueFactory(new PropertyValueFactory<>("source"));
		AamountRange.setCellValueFactory(new PropertyValueFactory<>("amountRange"));
		AsecurityDemand.setCellValueFactory(new PropertyValueFactory<>("securityDemand"));
		AinterestRate.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
		AminimumIncome.setCellValueFactory(new PropertyValueFactory<>("minimumIncome"));
		AageRange.setCellValueFactory(new PropertyValueFactory<>("ageRange"));
		Atenure.setCellValueFactory(new PropertyValueFactory<>("tenure"));

		RloanUniqueId.setCellValueFactory(new PropertyValueFactory<>("loanUniqueId"));
		Rsource.setCellValueFactory(new PropertyValueFactory<>("source"));
		RamountRange.setCellValueFactory(new PropertyValueFactory<>("amountRange"));
		RsecurityDemand.setCellValueFactory(new PropertyValueFactory<>("securityDemand"));
		RinterestRate.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
		RminimumIncome.setCellValueFactory(new PropertyValueFactory<>("minimumIncome"));
		RageRange.setCellValueFactory(new PropertyValueFactory<>("ageRange"));
		Rtenure.setCellValueFactory(new PropertyValueFactory<>("tenure"));

		SloanUniqueId.setCellValueFactory(new PropertyValueFactory<>("loanUniqueId"));
		Ssource.setCellValueFactory(new PropertyValueFactory<>("source"));
		SamountRange.setCellValueFactory(new PropertyValueFactory<>("amountRange"));
		SsecurityDemand.setCellValueFactory(new PropertyValueFactory<>("securityDemand"));
		SinterestRate.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
		SminimumIncome.setCellValueFactory(new PropertyValueFactory<>("minimumIncome"));
		SageRange.setCellValueFactory(new PropertyValueFactory<>("ageRange"));
		Stenure.setCellValueFactory(new PropertyValueFactory<>("tenure"));

		AfirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		AlastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		Aage.setCellValueFactory(new PropertyValueFactory<>("age"));
		Agender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		Aemail.setCellValueFactory(new PropertyValueFactory<>("email"));
		Aincome.setCellValueFactory(new PropertyValueFactory<>("income"));
		AcreditScore.setCellValueFactory(new PropertyValueFactory<>("creditScore"));
		AsecurityPossesed.setCellValueFactory(new PropertyValueFactory<>("securityPossesed"));

		SfirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		SlastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		Sage.setCellValueFactory(new PropertyValueFactory<>("age"));
		Sgender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		Semail.setCellValueFactory(new PropertyValueFactory<>("email"));
		Sincome.setCellValueFactory(new PropertyValueFactory<>("income"));
		ScreditScore.setCellValueFactory(new PropertyValueFactory<>("creditScore"));
		SsecurityPossesed.setCellValueFactory(new PropertyValueFactory<>("securityPossesed"));

		RfirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		RlastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		Rage.setCellValueFactory(new PropertyValueFactory<>("age"));
		Rgender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		Remail.setCellValueFactory(new PropertyValueFactory<>("email"));
		Rincome.setCellValueFactory(new PropertyValueFactory<>("income"));
		RcreditScore.setCellValueFactory(new PropertyValueFactory<>("creditScore"));
		RsecurityPossesed.setCellValueFactory(new PropertyValueFactory<>("securityPossesed"));
	}

	public static Admin getAdmin() {
		return admin;
	}

	public static void setAdmin(Admin admin) {
		AdminScreenController.admin = admin;
	}

	@FXML
	public void loadLoansApplied(ActionEvent e) throws SQLException {
		setLabelAndBackground(e);
		loansAppliedGrid.toFront();
		AloadLoanInfo();
		AloadUserInfo();
	}

	@FXML
	public void loadLoansSanctioned(ActionEvent e) throws SQLException {
		setLabelAndBackground(e);
		loansSanctionedGrid.toFront();
		SloadLoanInfo();
		SloadUserInfo();
	}

	@FXML
	public void loadLoansRejected(ActionEvent e) throws SQLException {
		setLabelAndBackground(e);
		loansRejectedGrid.toFront();
		RloadLoanInfo();
		RloadUserInfo();
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

	@FXML
	public void AloadUserInfo() throws SQLException {
		AuserInfoTable.toFront();

		UserLoan[] userloans = LoanManager.getInstance().getUserLoans();
		ObservableList<UserModel> userList = FXCollections.observableArrayList();

		for (UserLoan userloan : userloans) {

			if (userloan.getStatus().equals(LoanStatus.UNKNOWN)) {
				User user = UserManager.getInstance().getUser(userloan.getUserEmail());

				userList.add(new UserModel(user.getFirstName(), user.getLastName(), user.getAge(), user.getEmail(),
						user.getGender(), user.getIncome(), user.getCreditScore(),
						securityPossesedToString(user.getSecurityPossesed())));
			}
		}
		AuserInfoTableView.setItems(userList);
	}

	@FXML
	public void AloadLoanInfo() throws SQLException {
		AloanInfoTable.toFront();

		UserLoan[] userloans = LoanManager.getInstance().getUserLoans();
		ObservableList<LoanModel> loanList = FXCollections.observableArrayList();

		for (UserLoan userloan : userloans) {
			Loan loan = LoanManager.getInstance().getLoan(userloan.getLoanId());

			if (userloan.getStatus().equals(LoanStatus.UNKNOWN)) {
				LoanModel model = new LoanModel(loan.getId(), loan.getSource(),
						integerRangeToString(loan.getAmountRange()), loan.getSecurityDemand(), loan.getInterestRate(),
						loan.getMinIncome(), integerRangeToString(loan.getAgeRange()),
						integerRangeToString(loan.getRepaymentPeriod()));
				loanList.add(model);
			}
		}
		AloanInfoTableView.setItems(loanList);
	}

	@FXML
	public void SloadUserInfo() throws SQLException {
		SuserInfoTable.toFront();

		UserLoan[] userloans = LoanManager.getInstance().getUserLoans();
		ObservableList<UserModel> userList = FXCollections.observableArrayList();

		for (UserLoan userloan : userloans) {

			if (userloan.getStatus().equals(LoanStatus.ACCEPTED)) {
				User user = UserManager.getInstance().getUser(userloan.getUserEmail());

				userList.add(new UserModel(user.getFirstName(), user.getLastName(), user.getAge(), user.getEmail(),
						user.getGender(), user.getIncome(), user.getCreditScore(),
						securityPossesedToString(user.getSecurityPossesed())));
			}
		}
		SuserInfoTableView.setItems(userList);
	}

	@FXML
	public void SloadLoanInfo() throws SQLException {
		SloanInfoTable.toFront();

		UserLoan[] userloans = LoanManager.getInstance().getUserLoans();
		ObservableList<LoanModel> loanList = FXCollections.observableArrayList();

		for (UserLoan userloan : userloans) {
			Loan loan = LoanManager.getInstance().getLoan(userloan.getLoanId());

			if (userloan.getStatus().equals(LoanStatus.ACCEPTED)) {
				LoanModel model = new LoanModel(loan.getId(), loan.getSource(),
						integerRangeToString(loan.getAmountRange()), loan.getSecurityDemand(), loan.getInterestRate(),
						loan.getMinIncome(), integerRangeToString(loan.getAgeRange()),
						integerRangeToString(loan.getRepaymentPeriod()));
				loanList.add(model);
			}
		}
		SloanInfoTableView.setItems(loanList);
	}

	@FXML
	public void RloadUserInfo() throws SQLException {
		RuserInfoTable.toFront();

		UserLoan[] userloans = LoanManager.getInstance().getUserLoans();
		ObservableList<UserModel> userList = FXCollections.observableArrayList();

		for (UserLoan userloan : userloans) {

			if (userloan.getStatus().equals(LoanStatus.REJECTED)) {
				User user = UserManager.getInstance().getUser(userloan.getUserEmail());

				userList.add(new UserModel(user.getFirstName(), user.getLastName(), user.getAge(), user.getEmail(),
						user.getGender(), user.getIncome(), user.getCreditScore(),
						securityPossesedToString(user.getSecurityPossesed())));
			}
		}
		RuserInfoTableView.setItems(userList);
	}

	@FXML
	public void RloadLoanInfo() throws SQLException {
		RloanInfoTable.toFront();

		UserLoan[] userloans = LoanManager.getInstance().getUserLoans();
		ObservableList<LoanModel> loanList = FXCollections.observableArrayList();

		for (UserLoan userloan : userloans) {
			Loan loan = LoanManager.getInstance().getLoan(userloan.getLoanId());

			if (userloan.getStatus().equals(LoanStatus.REJECTED)) {
				LoanModel model = new LoanModel(loan.getId(), loan.getSource(),
						integerRangeToString(loan.getAmountRange()), loan.getSecurityDemand(), loan.getInterestRate(),
						loan.getMinIncome(), integerRangeToString(loan.getAgeRange()),
						integerRangeToString(loan.getRepaymentPeriod()));
				loanList.add(model);
			}
		}
		RloanInfoTableView.setItems(loanList);
	}

	public void setLabelAndBackground(ActionEvent e) {
		if (e.getSource() == btnLoansApplied) {
			lblButtonInfo.setText("Loans Applied");
			pnButtonInfo.setBackground(
					new Background(new BackgroundFill(Color.rgb(255, 53, 3), CornerRadii.EMPTY, Insets.EMPTY)));

		} else if (e.getSource() == btnLoansSanctioned) {
			lblButtonInfo.setText("Loans Sanctioned");
			pnButtonInfo.setBackground(
					new Background(new BackgroundFill(Color.rgb(255, 87, 33), CornerRadii.EMPTY, Insets.EMPTY)));

		} else if (e.getSource() == btnLoansRejected) {
			lblButtonInfo.setText("Loans Rejected");
			pnButtonInfo.setBackground(
					new Background(new BackgroundFill(Color.rgb(101, 49, 142), CornerRadii.EMPTY, Insets.EMPTY)));

		} else if (e.getSource() == btnHomeLoans) {
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

			admin.applyLoan(loan, amount);
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

			admin.applyLoan(loan, amount);
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

			admin.applyLoan(loan, amount);
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

	@FXML
	public void handleAcceptLoan() {
		String email = txtEmailField.getText();
		int loanId = Integer.parseInt(txtLoanId.getText());

		try {
			User user = UserManager.getInstance().getUser(email);
			Loan loan = LoanManager.getInstance().getLoan(loanId);
			UserLoan[] userloans = LoanManager.getInstance().getUserLoans();

			for (UserLoan userloan : userloans) {
				if (user.getEmail().equals(userloan.getUserEmail()) && (loan.getId() == userloan.getLoanId())
						&& userloan.getStatus().equals(LoanStatus.UNKNOWN)) {
					admin.sanctionLoan(user, loan);
				} else {
					txtEmailField.clear();
					txtLoanId.clear();
					txtEmailField.setPromptText("Enter user email");
					txtLoanId.setPromptText("Enter loan id");
					resultField.setText("Invalid Details");
				}

			}

		} catch (SQLException e) {
			txtEmailField.clear();
			txtLoanId.clear();
			txtEmailField.setPromptText("Enter user email");
			txtLoanId.setPromptText("Enter loan id");
			resultField.setText("Invalid Details");
		}
	}

	@FXML
	public void handleRejectLoan() {
		String email = txtEmailField.getText();
		int loanId = Integer.parseInt(txtLoanId.getText());

		try {
			User user = UserManager.getInstance().getUser(email);
			Loan loan = LoanManager.getInstance().getLoan(loanId);
			UserLoan[] userloans = LoanManager.getInstance().getUserLoans();

			for (UserLoan userloan : userloans) {
				if (user.getEmail().equals(userloan.getUserEmail()) && (loan.getId() == userloan.getLoanId())
						&& userloan.getStatus().equals(LoanStatus.UNKNOWN)) {
					admin.rejectLoan(user, loan);
				} else {
					txtEmailField.clear();
					txtLoanId.clear();
					txtEmailField.setPromptText("Enter user email");
					txtLoanId.setPromptText("Enter loan id");
					resultField.setText("Invalid Details");
				}

			}

		} catch (SQLException e) {
			txtEmailField.clear();
			txtLoanId.clear();
			txtEmailField.setPromptText("Enter user email");
			txtLoanId.setPromptText("Enter loan id");
			resultField.setText("Invalid Details");
		}
	}

	@FXML
	public void handleLogout() throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Logout");

		Optional<ButtonType> result = alert.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {
			setAdmin(null);
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