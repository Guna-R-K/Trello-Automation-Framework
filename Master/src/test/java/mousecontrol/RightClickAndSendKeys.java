package mousecontrol;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAndSendKeys {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		WebElement emailTextField = driver.findElement(By.id("email"));
		actions.sendKeys(emailTextField, "Gunaseelan").perform();
		WebElement loginButton = driver.findElement(By.name("login"));
		actions.contextClick(loginButton).perform();
		WebElement helpLinkText = driver.findElement(By.linkText("Help"));
		actions.scrollToElement(helpLinkText).pause(Duration.ofSeconds(2)).perform();
		//driver.manage().window().minimize();
		driver.quit();
	}
}
