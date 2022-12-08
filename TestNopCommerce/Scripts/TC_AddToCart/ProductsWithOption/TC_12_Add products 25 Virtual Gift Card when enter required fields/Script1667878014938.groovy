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

'scroll to Featured products'
WebUI.scrollToElement(findTestObject('Object Repository/TC_AddToCart/strong_Text'), 2)

'click add to cart'
WebUI.click(findTestObject('Object Repository/TC_AddToCart/btn_AddToCart', [('index') : '4']))

'input Recipient Name'
WebUI.setText(findTestObject('Object Repository/TC_AddToCart/input_QuantityValue',[('quantity'):'giftcard_43.RecipientName']), GlobalVariable.recipienName)

'input Recipient Email'
WebUI.setText(findTestObject('Object Repository/TC_AddToCart/input_QuantityValue',[('quantity'):'giftcard_43.RecipientEmail']), GlobalVariable.recipientEmail)

'input Your Name'
WebUI.setText(findTestObject('Object Repository/TC_AddToCart/input_QuantityValue',[('quantity'):'giftcard_43.SenderName']), GlobalVariable.yourName)

'input Your Email'
WebUI.setText(findTestObject('Object Repository/TC_AddToCart/input_QuantityValue',[('quantity'):'giftcard_43.SenderEmail']), GlobalVariable.yourEmail)

'input quantity'
WebUI.setText(findTestObject('Object Repository/TC_AddToCart/input_QuantityValue',[('quantity'):'addtocart_43.EnteredQuantity']), '4')

'click add to cart'
WebUI.click(findTestObject('Object Repository/TC_AddToCart/btn_AddToCart',[('index'):'1']))

'verify message add product to cart successfully'
WebUI.verifyTextPresent('The product has been added to your shopping cart', false)

'take screenshot'
Date today = new Date()

   String dateFolder = today.format('dd.MM.yyyy').replace('.', '-')

   String nowTime = today.format('dd.MM.yyyy hh:mm:ss').replace(':', '.')
   
WebUI.takeScreenshot((((((('ScreenShots'  + '/Success/') + dateFolder) + '/') + 'SS1') + '_') +   nowTime) + '.png')
'closeBrowser'

WebUI.closeBrowser()
