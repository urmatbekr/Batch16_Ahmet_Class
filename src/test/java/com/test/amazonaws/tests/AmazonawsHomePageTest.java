package com.test.amazonaws.tests;

import com.test.amazonaws.pages.LoginPage;
import com.test.amazonaws.pages.RegisterPage;
import com.test.amazonaws.pages.SuccessRegistrPage;
import org.testng.annotations.Test;

public class AmazonawsHomePageTest extends AmazonawsBase{

    @Test
    public void validateLoginFunction() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        loginPage.clearInput();
        loginPage.registerbutton();
        registerPage.RegisterFunction("kikiki1234", "kikiki123");
        Thread.sleep(2000);
        loginPage.clearInput();
        SuccessRegistrPage successRegistrPage = new SuccessRegistrPage(driver);
        successRegistrPage.loginFunction("kikiki1234", "kikiki123");
    }
}