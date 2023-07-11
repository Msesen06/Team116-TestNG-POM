package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
   public AmazonPage(){
        //baska package daki classların bu constructorı kullanabilmeleri icin
        //access modifierini public yapmamız gerekir
       // bu page classında locate kullanacak tum classlar
       //AmazonPage classından olusturması gerekir
       //obje olusturmak icin de mutlaka bu Constructor calısacak
       //o zaman bu classta Webdriverimizi bu cosntructor icinde olusturmak gerekir
       PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

   @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    public WebElement sonucYaziElementi;

}
