package tests.day12_testNG;

import org.testng.annotations.Test;
import utilities.Driver;

import utilities.ReusableMethods;

public class C01_TestNGIlkTest {
    @Test
    public void test01(){
        /*
        Pomda driver olusturmak ve gerekli ayarları yapmak icin
        TestBase kullanmak yerine
        ayri bir driver class icerisinde
        bize driver dondurecek bir method olusturulması tercih edilmistir.
         */

        Driver.getDriver().get("https://www.amazon.com");
        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }
    @Test
    public void test02(){
        //youtube anasayfaya gidin
      Driver.getDriver().get("https://youtube.com");
        ReusableMethods.bekle(3);
        //url i yazdırın
        System.out.println(Driver.getDriver().getCurrentUrl());
        ReusableMethods.bekle(3);
        //sayfayı kapatın
        Driver.closeDriver();
    }


}
