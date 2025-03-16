package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloCreatedBoardPage {
	WebDriver driver;
	public TrelloCreatedBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement newListTitleTextField;
	
	@FindBy(xpath = "//span[@aria-label='OverflowMenuHorizontalIcon']/../../../button[@aria-label='Show menu']")
	private WebElement showMenuOption;
	
	@FindBy (xpath = "//a[contains(.,'More')]")
	private WebElement moreOptions;
	
	@FindBy (xpath = "//a[contains(text(),'Close board')]")
	private WebElement closeBoardOption;
	
	@FindBy (xpath = "//input[@type='submit' and @value='Close']")
	private WebElement closeBoardButton;
	
	@FindBy(xpath = "//button[text()='Permanently delete board']")
	private WebElement permanentlyDeleteBoardOption;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteBoardButton;
	
	public WebElement newListTitleTextField() {
		return newListTitleTextField;
	}
	
	public WebElement showMenuOption() {
		return showMenuOption;
	}
	
	public WebElement moreOptions() {
		return moreOptions;
	}
	public WebElement closeBoardOption() {
		return closeBoardOption;
	}
	public WebElement closeBoardButton() {
		return closeBoardButton;
	}
	public WebElement  permanentlyDeleteBoardOption() {
		return permanentlyDeleteBoardOption;
}
	public WebElement deleteBoardButton() {
		return deleteBoardButton;
	}

}
