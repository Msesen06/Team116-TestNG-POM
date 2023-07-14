package tests.day15_TestNGReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class C02_RaporluNutellaTesti extends TestBaseRapor {


    @Test
    public void raporluTest() throws IOException {
        extentTest=extentReports.createTest("Raporlu Nutella Arama","Kullanıcı Amazonda Nutella arayabilmeli");
        //amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Kullancı amazon anasayfaya gider");
        //Nutella icin arama yapın
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("Nutella icin arama yapar");
        //sonucların nutella icerdigini test edin
        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        extentTest.pass("Sonucların Nutella icerdigini test eder");
        //sayfayı kapatın
        Driver.closeDriver();
    }


}
