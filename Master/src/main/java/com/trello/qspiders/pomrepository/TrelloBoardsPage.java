package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	WebDriver driver;

	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "board-tile mod-add")
	WebElement createNewBoard;
	
	@FindBy(xpath = "//input[@data-testid='create-board-title-input']")
	WebElement createBoardTitleTextFiled;
	
	@FindBy(xpath = "//button[text()='Create']")
	WebElement createButton;
	
	@FindBy(xpath = "//button[@aria-label='Open member menu']")
	WebElement memberMenuButton;
	
	@FindBy(xpath = "//button[.='Log out']")
	WebElement logOutButton;
	
	public WebElement createNewBoard() {
		return createNewBoard;
	}
	public WebElement createBoardTitleTextFiled() {
		return createBoardTitleTextFiled;
	}
	public WebElement createButton() {
		return createButton;
	}
	public WebElement memberMenuButton() {
		return memberMenuButton;
	}
	public WebElement logOutButton() {
		return logOutButton;
	}
}
