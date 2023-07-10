package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    public  static WebDriver driver;

    public static WebDriver getDriver(){
        /*
        Bundan sonra daha once driver olarak   TestBaseden alıp kullandıgımız
        Webdriverin yerine
        Driver classından getDriverı kullanacagız
        driver =new ChromeDriver();
        problem olusturuyor cunku her calıstıgında yeniden bir driver olusturuyor
        Bizim istedigimiz;
        ilk kullanımda olustursun
        ancak sonrakilerde olusturmasın


         */

        WebDriverManager.chromedriver().setup();

        if (driver==null) {
            driver=new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void closeDriver(){
        if (driver !=null){
            driver.close();
            driver=null;
        }

    }
}
