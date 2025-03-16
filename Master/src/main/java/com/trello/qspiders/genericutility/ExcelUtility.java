package com.trello.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class is Responsible for Read the Test Case specific Data From Excel Sheet 
 * @author Gunaseelan R K
 *
 */
public class ExcelUtility {
	
	/**
	 * This is reusable method to Read String Data From Excel Sheet
	 * @param filePath
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readStringDataFromExcel(String filePath, String sheetName, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workBook = WorkbookFactory.create(fis);
		String cellValue = workBook.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		workBook.close();
		return cellValue;
	}
	
	public double readNumericDataFromExcel(String filePath, String sheetName, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(fis);
		double cellValue = workbook.getSheet(sheetName).getRow(rownum).getCell(cellnum).getNumericCellValue();
		workbook.close();
		return cellValue ;
	}
}
