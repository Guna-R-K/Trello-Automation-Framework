package com.trello.qspiders.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trello.qspiders.pomrepository.TrelloLoginToContinuePage;

/**
 * This class is Responsible For Supply the Wait for All the Scipt 
 * @author Gunaseelan R K
 *
 */
public class WebDriverUtility {
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void explicitWaitForPasswordTextFiled(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		TrelloLoginToContinuePage logintoContinue=new TrelloLoginToContinuePage(driver);
		wait.until(ExpectedConditions.visibilityOf(logintoContinue.passWordTextFiled()));
	}
	public boolean explicitWaitForUrl(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Boolean result = wait.until(ExpectedConditions.urlContains("home"));
		return result;
	}
}
