package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomePage {
	public WebDriver driver;
	
	public TrelloHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='Log in' and contains(@class,'Buttonsstyles')]")
	private WebElement loginOption;
	
	@FindBy(xpath = "(//input[@name='email'])[1]")
	private WebElement emailtextFiled; 
	
	public  WebElement loginOption() {
		return loginOption; 
	}
	public WebElement emailtextFiled() {
		return emailtextFiled;
	}
}
