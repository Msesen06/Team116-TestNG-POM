package tests.day12_testNG;

import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class C02_Priority {
    /*
    TestNg testleri harf sırasına gore calıstırır
    natural order
    eger once calısmasını istedgimiz bir test varsa
    test methoduna priority yazıp sayı ataması yapıyoruz
     */
    @Test(priority = 3)
    public void amazonTest(){
        System.out.println("Amazon");
    }
    @Test(priority = 2)
    public void youTubeTest(){
        System.out.println("Youtube");
    }

    @Test(priority=1)
    public void wiseTest(){
        System.out.println("Wise");
    }
}
