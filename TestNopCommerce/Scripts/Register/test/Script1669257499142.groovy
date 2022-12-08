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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook

for(s=1;s<7;s++) {
	'open Browser'
	WebUI.openBrowser('https://demo.nopcommerce.com/')
	Random rnd = new Random()
	Date today = new Date()
	WebDriver driver = DriverFactory.getWebDriver()
	String dateFolder = today.format('dd.MM.yyyy').replace('.', '-')
	String nowTime = today.format('dd.MM.yyyy hh:mm:ss').replace(':', '.')
	'maximize demo.nopcommerce '
	WebUI.maximizeWindow()
	'read emai in file excel'
	String email =	CustomKeywords.'common.excel.readExcel'(s,1)
	
	'read password in file excel'
	String password =	CustomKeywords.'common.excel.readExcel'(s,2)
	
	'click Login'
	WebUI.click(findTestObject('Object Repository/Login/a_Login'))
	
	'input Email'
	WebUI.setText(findTestObject('Object Repository/Login/input_Text',[('value'):'Email']), email)
	
	'input Password'
	WebUI.setText(findTestObject('Object Repository/Login/input_Text',[('value'):'Password']), password)
	
	'list menu Computers, Electronics, Apparel, Digital downloads, Books, Jewelry, Gift Cards'
	List<String> ListItem = new ArrayList()
	List<WebElement> listMenu = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li/a"))
	for(int i=0; i<listMenu.size(); i++){
		a = listMenu.get(i).getText()
		ListItem.add(a)
	}
	println ListItem 

	rndMenu= rnd.nextInt(ListItem.size()-4)
	
	'click list menu Computers, Electronics, Apparel, Digital downloads, Books, Jewelry, Gift Cards'
	WebUI.click(findTestObject('Object Repository/Login/a_Navigate',[("Text"):ListItem[rndMenu]]))

	'sublist in Computers, Electronics, Apparel'
	List<String> ListSubCategories = new ArrayList()
	List<WebElement> listCategories = driver.findElements(By.xpath("//div[@class='item-grid']//h2/a"))
	for(n=0;n<listCategories.size();n++) {	
		b =listCategories.get(n).getText()
		ListSubCategories.add(b)
	}
	println ListSubCategories
	
	'click sublist in Computers, Electronics, Apparel'
	rndCategories= rnd.nextInt(ListSubCategories.size())
	WebUI.click(findTestObject('Object Repository/Product/Computers/div_Dessktops',[('Text'):ListSubCategories[rndCategories]]))

	'list img product-title'
	List<String> ListItemProduct = new ArrayList()
	List<WebElement> listProduct = driver.findElements(By.xpath("//div[@class='item-grid']//child::div[@class='picture']"))
	for(m=0;m<listProduct.size();m++) {
		b =listProduct.get(m).getText()
		ListItemProduct.add(b)
	}
	rndProduct= rnd.nextInt(ListItemProduct.size())

	'click product '
	WebUI.click(findTestObject('Object Repository/Product/Computers/div_Clothing',[("Text"):ListItemProduct[rndProduct]]))

	List<String> ProducteList = new ArrayList()
	List<String> productId = driver.findElements(By.xpath('//div[@data-productid]'))
	'get data-productid of card div[@data-productid] '
	for (WebElement ele1 : productId){
		String value = ele1.getAttribute('data-productid')
		ProducteList.add(value)
	}
	println ProducteList
	'check product how many Add to cart'
	List<String> ProductidAddToCartButtonList = new ArrayList()
	for(i=0;i<ProducteList.size();i++) {
	
		List<String> ListProdutcId= driver.findElements(By.xpath('//div[@class="page product-details-page"]//div[@data-productid="'+ProducteList.get(i)+'"]//div[@class="add-to-cart"]'))
		for(WebElement ele2: ListProdutcId){
			String value = ele2.getAttribute("class")
			if (value != null) {
				ProductidAddToCartButtonList.add(ProducteList.get(i))
			}
		}
	}

	println ProductidAddToCartButtonList

	if(ProductidAddToCartButtonList.size() == 0){

		'take screenshot'
		WebUI.takeScreenshot((((((((('ScreenShots' +'/Error/') + dateFolder)+'/') + email) + '/') + 'SS1') + '_') +nowTime) + '.png')
	}
	else if(ProductidAddToCartButtonList.size() != 1) {
			int spam = ProductidAddToCartButtonList.size()/2
			int productid = 1+ rnd.nextInt(spam)
				
			'click button Addtocart'
			WebUI.click(findTestObject('Object Repository/TC_AddToCart/btn_AddToCart',[('index'):productid]))
	}
	else if(ProductidAddToCartButtonList.size() == 1){
			List<String> ListProdutcAttributesId = new ArrayList()
			'List name attributes id of card dd (product have class="attributes") '
			List<String> ListProdutcAttributes= driver.findElements(By.xpath('//div[@class="overview"]/div[@class="attributes"]//dd'))
			for(WebElement ele3: ListProdutcAttributes){
				String value = ele3.getAttribute("id")
				ListProdutcAttributesId.add(value)
			}
			println ListProdutcAttributesId
			
			List<String> ListProdutcAttributesSelect = new ArrayList()
			List<String> ListSelect = new ArrayList()
			List<String> ListProdutcSelect= driver.findElements(By.xpath('//div[@class="overview"]/div[@class="attributes"]//dd/*'))
			for (int ib = 0; ib < ListProdutcSelect.size(); ib++){
				WebElement a = ListProdutcSelect.get(ib)
				String value = a.tagName
				String dataattr = a.getAttribute('data-attr')
				'List name card child of card dd'
				ListProdutcAttributesSelect.add(value)
				'List name attributes card chid of card dd'
				ListSelect.add(dataattr)
			}
			println(ListProdutcAttributesSelect)
			println(ListSelect)
			'list name value in card select'
			for(a=0;a<ListProdutcAttributesId.size();a++) {
				if(ListProdutcAttributesSelect.get(a).equals("select")) {
					List<String> ListProdutcSelectValue = new ArrayList()
					List<String> listOption= driver.findElements(By.xpath('//div[@class="attributes"]//dl//dd//select[@data-attr="'+ListSelect.get(a)+'"]/option'))
					for(o=1;o<listOption.size();o++) {
						WebElement ele4 = listOption.get(o)
						String value =ele4.getAttribute("value") 
						ListProdutcSelectValue.add(value)
					}
					println ListProdutcSelectValue
					rndProduct= rnd.nextInt(ListProdutcSelectValue.size())
					'select option select'
					WebUI.selectOptionByValue(findTestObject("Object Repository/Product/Computers/select_ProductAttribute",[("value"):ListSelect.get(a)]),ListProdutcSelectValue.get(rndProduct), false)
				}
				//list option card ul
				else if(ListProdutcAttributesSelect.get(a).equals("ul")) {
						List<String> ListProdutRadio = new ArrayList()
						List<String> listRadio= driver.findElements(By.xpath('//div[@class="attributes"]//dl//dd/ul[@data-attr="'+ ListSelect.get(a) +'"]/li/label'))
						for(ra=0;ra<listRadio.size();ra++) {
							WebElement ele5 = listRadio.get(ra)
							String value=ele5.getAttribute("data-attr-value")
							ListProdutRadio.add(value)			
						}
						println ListProdutRadio
						'click option radio'
						WebUI.click(findTestObject("Object Repository/Product/Computers/li_Raido",[("value"):ListSelect.get(a)]))
				}
				//input data in input box
				else if(ListProdutcAttributesSelect.get(a).equals("input")) {
			
						List<String> listInput= driver.findElements(By.xpath('//div[@class="attributes"]//dd//input'))
						for(ra=0;ra<listInput.size();ra++) {
							WebElement ele6 = listInput.get(ra)
							String value=ele6.getAttribute("id")
							'input data'
							WebUI.setText(findTestObject('Object Repository/Product/Computers/div_TextInput',[('value'):value]), 'I am Hang')
						}
				}	
			}

			'click Add to cart'
			WebUI.click(findTestObject('Object Repository/TC_AddToCart/btn_AddToCart',[('index'):'1']))

	}
	'get nam nam product and total'
	nameProduct = WebUI.getText(findTestObject('Object Repository/Register/td_NameProduct'))
	total = WebUI.getText(findTestObject('Object Repository/Register/span_Total'))
	CustomKeywords.'common.excel.writeExcel'(nameProduct,s,3)
	CustomKeywords.'common.excel.writeExcel'(total,s, 4)

	result = CustomKeywords.'common.verify.verifyObjectPresent'(findTestObject('Object Repository/Product/p_message'))
	if(result==true) {
		re = CustomKeywords.'common.verify.verifyObjectPresent'(findTestObject('Object Repository/TC_AddToCart/div_message'))
		if(re==true) {
			WebUI.delay(1)
			'click Shopping cart'
			WebUI.click(findTestObject('Object Repository/Login/a_SCShipping',[('value'):'ico-cart']))
			'take screenshot'
			WebUI.takeScreenshot((((((((('ScreenShots' +'/Success/') + dateFolder)+'/')+ email) + '/') + 'SS1') + '_') +nowTime) + '.png')
			CustomKeywords.'common.excel.writeExcel'('Pass', s, 5)
		}
		else {
			message = WebUI.getText(findTestObject('Object Repository/Product/p_message'))
			CustomKeywords.'common.excel.writeExcel'(message, s, 6)
			'take screenshot'
			WebUI.takeScreenshot((((((((('ScreenShots' +'/Error/') + dateFolder)+'/') + email) + '/') + 'SS2') + '_') +nowTime) + '.png')
			CustomKeywords.'common.excel.writeExcel'('Fail', s, 5)
		}
	}
	else {
		'click Shopping cart'
		WebUI.click(findTestObject('Object Repository/Login/a_SCShipping',[('value'):'ico-cart']))
		'take screenshot'
		WebUI.takeScreenshot((((((((('ScreenShots' +'/Error/') + dateFolder)+'/') + email) + '/') + 'SS2') + '_') +nowTime) + '.png')
		CustomKeywords.'common.excel.writeExcel'('Fail', s, 5)
		
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
for(x=0;x<lastRow;x++) {
'take screenshot file excel 1'
robot.keyPress(KeyEvent.VK_DOWN)
robot.keyPress(KeyEvent.VK_SHIFT)
robot.keyPress(KeyEvent.VK_SPACE)
robot.keyRelease(KeyEvent.VK_DOWN)
robot.keyRelease(KeyEvent.VK_SHIFT)
robot.keyRelease(KeyEvent.VK_SPACE)

Thread.sleep(200)
String format = "png"
String fileName = x+'_' +'Screenshot Excel File' +'.' + format
String sScreenshotPath = RunConfiguration.getProjectDir() + '/ScreenshotExcel/' + '/'
Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
pathFilea = sScreenshotPath.replace('/', '\\\\')
BufferedImage screenFullImage = robot.createScreenCapture(screenRect)
ImageIO.write(screenFullImage, format, new File(pathFilea + fileName))
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
