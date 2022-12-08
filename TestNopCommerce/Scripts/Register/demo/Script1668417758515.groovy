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
import java.awt.event.KeyEvent
import com.kms.katalon.keyword.excel.ExcelKeywords
import com.kms.katalon.core.testdata.reader.ExcelFactory
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver as WebDriver

Random rnd = new Random()
rndNumber = (10 + rnd.nextInt(50))
Date today = new Date()
String dateFolder = today.format('dd.MM.yyyy').replace('.', '-')
String nowTime = today.format('dd.MM.yyyy hh:mm:ss').replace(':', '.')
rndNikon = (1 + rnd.nextInt(2))

//for (i=1; i<=10; i++) {
//	'open Browser'
//	WebUI.openBrowser('https://demo.nopcommerce.com/')
//	
//	'maximize demo.nopcommerce '
//	WebUI.maximizeWindow()
//	
//	'click href Register'
//	WebUI.click(findTestObject('Object Repository/Register/a_Register',[('class'):'ico-register']))
//	
//	'click radio Gender'
//	WebUI.click(findTestObject('Object Repository/Register/input_Gender'))
//	
//	'input Frist Name'
//	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'FirstName']), 'Võ')
//	
//	'input Last Name'
//	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'LastName']), 'Hằng')
//	
//	'select option Day'
//	WebUI.selectOptionByValue(findTestObject('Object Repository/Register/select_DayOfBirth',[('dmy'):'DateOfBirthDay']), '2', false)
//	
//	'select option Month'
//	WebUI.selectOptionByValue(findTestObject('Object Repository/Register/select_DayOfBirth',[('dmy'):'DateOfBirthMonth']), '11', false)
//	
//	'select option Year'
//	WebUI.selectOptionByValue(findTestObject('Object Repository/Register/select_DayOfBirth',[('dmy'):'DateOfBirthYear']), '1999', false)
//	
//	eamilRnd = (('hang' +i + rndNumber) + '@gmail.com')
//	
//	'input Email'
//	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'Email']), eamilRnd)
//	
//	passRnd = ('hang' + rndNumber)
//	'input Password'
//	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'Password']), passRnd)
//	
//	'input Confirm Password'
//	WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'ConfirmPassword']), passRnd)
//	
//	'click button Register'
//	WebUI.click(findTestObject('Object Repository/Register/btn_Register'))
//	
//	eamilRnd2 = (('vohang' + i + rndNumber) + '@gmail.com')
//	
//	 y = CustomKeywords.'common.verify.verifyObjectPresent'(findTestObject('Object Repository/Register/li_Error'))
//	 if(y==true) {
//		 WebUI.takeScreenshot((((((((('ScreenShotsRegiter' +'/Error/') + dateFolder)+'/') + eamilRnd) + '/') + 'SS1') + '_') +nowTime) + '.png')
//	 }
//	 else {
//		 WebUI.takeScreenshot((((((((('ScreenShotsRegiter' +'/Success/') + dateFolder)+'/') + eamilRnd) + '/') + 'SS1') + '_') +nowTime) + '.png')
//	 }
//	if(y==true) {
//	
//		'input Email'
//		WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'Email']), eamilRnd2)
//	
//		'input Password'
//		WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'Password']), passRnd)
//	
//		'input Confirm Password'
//		WebUI.setText(findTestObject('Object Repository/Register/input_Text',[('text'):'ConfirmPassword']), passRnd)
//	
//		'click button Register'
//		WebUI.click(findTestObject('Object Repository/Register/btn_Register'))
//		
//		WebUI.takeScreenshot((((((((('ScreenShotsRegiter' +'/Success/') + dateFolder)+'/') + eamilRnd2) + '/') + 'SS1') + '_') +nowTime) + '.png')
//		
//		CustomKeywords.'common.excel.writeExcel'(eamilRnd2, i, 1)
//		CustomKeywords.'common.excel.writeExcel'(passRnd, i, 2)
//	}
//	else {			
//			CustomKeywords.'common.excel.writeExcel'(eamilRnd, i, 1)
//			CustomKeywords.'common.excel.writeExcel'(passRnd, i, 2)		
//	}
//}

