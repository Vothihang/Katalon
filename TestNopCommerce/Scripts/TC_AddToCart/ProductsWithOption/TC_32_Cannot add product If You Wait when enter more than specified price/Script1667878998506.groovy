import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'openBrowser NopCommerce'
WebUI.openBrowser('https://demo.nopcommerce.com/')

'maximaze NopCommerce '
WebUI.maximizeWindow()

'click Digital downloads'
WebUI.click(findTestObject('Object Repository/TC_AddToCart/a_DigitalDowload'))

'click add to cart product If You Wait (donation)'
WebUI.click(findTestObject('Object Repository/TC_AddToCart/btn_AddToCart',[('index'):1]))

'input price'
WebUI.setText(findTestObject('Object Repository/TC_AddToCart/input_Price'), '150.00')

'verify quantity default '
CustomKeywords.'common.verify.verifyObjectPresent'(findTestObject('Object Repository/TC_AddToCart/input_QuantityValue',[('quantity'):'addtocart_35.EnteredQuantity']))

'click add to cart'
WebUI.click(findTestObject('Object Repository/TC_AddToCart/btn_AddToCart',[('index'):'1']))

'verify add to cart unsuccessfuly'
WebUI.verifyTextPresent('The price must be from $0.50 to $100.00', false)

'take screenshot'
Date today = new Date()

   String dateFolder = today.format('dd.MM.yyyy').replace('.', '-')

   String nowTime = today.format('dd.MM.yyyy hh:mm:ss').replace(':', '.')
   
WebUI.takeScreenshot((((((('ScreenShots'  + '/Error/') + dateFolder) + '/') + 'SS1') + '_') +   nowTime) + '.png')
'closeBrowser'
WebUI.closeBrowser()