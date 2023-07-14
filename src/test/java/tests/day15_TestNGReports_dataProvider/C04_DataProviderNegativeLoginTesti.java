package tests.day15_TestNGReports_dataProvider;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C04_DataProviderNegativeLoginTesti extends TestBaseRapor {
    static Faker faker =new Faker();
    @DataProvider
    public static Object[][] kullaniciListesi() {
       String[][] kullaniciIsimSifreleri={{ faker.name().fullName(),faker.internet().password()},
               {faker.name().fullName(),faker.internet().password()},
               {faker.name().fullName(),faker.internet().password()}};
       return kullaniciIsimSifreleri;
    }

    @Test(dataProvider="kullaniciListesi")
    public void cokluNegativeLoginTesti(String kullaniciAdi,String password){
        extentTest=extentReports.createTest("Data Provider","Coklu negatif login testi");
        // Qualitydemy anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("kullanıcı anasayfaya gider");

        // liste olarak verilen kullanici adi ve sifreleri ile
        /// giris yapilamadigini test edin

        /// ilk login linkine tiklayin
        QdPage qdPage=new QdPage();
        qdPage.cookie.click();
        qdPage.ilkloginElementi.click();

        /// kullanici adi ve sifresini yazip giris yapmayi deneyin
        qdPage.emailKutusuElementi.sendKeys(kullaniciAdi);
        qdPage.passwordKutusu.sendKeys(password);
        qdPage.loginElementi.click();
        extentTest.info("verilen "+kullaniciAdi+" kullanıcı ve "+password+" sifresi girerek login olmaya calısır");

        // giris yapilamadigini test edin
        Assert.assertTrue(qdPage.emailKutusuElementi.isDisplayed());
        extentTest.pass("yanlıs kullanıcı adı ve parola ile giris yapılamadıgını test eder");
        /// sayfayi kapatin
        Driver.closeDriver();
    }
}
