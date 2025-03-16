package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginToContinuePage {
	WebDriver driver;

	public TrelloLoginToContinuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "password")
	WebElement passWordTextFiled;
	
	@FindBy(id = "login-submit")
	WebElement finalLoginButton;
	
	public WebElement passWordTextFiled() {
		return passWordTextFiled;
	}
	public WebElement finalLoginButton() {
		return finalLoginButton;
	}
}
