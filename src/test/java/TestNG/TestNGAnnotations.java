package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am before suite annotation");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am Before Test annotation");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before Class");
    }

    @BeforeMethod
    public void beforeMethod(){ // setup you automation
        System.out.println("I am beforeMethod annotation");
    }

    @Test
    public void test1(){
        System.out.println("I am test1 annotation");
    }

    @Test
    public void test2(){
        System.out.println("I am test2 annotation");
    }

    @AfterMethod
    public void afterMethod(){ // tear down and screenshot
        System.out.println("I am after Method annotation");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after Class annotation");

    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am after Test annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am after Suite annotation");
    }
}