for(i=1;i<=10;i++) {
'open Browser'
WebUI.openBrowser('https://demo.nopcommerce.com/')

'maximize demo.nopcommerce '
WebUI.maximizeWindow()

String email =	CustomKeywords.'common.excel.readExcel'(i,1)
String password =	CustomKeywords.'common.excel.readExcel'(i,2)
'click Login'
WebUI.click(findTestObject('Object Repository/Login/a_Login'))
'input Email'
WebUI.setText(findTestObject('Object Repository/Login/input_Text',[('value'):'Email']), email)
'input Password'
WebUI.setText(findTestObject('Object Repository/Login/input_Text',[('value'):'Password']), password)

List listMenu = CustomKeywords.'common.product.getListText'('Object Repository/Register/div_product')
rndMenu= rnd.nextInt(listMenu.size()-4)
'navigate Computer'
WebUI.click(findTestObject('Object Repository/Login/a_Navigate',[("Text"):listMenu[rndMenu]]))

if(rndMenu==0) {
	List listComputers = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
	rndComputers= rnd.nextInt(listComputers.size())
	'click 1 of 3 Computers'
	WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[('Text'):listComputers[rndComputers]]))
	'Desktops'
	if(rndComputers==0) {
		List listDesktops = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
		rndDesktops= rnd.nextInt(listDesktops.size())
		
		WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[("Text"):listDesktops[rndDesktops]]))
		if(rndDesktops==0) {
			List listProcessor=CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Processor')
			rndProcessor= 1+ rnd.nextInt(listProcessor.size())
			List listRam = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/select_Ram')
			rndRam= 1+ rnd.nextInt(listRam.size())
			List listHDD = CustomKeywords.'common.product.getListText'('Object Repository/Product/select_radio')
			rndHDD= 1+ rnd.nextInt(listHDD.size())
			 CustomKeywords.'common.addproduct.addProductAny'([Processor:rndProcessor, RAM :rndRam, HDD: rndHDD])
		}
		else if (rndDesktops==1|| rndDesktops==2) {
			 CustomKeywords.'common.addproduct.addProductAny'([])
		}
	}
	else if(rndComputers==1) {
		List listNotebooks = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
		rndNotebooks= rnd.nextInt(listNotebooks.size())
		println listNotebooks
		WebUI.click(findTestObject('Object Repository/Product/Computers/div_Notebooks',[("Text"):listNotebooks[rndNotebooks]]))
			if(rndNotebooks==0 || rndNotebooks==1 || rndNotebooks==2 || rndNotebooks==3 || rndNotebooks==4) {
				'click button add to cart'
				CustomKeywords.'common.addproduct.addProductAny'([])
			}
		}
		else if(rndComputers==2) {
				List listSoftware = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
				rndSoftware= rnd.nextInt(listSoftware.size())
				println listSoftware
				WebUI.click(findTestObject('Object Repository/Product/Computers/div_Notebooks',[("Text"):listSoftware[rndSoftware]]))
				if(rndSoftware==0) {
					'take screenshot'
					WebUI.takeScreenshot((((((((('ScreenShots' +'/Error/') + dateFolder)+'/') + email) + '/') + 'SS1') + '_') +nowTime) + '.png')
				}
				else if(rndSoftware==1 || rndSoftware==2) {
						'click button add to cart'
						CustomKeywords.'common.addproduct.addProductAny'([])
				}
		}
}			
else if(rndMenu==1) {
		List listElectronics = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
		rndElectronics= rnd.nextInt(listElectronics.size())
		'click 1 of 3 Electronics'
		WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[('Text'):listElectronics[rndElectronics]]))
		'Camera'
		if(rndElectronics==0) {
			List listCamera = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
			rndCamera= rnd.nextInt(listCamera.size())
			WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[("Text"):listCamera[rndCamera]]))
			if(rndCamera==0) {
				'click button add to cart'
				WebUI.click(findTestObject('Object Repository/Product/btn_Nikon', [('value'):rndNikon]))
			}
			else if(rndCamera==1) {
					'take screenshot'
					WebUI.takeScreenshot((((((((('ScreenShots' +'/Error/') + dateFolder)+'/') + email) + '/') + 'SS1') + '_') +nowTime) + '.png')
				}
				else  {
						'click button add to cart'
						CustomKeywords.'common.addproduct.addProductAny'([])
				}
		}	
		else if(rndElectronics==1) {
				List listCellphones = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
				rndCellphones= rnd.nextInt(listCellphones.size())
				WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[("Text"):listCellphones[rndCellphones]]))
				if(rndCellphones==0 || rndCellphones==1 || rndCellphones==2) {
					'click button add to cart'
					CustomKeywords.'common.addproduct.addProductAny'([])
				}
		}
		else  {
				List listOthers = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
				rndOthers= rnd.nextInt(listOthers.size())
				WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[("Text"):listOthers[rndOthers]]))
				if(rndOthers==0 || rndOthers==1  || rndOthers==2) {
				'click button add to cart'
				CustomKeywords.'common.addproduct.addProductAny'([])
				}
		}
}			
else if(rndMenu==2) {
		List listApparel  = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
		rndApparel = rnd.nextInt(listApparel.size())
		'click 1 of 3 Apparel '
		WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[('Text'):listApparel[rndApparel]]))		
		if(rndApparel==0) {
		List listShoes = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
		rndShoes= rnd.nextInt(listShoes.size())
		WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[("Text"):listShoes[rndShoes]]))
			if(rndShoes==0) {
				product = CustomKeywords.'common.dynamic.dynamicClass'()
				WebUI.click(findTestObject('Object Repository/Product/ul_adidas',[('value'):product]))		
				CustomKeywords.'common.addproduct.addProductAny'([Size:'9'])
			}
			else if(rndShoes==1) {
				rndNikon=CustomKeywords.'common.dynamic.dynamicClass'()
					WebUI.click(findTestObject('Object Repository/Product/span_Nike',[('value'):rndNikon]))
					CustomKeywords.'common.addproduct.addProductAny'([Size:'9',Color:'White/Blue'])
			}
			else {
					CustomKeywords.'common.addproduct.addProductAny'([])							
							
			}
		}							
		else if(rndApparel==1) {
				List listClothing = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
				rndClothing= rnd.nextInt(listClothing.size())
				WebUI.click(findTestObject('Object Repository/Product/Computers/div_Clothing',[("Text"):listClothing[rndClothing]]))
				if(rndClothing==0) {
					CustomKeywords.'common.addproduct.addProductAny'(["Enter your text:":"I am Hang"])
				}
				else if(rndClothing==1) {
						CustomKeywords.'common.addproduct.addProductAny'([])
				}
				else if(rndClothing==2 ) {
						CustomKeywords.'common.addproduct.addProductAny'([Size:'1X'])
				}
				else  {
						CustomKeywords.'common.addproduct.addProductAny'([])
				}
		}			
		else if(rndApparel==2) {
				List listAccessories = CustomKeywords.'common.product.getListText'('Object Repository/Product/Computers/div_Computers')
				rndAccessories= rnd.nextInt(listAccessories.size())
				WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[("Text"):listAccessories[rndAccessories]]))
				if(rndAccessories==0) {
				CustomKeywords.'common.addproduct.addProductAny'([Size:'Small'])
				}
				else if(rndAccessories==1) {
						CustomKeywords.'common.addproduct.addProductAny'([])	
				}
				else  {
						CustomKeywords.'common.addproduct.addProductAny'([])
				}
		}
}
nameProduct = WebUI.getText(findTestObject('Object Repository/Register/td_NameProduct'))
total = WebUI.getText(findTestObject('Object Repository/Register/span_Total'))
CustomKeywords.'common.excel.writeExcel'(nameProduct,i,3)
CustomKeywords.'common.excel.writeExcel'(total,i, 4)

