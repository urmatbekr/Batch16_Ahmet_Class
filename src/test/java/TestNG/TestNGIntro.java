package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test (priority = 3, invocationCount =  10)
    public void test1 (){
        System.out.println("I am test one");
    }

    @Test (priority = 2)
    public void test2(){
        System.out.println("i am test2");
    }

    @Test (priority = 1)
    public void test3 (){
        System.out.println("I am test3");
    }
}
