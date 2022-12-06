package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
public class excel {

	@Keyword
	public void writeExcel(String name,int row, int cellcol) throws IOException{

		String xpath = RunConfiguration.getProjectDir()
		FileInputStream excel = new FileInputStream(xpath+"\\Excel\\Register.xlsx")
		XSSFWorkbook workbook = new XSSFWorkbook(excel)
		XSSFSheet sheet = workbook.getSheet("Sheet1")
		XSSFRow Row = sheet.getRow(row)// row = 1
		XSSFCell cell1 = Row.createCell(cellcol)// cell = 1
		cell1.setCellValue(name)

		FileOutputStream fos = new FileOutputStream(xpath+"\\Excel\\Register.xlsx");
		workbook.write(fos);
		fos.close();
	}

	@Keyword
	public readExcel(int row, int cell) {
		String xpath = RunConfiguration.getProjectDir()
		FileInputStream excel = new FileInputStream(xpath+"\\Excel\\Register.xlsx")
		XSSFWorkbook workbook = new XSSFWorkbook(excel)
		XSSFSheet sheet = workbook.getSheet("Sheet1")
		Row Row = sheet.getRow(row)
		Cell cell1 = Row.getCell(cell)
		return cell1
		FileOutputStream fos = new FileOutputStream(xpath+"\\Excel\\Register.xlsx");
		workbook.write(fos);
		fos.close();
	}
}

