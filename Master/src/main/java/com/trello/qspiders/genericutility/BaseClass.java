package com.trello.qspiders.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.trello.qspiders.pomrepository.TrelloBoardsPage;
import com.trello.qspiders.pomrepository.TrelloHomePage;
import com.trello.qspiders.pomrepository.TrelloLoginPage;
import com.trello.qspiders.pomrepository.TrelloLoginToContinuePage;
import com.trello.qspiders.pomrepository.TrelloLogoutPage;

public class BaseClass {
	public WebDriver driver;
	
	public ExcelUtility excelUtile = new ExcelUtility();
	public FileUtility fileUtile = new FileUtility();
	public WebDriverUtility webDriverUtile = new WebDriverUtility();
	
	@BeforeClass
	public void configBeforeClass() throws Throwable {
		String browserName = fileUtile.readDataFromProertyFiles("./src/test/resources/marvelcommondata.properties", "browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver(); 
		}else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		webDriverUtile.implicitWait(driver);
		driver.get(fileUtile.readDataFromProertyFiles("./src/test/resources/marvelcommondata.properties", "url"));
	}
	
	@BeforeMethod
	public void ConfigBeforeMethod() throws Throwable {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.loginOption().click();
		
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.emailIdTextField().sendKeys(fileUtile.readDataFromProertyFiles("./src/test/resources/marvelcommondata.properties", "username"));
		loginPage.continueLoginButton().click();
		
		TrelloLoginToContinuePage loginToCounti = new TrelloLoginToContinuePage(driver);
		webDriverUtile.explicitWaitForPasswordTextFiled(driver);
		loginToCounti.passWordTextFiled().sendKeys(fileUtile.readDataFromProertyFiles("./src/test/resources/marvelcommondata.properties", "password"));
		loginToCounti.finalLoginButton().submit();
	}
	
	@AfterMethod
	private void configAfterMethod() {
		TrelloBoardsPage boardPage = new TrelloBoardsPage(driver);
		boardPage.memberMenuButton().click();
		boardPage.logOutButton().click();
		TrelloLogoutPage logoutPage = new TrelloLogoutPage(driver);
		logoutPage.logoutButton().submit();
		
		if (webDriverUtile.explicitWaitForUrl(driver)) {
			System.out.println("Pass: The Logout is sucessfull upon the verification of Url of the Home Page.");
		}else {
			System.out.println("Fail: The Logout is unsucessfull upon the verification of the URL of the home page.");
		}
	}
	
	@AfterClass
	public void configAfterClass() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
