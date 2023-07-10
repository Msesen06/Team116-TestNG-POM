package tests.day12_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_DependsOnMethods {
    //Amazon aansayfaya gidin
    //3 farklı test methodu olusturup su testleri yapın
    //1- url 'in amazon icerdigini test edin
    //2- Nutella aratıp sonucun nutella icerdigini test edin
    //3- ilk urune tıklayıp acılan sayfada urun isminin Nutella icerdigini test edin
    @Test(priority = -3)
    public void urlTest(){
        Driver.getDriver().get("https://amazon.com");
        //1- url 'in amazon icerdigini test edin
        String expectedUrlIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test(dependsOnMethods = "urlTest")
    public void nutellaAramaTest(){
        //2- Nutella aratıp sonucun nutella icerdigini test edin
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSonucElementi=Driver.getDriver().findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik="Nutella";
        String actualIcerik=aramaSonucElementi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

    }
    @Test(dependsOnMethods = "nutellaAramaTest")
    public void urunIsimTest(){
        Driver.getDriver()
                .findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]"))
                .click();
        WebElement urunIsimElementi=Driver.getDriver().findElement(By.xpath("//span[@id='productTitle']"));
        String expectedIcerik="Nutella";
        String actualIcerik=urunIsimElementi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

    }
}
