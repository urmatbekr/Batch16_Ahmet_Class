package com.test.blaze.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BlazeTestBase {
    public WebDriver driver;


    @BeforeMethod
    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*");
//
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.demoblaze.com/index.html");
        driver = DriverHelper.getDriver();
        driver.get("https://www.demoblaze.com/index.html");

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver, "blazePictures");
        }
    driver.quit();
    }
}
