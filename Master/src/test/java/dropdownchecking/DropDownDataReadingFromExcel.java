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

public class DropDownDataReadingFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/dropdowndata.xlsx");
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet("dropdown");
		
		List<String> expectedDayOption = new ArrayList<String>();
		List<String> expectedMonthOption = new ArrayList<String>();
		List<String> expectedYearOption = new ArrayList<String>();
		
		int i=0;
		for (i = 0; i<=2 ; i++) {
			Row row1 = sheet.getRow(i);
			short startCellNum1= row1.getFirstCellNum();
			System.out.println(startCellNum1);
			short lastCellNum1 = row1.getLastCellNum();
			System.out.println(lastCellNum1);
			for ( short colIndex1 = startCellNum1 ; colIndex1<lastCellNum1 ; colIndex1++) {
				//If the Index 0 will have the Heading of the Row, So we Skiping that.   
				if (colIndex1 != 0) {
					Cell cell1 = row1.getCell(colIndex1);
					
					try {
						String cellValue = cell1.getStringCellValue();
						expectedMonthOption.add(cellValue);
						
					} catch (IllegalStateException e) {
						long cellNum =  (long)cell1.getNumericCellValue();
						String numToString = new StringBuilder().append(cellNum).toString();
						
						if (i == 0 ) {
							expectedDayOption.add(numToString);
						}else {
							expectedYearOption.add(numToString);
						}
					}
				}
			}
		}
		workBook.close();
		
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/signup");
		
		WebElement dayDropDown = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDropDown);
		for (String dayVisibleTest : expectedDayOption) {
			daySelect.selectByVisibleText(dayVisibleTest);
			if (daySelect.getFirstSelectedOption().isSelected()) {
				System.out.println("Pass: The Day Option "+ daySelect.getFirstSelectedOption().getText()+"is selected");
			}else {
				System.out.println("Fail: The Day Option "+ daySelect.getFirstSelectedOption().getText()+"is not selected");
			}
		}	
		
		WebElement monthDropDown = driver.findElement(By.id("month"));
		Select monthSelect = new Select(monthDropDown);
		for (String monthVisibleTest : expectedMonthOption) {
			monthSelect.selectByVisibleText(monthVisibleTest);
			if (monthSelect.getFirstSelectedOption().isSelected()) {
				System.out.println("Pass: The month Option "+ monthSelect.getFirstSelectedOption().getText()+"is selected");
			}else {
				System.out.println("Fail: The month Option "+ monthSelect.getFirstSelectedOption().getText()+"is not selected");
			}
		} 
		
		WebElement yearDropDown = driver.findElement(By.id("year"));
		Select yearSelect = new Select(yearDropDown);
		for (String yearVisibleTest : expectedYearOption) {
			yearSelect.selectByVisibleText(yearVisibleTest);
			if (yearSelect.getFirstSelectedOption().isSelected()) {
				System.out.println("Pass: The year Option "+ yearSelect.getFirstSelectedOption().getText()+"is selected");
			}else {
				System.out.println("Fail: The year Option "+ yearSelect.getFirstSelectedOption().getText()+"is not selected");
			}
		}
			
		driver.manage().window().minimize();
		driver.quit();
	}
}
