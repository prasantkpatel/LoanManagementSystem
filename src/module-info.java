module loanManagementSystem {
	requires mysql.connector.java;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.web;
	requires transitive AnimateFX;
	requires transitive javafx.graphics;
	requires transitive javafx.controls;
	requires transitive java.sql;
	requires transitive de.jensd.fx.glyphs.fontawesome;
	
	exports com.cs403.LoanManagementSystem;
	exports com.cs403.LoanManagementSystem.entities;
	exports com.cs403.LoanManagementSystem.controllers;
}