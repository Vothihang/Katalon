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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.awt.Desktop
import java.awt.Toolkit
import javax.imageio.ImageIO
import java.awt.Robot
import java.awt.image.BufferedImage
import java.sql.Array
import java.awt.Rectangle

Random rnd = new Random()
rndNumber = (10 + rnd.nextInt(30))
Date today = new Date()
String dateFolder = today.format('dd.MM.yyyy').replace('.', '-')
String nowTime = today.format('dd.MM.yyyy hh:mm:ss').replace(':', '.')

for (s=1; s<7; s++) {
	'open Browser'
	WebUI.openBrowser('https://demo.nopcommerce.com/')
	
	'maximize demo.nopcommerce '
	WebUI.maximizeWindow()
	
	'click href Register'
	WebUI.click(findTestObject('Object Repository/Register/a_Register',[('class'):'ico-register']))
	
	'click radio Gender'
	WebUI.click(findTestObject('Object Repository/Register/input_Gender'))
	
	'input Frist Name'
	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'FirstName']), 'Võ')
	
	'input Last Name'
	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'LastName']), 'Hằng')
	
	'select option Day'
	WebUI.selectOptionByValue(findTestObject('Object Repository/Register/select_DayOfBirth',[('dmy'):'DateOfBirthDay']), '2', false)
	
	'select option Month'
	WebUI.selectOptionByValue(findTestObject('Object Repository/Register/select_DayOfBirth',[('dmy'):'DateOfBirthMonth']), '11', false)
	
	'select option Year'
	WebUI.selectOptionByValue(findTestObject('Object Repository/Register/select_DayOfBirth',[('dmy'):'DateOfBirthYear']), '1999', false)
	
	eamilRnd = (('hang' +s + rndNumber) + '@gmail.com')
	
	'input Email'
	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'Email']), eamilRnd)
	
	passRnd = ('hang' + rndNumber)
	'input Password'
	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'Password']), passRnd)
	
	'input Confirm Password'
	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'ConfirmPassword']), passRnd)
	
	'click button Register'
	WebUI.click(findTestObject('Object Repository/Register/btn_Register'))
	
	eamilRnd2 = (('vohang' + s + rndNumber) + '@gmail.com')
	
	 y = CustomKeywords.'common.verify.verifyObjectPresent'(findTestObject('Object Repository/Register/li_Error'))
	 if(y==true) {
		 'take screenshot'
		 WebUI.takeScreenshot((((((((('ScreenShotsRegiter' +'/Error/') + dateFolder)+'/') + eamilRnd) + '/') + 'SS1') + '_') +nowTime) + '.png')
	 }
	 else {
		 'take screenshot'
		 WebUI.takeScreenshot((((((((('ScreenShotsRegiter' +'/Success/') + dateFolder)+'/') + eamilRnd) + '/') + 'SS1') + '_') +nowTime) + '.png')
	 }
	if(y==true) {
	
		'input Email'
		WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'Email']), eamilRnd2)
	
		'input Password'
		WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'Password']), passRnd)
	
		'input Confirm Password'
		WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'ConfirmPassword']), passRnd)
	
		'click button Register'
		WebUI.click(findTestObject('Object Repository/Register/btn_Register'))
		'take screenshot'
		WebUI.takeScreenshot((((((((('ScreenShotsRegiter' +'/Success/') + dateFolder)+'/') + eamilRnd2) + '/') + 'SS1') + '_') +nowTime) + '.png')
		
		CustomKeywords.'common.excel.writeExcel'(eamilRnd2, s, 1)
		CustomKeywords.'common.excel.writeExcel'(passRnd, s, 2)
	}
	else {			
			CustomKeywords.'common.excel.writeExcel'(eamilRnd, s, 1)
			CustomKeywords.'common.excel.writeExcel'(passRnd, s, 2)		
	}
}
'close browser'
WebUI.closeBrowser()