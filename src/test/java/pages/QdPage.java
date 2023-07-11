package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QdPage {
    public QdPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement loginButonElementi ;

    @FindBy(xpath = "//*[@id='login-email']")
    public WebElement emailKutusuElementi;

    @FindBy(xpath = "//*[@id='login-password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement loginElementi;

    @FindBy(xpath = "(//a[text()='My courses'])[1]")
    public WebElement basariliGirisElementi;
    @FindBy(xpath ="//a[@onclick='cookieAccept();']")
    public WebElement cookie;


}
