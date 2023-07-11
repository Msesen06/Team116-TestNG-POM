package tests.day13_TestNgFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReasableMethods;

public class QDNegativeLoginTest {
    //1-   https://www.qualitydemy.com/ anasayfasina gidin
    //2- login linkine basin
    // 3- Kullanvalid 3 farkli test method’u olusturun.
    // - gecerli username, gecersiz password
    // - gecersiz username, gecerli password
    // - gecersiz username, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin
    @Test(groups = "smoke")
    public void gecersizPaswordTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));


        QdPage qdPage =new QdPage();
        qdPage.cookie.click();
        qdPage.loginButonElementi.click();
        qdPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        ReasableMethods.bekle(3);
        qdPage.loginElementi.click();
        Assert.assertTrue(qdPage.emailKutusuElementi.isDisplayed());
        Driver.closeDriver();


    }
    @Test(groups = "smoke")
    public void gecersizUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QdPage qdPage =new QdPage();
        qdPage.cookie.click();
        qdPage.loginButonElementi.click();
        qdPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        ReasableMethods.bekle(3);
        qdPage.loginElementi.click();
        Assert.assertTrue(qdPage.emailKutusuElementi.isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void gecersizPaswordUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QdPage qdPage =new QdPage();
        qdPage.cookie.click();
        qdPage.loginButonElementi.click();
        qdPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        ReasableMethods.bekle(3);
        qdPage.loginElementi.click();
        Assert.assertTrue(qdPage.emailKutusuElementi.isDisplayed());
        Driver.closeDriver();


    }
}
