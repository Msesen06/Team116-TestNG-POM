package tests.day13_TestNgFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReasableMethods;

public class C02_facebookTesti {
    @Test
    public void facebookTesti(){
        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker =new Faker();
        FacebookPage facebookPage=new FacebookPage();

        facebookPage.emailKutuElementi.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordElementi.sendKeys(faker.internet().password());
        facebookPage.loginButton.click();
        //4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.basarisizGirizYaziElementi.isDisplayed());
        ReasableMethods.bekle(15);
        Driver.closeDriver();
    }
}
