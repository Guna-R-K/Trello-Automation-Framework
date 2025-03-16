package dropdownchecking;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderChecking {
	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		FileInputStream fis = new FileInputStream("./src/test/resources/dropdowndata.xlsx");
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet("dropdown");
		
		List<String> exepectedDayOrder = new ArrayList<String>();
		List<String> exepectedMonthOrder = new ArrayList<String>();
		List<String> exepectedYearOrder = new ArrayList<String>();
		
		int i = 0;
		for ( i = 0; i <= 2; i++) {
			Row row1 = sheet.getRow(i);
			short firstCellNum = row1.getFirstCellNum();
			short lastCellNum = row1.getLastCellNum();
			
			for (short colIndex1 = firstCellNum ; colIndex1 < lastCellNum ; colIndex1++ ) {
				if (colIndex1 != 0) {
					Cell cell1 = row1.getCell(colIndex1);

					if (i == 0 ) {
						long cellNum = (long)cell1.getNumericCellValue();
						String numToString = new StringBuilder().append(cellNum).toString();
						exepectedDayOrder.add(numToString);
					}else if (i == 1) {
						String cellValue = cell1.getStringCellValue();
						exepectedMonthOrder.add(cellValue);
					}else {
						long cellNum = (long)cell1.getNumericCellValue();
						String numToString = new StringBuilder().append(cellNum).toString();
						exepectedYearOrder.add(numToString);
					}
				}
			}
		}
		workBook.close();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/signup");
		
		List<String> actualDayOrder = new ArrayList<String>();
		List<String> actualMonthOrder = new ArrayList<String>();
		List<String> actualYearOrder =new ArrayList<String>();
		
		//Checking Day Drop Down Order 
		WebElement dayDropDown = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDropDown);
		List<WebElement> allDayOption = daySelect.getOptions();
		
		for (WebElement dayOption : allDayOption) {
			String dayVisibleText = dayOption.getText();
			actualDayOrder.add(dayVisibleText);
		}
		System.out.println(exepectedDayOrder);
		System.out.println(actualDayOrder);
		
		if (actualDayOrder.equals(exepectedDayOrder)) {
			System.out.println("Pass: The Day Drop Down Option Order is correct and it's verified");
		}else {
			System.out.println("Fail: The Day Drop Down Option Order is incorrect and it's verified");
		}
		
		//Checking Month Drop Down Order
		WebElement monthDropDown = driver.findElement(By.id("month"));
		Select monthSelect = new Select(monthDropDown);
		List<WebElement> allMonthOption = monthSelect.getOptions();
		
		for (WebElement monthOption : allMonthOption) {
			String monthVisibleText = monthOption.getText();
			actualMonthOrder.add(monthVisibleText);
		}
		System.out.println(exepectedMonthOrder);
		System.out.println(actualMonthOrder);
		
		if (actualMonthOrder.equals(exepectedMonthOrder)) {
			System.out.println("Pass: The Month Drop Down Option Order is correct and it's verified");
		}else {
			System.out.println("Fail: The Month Dorp Down Option Order is incorrect and it's verified");
		}
		
		//checking Year Drop Down Order
		WebElement yearDropDown = driver.findElement(By.id("year"));
		Select yearSelect = new Select(yearDropDown);
		List<WebElement> allYearOption = yearSelect.getOptions();
		
		for (WebElement yearOption : allYearOption) {
			String yearVisibleText = yearOption.getText();
			actualYearOrder.add(yearVisibleText);
		}
		System.out.println(exepectedYearOrder);
		System.out.println(actualYearOrder);
		
		if (actualYearOrder.equals(exepectedYearOrder)) {
			System.out.println("Pass: The Year Drop Down Option Order is correct and it's verified");
		}else {
			System.out.println("Fail: The Year Dorp Down Option Order is incorrect and it's verified");
		}
		
		driver.manage().window().minimize();
		driver.quit();
	}
}
