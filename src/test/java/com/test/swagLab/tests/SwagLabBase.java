package com.test.swagLab.tests;

import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SwagLabBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.redProperty("QA_Swag_url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


