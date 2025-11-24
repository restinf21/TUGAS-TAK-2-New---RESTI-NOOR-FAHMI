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

//WebUI.callTestCase(findTestCase('Reusable_tc/Open browser'), [:], FailureHandling.STOP_ON_FAILURE)
//WebUI.click(findTestObject('Product and detail product/Page_STORE/samsung-galaxys6_product'))
//WebUI.verifyElementVisible(findTestObject('Product and detail product/Page_STORE/Samsung-galaxys6_title_detailproduct_txt'))
//WebUI.click(findTestObject('Product and detail product/Page_STORE/AddToCart_Samsunggalacys6_detailproduct_button'))
//WebUI.waitForAlert(10)
//WebUI.acceptAlert()
//WebUI.click(findTestObject('Product and detail product/Page_STORE/Home_button'))
//WebUI.verifyElementVisible(findTestObject('Homepage/Page_STORE/Home_button'))
//WebUI.click(findTestObject('Homepage/Page_STORE/Next_button'))
//WebUI.click(findTestObject('Product and detail product/Page_STORE/ASUSFullHd_product'))
//WebUI.verifyElementVisible(findTestObject('Product and detail product/Page_STORE/ASUSFullHD_title_detailproduct_txt'))
//WebUI.click(findTestObject('Product and detail product/Page_STORE/AddToCart_AssusFullHD_detailproduct_button'))
//WebUI.waitForAlert(10)
//WebUI.acceptAlert()
//WebUI.click(findTestObject('Product and detail product/Page_STORE/Cart_detailproduct_button'))
// OPEN BROWSER & GO TO SITE
// STEP 1 — Pilih Samsung Galaxy S6 dari homepage
WebUI.click(findTestObject('Product and detail product/Page_STORE/samsung-galaxys6_product'))

// Verifikasi halaman detail Samsung Galaxy S6 tampil
if (WebUI.verifyElementVisible(findTestObject('Product and detail product/Page_STORE/Samsung-galaxys6_title_detailproduct_txt'), 
    FailureHandling.OPTIONAL)) {
    WebUI.comment('Detail product Samsung Galaxy S6 berhasil terbuka.')
} else {
    WebUI.comment('❗ ERROR: Halaman detail Samsung Galaxy S6 tidak muncul.')

    WebUI.takeScreenshot()
}

// Klik Add to cart
WebUI.click(findTestObject('Product and detail product/Page_STORE/AddToCart_Samsunggalacys6_detailproduct_button'))

// Verifikasi alert Add to cart muncul
if (WebUI.waitForAlert(10)) {
    WebUI.comment('Alert berhasil muncul untuk Samsung Galaxy S6.')

    WebUI.acceptAlert()
} else {
    WebUI.comment('❗ ERROR: Tidak ada alert setelah klik Add to Cart untuk Samsung Galaxy S6.')

    WebUI.takeScreenshot()
}

// STEP 2 — Kembali ke halaman Home
WebUI.click(findTestObject('Product and detail product/Page_STORE/Home_button'))

if (WebUI.verifyElementVisible(findTestObject('Homepage/Page_STORE/Home_button'), FailureHandling.OPTIONAL)) {
    WebUI.comment('Berhasil kembali ke halaman Home.')
} else {
    WebUI.comment('❗ ERROR: Tidak kembali ke halaman Home.')

    WebUI.takeScreenshot()
}

// Navigasi ke page berikutnya
WebUI.click(findTestObject('Homepage/Page_STORE/Next_button'))

// STEP 3 — Pilih ASUS Full HD
WebUI.click(findTestObject('Product and detail product/Page_STORE/ASUSFullHd_product'))

// Verifikasi halaman detail ASUS Full HD tampil
if (WebUI.verifyElementVisible(findTestObject('Product and detail product/Page_STORE/ASUSFullHD_title_detailproduct_txt'), 
    FailureHandling.OPTIONAL)) {
    WebUI.comment('Detail product ASUS Full HD berhasil terbuka.')
} else {
    WebUI.comment('❗ ERROR: Halaman detail ASUS Full HD tidak tampil.')

    WebUI.takeScreenshot()
}

// Klik Add to cart
WebUI.click(findTestObject('Product and detail product/Page_STORE/AddToCart_AssusFullHD_detailproduct_button'))

// Verifikasi alert muncul setelah add cart
if (WebUI.waitForAlert(10)) {
    WebUI.comment('Alert berhasil muncul untuk ASUS Full HD.')

    WebUI.acceptAlert()
} else {
    WebUI.comment('❗ ERROR: Tidak ada alert setelah klik Add to Cart ASUS Full HD.')

    WebUI.takeScreenshot()
}

// STEP 4 — Buka Cart
WebUI.click(findTestObject('Product and detail product/Page_STORE/Cart_detailproduct_button'))

// Verifikasi cart page berhasil terbuka
if (WebUI.verifyElementVisible(findTestObject('Product and detail product/Page_STORE/Cart_detailproduct_button'), FailureHandling.OPTIONAL)) {
    WebUI.comment('Berhasil membuka halaman Cart.')
} else {
    WebUI.comment('❗ ERROR: Gagal membuka halaman Cart.')

    WebUI.takeScreenshot()
}

