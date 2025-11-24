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

//WebUI.verifyElementVisible(findTestObject('Checkout/Page_STORE/Product_title_txt'))
//WebUI.click(findTestObject('Checkout/Page_STORE/Place-order_button'))
//WebUI.setText(findTestObject('Checkout/Page_STORE/input_name_textfield'), 'testing')
//WebUI.setText(findTestObject('Checkout/Page_STORE/input_country_textfield'), 'Indonesia')
//WebUI.setText(findTestObject('Checkout/Page_STORE/input_city_textfield'), 'Bandung')
//WebUI.setText(findTestObject('Checkout/Page_STORE/input-credit-card_textfield'), '73683-82382-728')
//WebUI.setText(findTestObject('Checkout/Page_STORE/input_month_textfield'), 'November')
//WebUI.setText(findTestObject('Checkout/Page_STORE/input_year_textfield'), '2026')
//WebUI.click(findTestObject('Checkout/Page_STORE/Purchase_popup_button'))
//WebUI.verifyElementVisible(findTestObject('Checkout/Page_STORE/p_Thank you for your purchase_lead text-muted'))
// ambil test data
def checkoutData = findTestData('Data Files/Checkout_Dataa')

// loop berdasarkan jumlah data
for (int i = 1; i <= checkoutData.getRowNumbers(); i++) {
    WebUI.verifyElementVisible(findTestObject('Checkout/Page_STORE/Product_title_txt'))

    WebUI.click(findTestObject('Checkout/Page_STORE/Place-order_button'))

    WebUI.setText(findTestObject('Checkout/Page_STORE/input_name_textfield'), checkoutData.getValue('Name', i))

    WebUI.setText(findTestObject('Checkout/Page_STORE/input_country_textfield'), checkoutData.getValue('Country', i))

    WebUI.setText(findTestObject('Checkout/Page_STORE/input_city_textfield'), checkoutData.getValue('City', i))

    WebUI.setText(findTestObject('Checkout/Page_STORE/input-credit-card_textfield'), checkoutData.getValue('Card', i))

    WebUI.setText(findTestObject('Checkout/Page_STORE/input_month_textfield'), checkoutData.getValue('Month', i))

    WebUI.setText(findTestObject('Checkout/Page_STORE/input_year_textfield'), checkoutData.getValue('Year', i))

    WebUI.click(findTestObject('Checkout/Page_STORE/Purchase_popup_button'))

    // delay untuk memastikan popup muncul
    WebUI.delay(2)

    boolean popupStatus = WebUI.verifyElementVisible(findTestObject('Checkout/Page_STORE/p_Thank you for your purchase_lead text-muted'), 
        FailureHandling.OPTIONAL)

    if (popupStatus) {
        println('✅ PURCHASE SUCCESS — wording muncul sesuai')

        // klik OK pada popup
        WebUI.click(findTestObject('Checkout/Page_STORE/OK-successpurchase_popup_button')) // screenshot jika ada error
    } else {
        println('❌ PURCHASE FAILED — wording tidak muncul')

        WebUI.takeScreenshot()
    }
}