result = CustomKeywords.'common.verify.verifyObjectPresent'(findTestObject('Object Repository/Product/p_message'))
if(result==true) {
	re = CustomKeywords.'common.verify.verifyObjectPresent'(findTestObject('Object Repository/TC_AddToCart/div_message'))
	if(re==true) {
		'click Shopping cart'
		WebUI.click(findTestObject('Object Repository/Login/a_SCShipping',[('value'):'ico-cart']))
		'take screenshot'
		WebUI.takeScreenshot((((((((('ScreenShots' +'/Success/') + dateFolder)+'/')+ email) + '/') + 'SS1') + '_') +nowTime) + '.png')
		CustomKeywords.'common.excel.writeExcel'('Pass', i, 5)
	}
	else {
		message = WebUI.getText(findTestObject('Object Repository/Product/p_message'))
		CustomKeywords.'common.excel.writeExcel'(message, i, 6)
		'take screenshot'
		WebUI.takeScreenshot((((((((('ScreenShots' +'/Error/') + dateFolder)+'/') + email) + '/') + 'SS2') + '_') +nowTime) + '.png')
		CustomKeywords.'common.excel.writeExcel'('Fail', i, 5)
	}
}	
	else {
		'click Shopping cart'
		WebUI.click(findTestObject('Object Repository/Login/a_SCShipping',[('value'):'ico-cart']))
		'take screenshot'
		WebUI.takeScreenshot((((((((('ScreenShots' +'/Error/') + dateFolder)+'/') + email) + '/') + 'SS2') + '_') +nowTime) + '.png')
		CustomKeywords.'common.excel.writeExcel'('Fail', i, 5)	
		CustomKeywords.'common.excel.writeExcel'("No message", i, 6)
	}
}


