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

// Mengimport test case untuk open browser
WebUI.callTestCase(findTestCase('Reusable_tc/Open browser'), [:], FailureHandling.STOP_ON_FAILURE)

// Klik tombol Signup
WebUI.comment('Klik menu Signup pada homepage')

WebUI.click(findTestObject('Homepage/Page_STORE/Signup_button'))

// Verifikasi popup elemen muncul
WebUI.comment('Pastikan popup register muncul')

WebUI.verifyElementVisible(findTestObject('Register/Page_STORE/Signup_popup_txt'))

WebUI.verifyElementVisible(findTestObject('Register/Page_STORE/Username_label'))

WebUI.comment("Input username: $GlobalVariable.username")

WebUI.setText(findTestObject('Register/Page_STORE/input_Username_textfield'), GlobalVariable.username)

WebUI.verifyElementVisible(findTestObject('Register/Page_STORE/Password_label'))

WebUI.comment('Input password')

WebUI.setText(findTestObject('Register/Page_STORE/input_Password_textfield'), GlobalVariable.password)

// Klik tombol Sign up
WebUI.comment('Klik tombol signup untuk proses registrasi user')

WebUI.click(findTestObject('Register/Page_STORE/Signup_popup_button'))

// Tunggu alert
WebUI.comment('Menunggu alert muncul')

if (WebUI.waitForAlert(5)) {
    String alertText = WebUI.getAlertText()

    WebUI.comment("Isi alert: $alertText")

    // CASE BERHASIL
    if (alertText.equals('Sign up successful.')) {
        WebUI.comment("✔ Registrasi BERHASIL untuk username: $GlobalVariable.username")

        WebUI.acceptAlert()

        WebUI.verifyElementPresent(findTestObject('Homepage/Page_STORE/Home_button'), 10) // CASE WORDING SALAH / USERNAME SUDAH ADA / PASSWORD KOSONG
        // **Kalau wording tidak sesuai — test harus FAIL**
    } else {
        WebUI.comment("❗ Registrasi GAGAL — alert: $alertText")

        WebUI.acceptAlert()

        WebUI.verifyMatch(alertText, 'Sign up successful.', false)
    }
    // Force FAIL
} else {
    WebUI.comment('❗ ERROR: Tidak ada alert muncul!')

    WebUI.takeScreenshot()

    WebUI.verifyEqual(true, false)
}

//WebUI.click(findTestObject('Register/Page_STORE/x-close-popup_button'))

