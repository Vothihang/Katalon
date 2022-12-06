package common
import org.openqa.selenium.WebElement
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import internal.GlobalVariable
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
public class product {
	WebDriver driver = DriverFactory.getWebDriver()

//	@Keyword
//	def getListText(String object) {
//
//		List<WebElement> listTexts = WebUiCommonHelper.findWebElements(findTestObject(object),1)
//
//		def listText = []
//
//		for (def element : listTexts) {
//			if (element.getText().trim() != '') {
//				listText.add(element.getText().trim())
//			}
//		}
//
//		return listText
//	}
	
	@Keyword
	public getList (String xpat) {

		List<String> listMenu = driver.findElements(By.xpath(xpat))

		def listMenus = []
		for (def element : listMenu) {
			if (element.getText().trim() != '') {
				listMenus.add(element.getText().trim())
			}
		}
		
	}
}
