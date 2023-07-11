package tests.day13_TestNgFramework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReasableMethods;

public class C01_PagesIlkTest {

    @Test
    public void amazonTest(){
        //amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");
        //Nutella icin arama yapın
        //arama kutusunun locatora ihtiyac var locatorlar
        AmazonPage amazonPage =new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //Sonucların Nutella icerdigini test edin
        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        //Sayfayi kapatın
        ReasableMethods.bekle(5);
        Driver.closeDriver();
    }

}
