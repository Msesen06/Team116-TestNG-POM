package tests.day14_TestNgFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_softAssertions {

    @Test(groups = "mini regression1")
    public void nutellaTesti(){
        //amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //title ın best icermedigini test edin
        //softAssert kullanmak icin obje olusturmalıyız
        SoftAssert softAssert=new SoftAssert();
        String unexpectedIcerik="amazon";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertFalse(actualTitle.contains(unexpectedIcerik),"title istenmeyen icerik barındırıyor");
        //url in "https://www.amazon.com/" oldugunu test edin
        String expectedUrl="https://www.amazon.com";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"url uysumuyor");
        //Nutella aratın
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Kutella"+ Keys.ENTER);

        //ARama sonuclarının Nutella icerdigini test edin

        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.sonucYaziElementi.getText();
        softAssert.assertTrue(actualSonucYazisi.contains(expectedIcerik),"arama soncuları Nutella icermiyor");
        softAssert.assertAll();
        // bu komut tum tesleri raporlar ve failed olan herhangi
        //bir assert varsa assertions error verip durdurur
        //ancak tum hataları bu komut satırında verir
        //tum testlerimiz bittikten sonra softAssert ın not aldıgı
        //hataları raporlamasını isteriz

    }
}
