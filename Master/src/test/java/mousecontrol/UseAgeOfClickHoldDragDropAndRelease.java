package mousecontrol;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UseAgeOfClickHoldDragDropAndRelease {
	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://trello.com/");
		
		WebElement loginOption = driver.findElement(By.xpath("//a[text()='Log in' and contains(@class,'Buttonsstyles')]"));
		loginOption.click();
		
		driver.switchTo().activeElement().sendKeys("peoplefortiptur@gmail.com");
		WebElement continueLoginButton = driver.findElement(By.id("login"));
		continueLoginButton.submit();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.switchTo().activeElement().sendKeys("9886947924");
		WebElement finalLoginButton = driver.findElement(By.id("login-submit"));
		finalLoginButton.submit();
	
		WebElement dragAndDropBoard = driver.findElement(By.xpath("//div[text()='DragAndDrop']"));
		dragAndDropBoard.click();
		
		WebElement webElementCard = driver.findElement(By.xpath("//a[contains(.,'WebElements')]"));
		WebElement continerToDrop = driver.findElement(By.xpath("//textarea[text()='Completed']/../../div[contains(@class,'list-cards')]"));
		actions.clickAndHold(webElementCard).dragAndDrop(webElementCard, continerToDrop).pause(Duration.ofSeconds(3)).release().build().perform();
		
		driver.manage().window().minimize();
		driver.quit();
	}
}
