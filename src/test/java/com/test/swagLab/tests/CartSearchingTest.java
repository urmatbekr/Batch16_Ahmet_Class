package com.test.swagLab.tests;

import Utils.ConfigReader;
import com.test.swagLab.pages.InventoryPage;
import com.test.swagLab.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartSearchingTest extends SwagLabBase{


    @Test(dataProvider = "validateCart", dataProviderClass = LoginData.class)
    public void validateProductCart(String login, String password,
                                    String expectedMessage, String expectedProduct,
                                    String expectedDescription, String expectedPrice) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality(ConfigReader.redProperty("QA_Swag_login"),
                ConfigReader.redProperty("QA_Swag_password"));

        Assert.assertEquals(driver.getCurrentUrl(), expectedMessage);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.productCart( expectedProduct,  expectedDescription,  expectedPrice);

    }

}
