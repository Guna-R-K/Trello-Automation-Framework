package mousecontrol;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement_1 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.myntra.com/");
		List<WebElement> menuSection = driver.findElements(By.className("desktop-main"));
		
		for (WebElement menuOption : menuSection) {
			action.moveToElement(menuOption).pause(Duration.ofSeconds(2)).perform();
		}
		
		driver.manage().window().minimize();
		driver.quit();
	}
}
