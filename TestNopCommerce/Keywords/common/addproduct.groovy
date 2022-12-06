package common

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

import internal.GlobalVariable

public class addproduct {

	@Keyword
	public addProductAny(def map) {

		//	WebUI.click(findTestObject('Object Repository/ShoppingCart/a_product',[("text"): product]))

		if (map==[]) {
			WebUI.click(findTestObject('Object Repository/TC_AddToCart/btn_AddToCart',[('index'):'1']))
		}
		else {

			List<String> listKeyOfMap = new ArrayList<>(map.keySet())

			String radioButton = ['OS', 'HDD ']
			String checkbox = ['Software']
			String dropDown = ['RAM', 'Processor', 'Size', 'Color']
			String input = ["Recipient's Name:", "Recipient's Email:", "Your Name:", "Your Email:", "Enter your text:"]

			for (String key : listKeyOfMap) {

				if (radioButton.contains(key)) {
					WebUI.click(findTestObject('Object Repository/Product/label_radio', ["text":key,"value":map.get(key)]))
				}
				else if (checkbox.contains(key)) {
					WebUI.click(findTestObject('Object Repository/Product/label_checkbox', ["text":key,"value":map.get(key)]))
				}
				else if(dropDown.contains(key)) {
					WebUI.click(findTestObject('Object Repository/Product/label_dropdow',["text":key]))
					WebUI.click(findTestObject('Object Repository/Product/label_OptionDropdown', ["text": key,"value":map.get(key)]))
				}
				else if (input.contains(key)){
					WebUI.setText(findTestObject('Object Repository/Product/label_input',["text":key]),map.get(key))
				}
			}
			WebUI.click(findTestObject('Object Repository/TC_AddToCart/btn_AddToCart',[('index'):'1']))
		}
	}

}

