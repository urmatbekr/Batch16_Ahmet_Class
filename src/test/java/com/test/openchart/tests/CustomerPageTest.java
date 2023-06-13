package com.test.openchart.tests;

import com.test.openchart.pages.CustomerPage;
import com.test.openchart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerPageTest extends OpenChartTestBase{

    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateLoginFunctionality("demo", "demo");
        Assert.assertEquals(driver.getTitle().trim(), "Dashboard");
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.addCustomerFunctionality( driver, "John", "Li", "aahmetbaldir@gmail.com",
                "12345", "12345");
    }
}
