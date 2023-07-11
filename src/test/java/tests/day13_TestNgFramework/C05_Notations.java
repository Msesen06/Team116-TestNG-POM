package tests.day13_TestNgFramework;

import org.testng.annotations.*;

public class C05_Notations {
    @BeforeSuite
    public void setupSuit(){
        System.out.println("Before Suit calıstı");
    }
    @AfterSuite
    public void teardownSuite(){
        System.out.println("After Suit calıstı");
    }
    @BeforeTest
    public void setupTest(){
        System.out.println("Before test calıstı");
    }
    @AfterTest
    public void teardownTest(){
        System.out.println("After Test calisti");
    }
    @BeforeClass
    public void setupClass(){
        System.out.println("Before class calıstı");
    }
    @AfterClass
    public  void teardownClass(){

    }
    @BeforeMethod
    public void setupMethod(){
        System.out.println("Before method calıstı");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("After method calıstı");
    }

    @Test
    public void test01(){
        System.out.println("test 01 calıstı");
    }
    @Test
    public void test02(){
        System.out.println("test 02 calıstı");
    }


}
