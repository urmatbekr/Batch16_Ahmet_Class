package com.test.openchart.tests;

import Utils.BrowserUtils;
import com.test.openchart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends OpenChartTestBase{


    @Test
    public void happyPathValidateLoginFunctionality () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateLoginFunctionality("demo", "demo");
        Assert.assertEquals(driver.getTitle().trim(), "Dashboard");
    }

    @Test
    public void validateNegativeLogin () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateLoginFunctionality("delo", "delo");
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.errorMessage().trim(), "No match for Username and/or Password.");
    }
}
