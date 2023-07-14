package tests.day13_TestNgFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class C04_NutellaAramaTesti {
    @Test
    public void test01(){
        //amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella icin arama yapın
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+Keys.ENTER);
        //Sonucların Nutella icerdigini test edin
        String expectedICerik=ConfigReader.getProperty("amazonArananKelime");
        String actualSonucYazisi=amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedICerik));

        //Sayfayi kapatın
        ReusableMethods.bekle(5);
        Driver.closeDriver();

    }
}
