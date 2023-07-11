package tests.day13_TestNgFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReasableMethods;

public class C06_QDLoginTest {
    @Test(groups = {"smoke,mini regression1"})
    public void test01(){
        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //2- login linkine basin
        QdPage qdPage=new QdPage();
        qdPage.cookie.click();
        qdPage.loginButonElementi.click();
        ReasableMethods.bekle(2);

        // 3- Kullanici email’i olarak valid email girin

        qdPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));

        // 4- Kullanici sifresi olarak valid sifre girin
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        // 5- Login butonuna basarak login olun
        ReasableMethods.bekle(2);
        qdPage.loginElementi.click();
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        Driver.closeDriver();
    }

}
