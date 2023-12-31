package tests.day15_TestNGReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderAmazonAramaTesti {
    //Dataprovider notasyonuna sahip methodlar ciftkatlı bir array olmak zorunda
    @DataProvider
    public static Object[][] AranacakUrunListesi() {

        String[][] urunList={{"Nutella"},{"Cokokrem"},{"Java"},{"Selenium"},{"Samsung"},{"Apple"}};
        return urunList;
    }

    @Test(dataProvider = "AranacakUrunListesi")
    public void cokluAramaTesti(String aranacakUrun){
        //amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //verilen listedeki her bir urun icin ayrı ayrı
        //arama yapıp sonucların o urunu icerdigini test edin
        // Nutella, Cokokrem, Java, Selenium, Apple, Samsung
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
        Assert.assertTrue(amazonPage.sonucYaziElementi.getText().contains(aranacakUrun));
        Driver.quitDriver();
    }
}
