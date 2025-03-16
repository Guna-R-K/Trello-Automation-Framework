package mousecontrol;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UsingMoveToElementOffSet {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		WebElement menSection = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
		
		action.moveToElement(menSection).pause(Duration.ofSeconds(2)).moveToElement(menSection, 77, 0).pause(Duration.ofSeconds(2)).moveToElement(menSection, 154, 0).pause(Duration.ofSeconds(2)).moveToElement(menSection, 255, 0).pause(Duration.ofSeconds(2)).moveToElement(menSection, 368, 0).pause(Duration.ofSeconds(2)).moveToElement(menSection, 454, 0).build().perform();
		
		driver.manage().window().minimize();
		driver.quit();
	}
}