'close browser'

WebUI.closeBrowser()
Robot robot = new Robot()
WebUI.delay(2)
'open Excel'
String sDownloadPathSystem = RunConfiguration.getProjectDir() + '/Excel'
String excelFile = 'Register.xlsx'
ExcelPath = sDownloadPathSystem+'/'+ excelFile
String linkFile = ExcelPath.replace('/', '\\\\')
File file = new File(linkFile)
Desktop desktop = Desktop.getDesktop()
desktop.open(file)
WebUI.delay(7)
Workbook workbook = ExcelKeywords.getWorkbook(linkFile)
Sheet sheet = ExcelKeywords.getExcelSheet(workbook, "Sheet1")
int lastRow = sheet.getLastRowNum()
robot.keyPress(KeyEvent.VK_CONTROL)
robot.keyPress(KeyEvent.VK_HOME)
Thread.sleep(200)
robot.keyRelease(KeyEvent.VK_CONTROL)
robot.keyRelease(KeyEvent.VK_HOME)
for(i=0;i<lastRow;i++) {
'take screenshot file excel 1'
robot.keyPress(KeyEvent.VK_DOWN)
robot.keyPress(KeyEvent.VK_SHIFT)
robot.keyPress(KeyEvent.VK_SPACE)
robot.keyRelease(KeyEvent.VK_DOWN)
robot.keyRelease(KeyEvent.VK_SHIFT)
robot.keyRelease(KeyEvent.VK_SPACE)

Thread.sleep(200)
String format = "png"
String fileName = i+'_' +'Screenshot Excel File' +'.' + format
String sScreenshotPath = RunConfiguration.getProjectDir() + '/ScreenshotExcel/' + '/'
Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
pathFilea = sScreenshotPath.replace('/', '\\\\')
BufferedImage screenFullImage = robot.createScreenCapture(screenRect)
ImageIO.write(screenFullImage, format, new File(pathFilea + fileName))
//robot.keyPress(KeyEvent.VK_CONTROL)
//robot.keyPress(KeyEvent.VK_S)
//robot.keyRelease(KeyEvent.VK_CONTROL)
//robot.keyRelease(KeyEvent.VK_S)
WebUI.delay(1)
}
'Close Excel file'
robot.keyPress(KeyEvent.VK_ALT)
robot.keyPress(KeyEvent.VK_F4)
robot.keyPress(KeyEvent.VK_ALT)
robot.keyPress(KeyEvent.VK_F4)
robot.keyRelease(KeyEvent.VK_ALT)
robot.keyRelease(KeyEvent.VK_F4)
robot.keyRelease(KeyEvent.VK_ALT)


