package trelloboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloEndToEndTesting {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://trello.com/");
		WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in' and contains(@class,'Buttonsstyles')]"));
		loginLink.click();
		driver.switchTo().activeElement().sendKeys("kmguna1999@gmail.com");
		WebElement continueLoginButton = driver.findElement(By.id("login"));
		continueLoginButton.submit();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.switchTo().activeElement().sendKeys("Guna16107057");
		WebElement finalLoginButton = driver.findElement(By.id("login-submit"));
		finalLoginButton.submit();
		WebElement createNewBoard = driver.findElement(By.cssSelector("div[class='board-tile mod-add']"));
		createNewBoard.click();
		WebElement boardTitle = driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']"));
		boardTitle.sendKeys("TestNG");
		WebElement createButton = driver.findElement(By.xpath("//button[text()='Create']"));
		createButton.click();
		WebElement testAreaForTitle = driver.findElement(By.xpath("//input[@placeholder='Enter list title…']"));
		actions.sendKeys(testAreaForTitle, "Annotation").sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys("Arguments").sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys("Invocation").sendKeys(Keys.ENTER).build().perform();
		//Delete the Card & Board
		WebElement menuButton = driver.findElement(By.xpath("//button[@aria-label='Show menu']"));
		menuButton.click();
		WebElement moreOption = driver.findElement(By.xpath("//a[contains(.,'More')]"));
		moreOption.click();
		WebElement closeBoardButton = driver.findElement(By.xpath("//a[contains(text(),'Close board')]"));
		closeBoardButton.click();
		WebElement closeOption = driver.findElement(By.xpath("//input[@value=\"Close\"]"));
		closeOption.click();
		WebElement permanentlyDeleteBoardButton = driver.findElement(By.xpath("//button[text()='Permanently delete board']"));
		permanentlyDeleteBoardButton.click();
		WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
		deleteButton.click();
		//LogOut 
		WebElement memboreMenuButton = driver.findElement(By.xpath("//button[@aria-label='Open member menu']"));
		memboreMenuButton.click();
		WebElement logOutButton = driver.findElement(By.xpath("//button[.='Log out']"));
		logOutButton.click();
		WebElement finallogOutButton = driver.findElement(By.id("logout-submit"));
		finallogOutButton.click();
		driver.manage().window().minimize();
		driver.quit();
	}
}
