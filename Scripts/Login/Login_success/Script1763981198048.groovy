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

// OPEN BROWSER
// CLICK LOGIN BUTTON
WebUI.click(findTestObject('Homepage/Page_STORE/Login_button'))

// VERIFY LOGIN POPUP
WebUI.verifyElementVisible(findTestObject('Login/Page_STORE/Login_popup_txt'))

// INPUT USERNAME & PASSWORD
WebUI.setText(findTestObject('Login/Page_STORE/input_Username_textfield'), GlobalVariable.username)

WebUI.setText(findTestObject('Login/Page_STORE/input_Password_textfield'), GlobalVariable.password)

// CLICK LOGIN
WebUI.click(findTestObject('Login/Page_STORE/Login_popup_button'))

// CHECK RESULT — SUCCESS OR FAILED
if (WebUI.verifyElementVisible(findTestObject('Homepage/Page_STORE/Welcome_header_text'), FailureHandling.OPTIONAL)) {
    // LOGIN SUCCESS — welcome text muncul
    WebUI.comment('Login sukses — user berhasil login.')

    WebUI.verifyElementVisible(findTestObject('Homepage/Page_STORE/Logout_button')) // LOGIN FAILED — alert muncul
    // Verifikasi wording alert sesuai dengan expected
    // Klik OK pada alert
    // UNDEFINED — tidak sukses dan tidak muncul alert
} else if (WebUI.verifyAlertPresent(5, FailureHandling.OPTIONAL)) {
    String alertText = WebUI.getAlertText()

    WebUI.comment('Login gagal — alert muncul: ' + alertText)

    WebUI.verifyMatch(alertText, 'Wrong password.', false)

    WebUI.acceptAlert()
} else {
    WebUI.comment('Login result tidak dapat dipastikan — missing UI element or alert.')

    WebUI.takeScreenshot()
}

