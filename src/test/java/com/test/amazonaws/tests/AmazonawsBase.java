package com.test.amazonaws.tests;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AmazonawsBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get("http://codefish-io-qa.s3-website-ap-northeast-1.amazonaws.com/");
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
