package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {
	WebDriver driver;

	public TrelloLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "user")
	private WebElement emailIdTextField;
	
	@FindBy(id = "login")
	private WebElement continueLoginButton;
	
	public WebElement emailIdTextField() {
		return emailIdTextField;
	}
	public WebElement continueLoginButton() {
		return continueLoginButton;
	}
	
}
