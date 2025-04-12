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

'Open Browser and navigate to Coinmarketcap website'
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.urlCoinMarket)

'Filter DeFi in all categories'
WebUI.click(findTestObject('Object Repository/FilterFunction/btnFilter'))

WebUI.verifyElementClickable(findTestObject('Object Repository/FilterFunction/divAllCategories'))

WebUI.click(findTestObject('Object Repository/FilterFunction/divAllCategories'))

WebUI.setText(findTestObject('Object Repository/FilterFunction/input_text'), 
    'Defi')

WebUI.click(findTestObject('Object Repository/FilterFunction/div_DeFi'))

WebUI.click(findTestObject('Object Repository/FilterFunction/btnApply'))

'Click one of the coins and verify if it is a DeFi coin'

WebUI.click(findTestObject('Object Repository/FilterFunction/divAvalanche'))

DeFiCoin = WebUI.verifyElementPresent(findTestObject('Object Repository/FilterFunction/a_DeFi'), 
    0)

println("${DeFiCoin} confirmed")
