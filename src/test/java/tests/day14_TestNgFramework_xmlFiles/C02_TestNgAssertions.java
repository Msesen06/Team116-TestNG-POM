package tests.day14_TestNgFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_TestNgAssertions {
    @Test
    public void nutellaTesti(){
        //amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //title ın best icermedigini test edin
        String unexpectedIcerik="best";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedIcerik),"Titleda istenmeyen icerik var");
        //url in "https://www.amazon.com/" oldugunu test edin
        String expectedUrl="https://www.amazon.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"url beklenen farklı");
        //Nutella aratın
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //ARama sonuclarının Nutella icerdigini test edin

        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik),"arama soncu Nutella icermiyor");
        Driver.closeDriver();

    }
}
