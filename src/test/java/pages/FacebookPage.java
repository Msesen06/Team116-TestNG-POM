package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

  @FindBy(xpath = "//*[@id='email']")
    public WebElement emailKutuElementi;


    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordElementi;


    @FindBy( xpath = "//*[@name='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement basarisizGirizYaziElementi;


}
