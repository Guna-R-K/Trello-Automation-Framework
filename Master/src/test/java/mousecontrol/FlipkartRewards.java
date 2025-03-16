package mousecontrol;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartRewards {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
		WebElement popupCancelButton = driver.findElement(By.xpath("//button[text()='✕']"));
		popupCancelButton.click();
		
		WebElement loginButton = driver.findElement(By.linkText("Login"));
		action.moveToElement(loginButton).perform();
		
		WebElement rewardOption = driver.findElement(By.xpath("//div[text()='Rewards']"));
		//wait.until(ExpectedConditions.elementToBeClickable(rewardOption);
		action.moveToElement(rewardOption).pause(Duration.ofMillis(500)).click(rewardOption).pause(Duration.ofSeconds(2)).perform();
		
		driver.manage().window().minimize();
		driver.quit();
	}
}
