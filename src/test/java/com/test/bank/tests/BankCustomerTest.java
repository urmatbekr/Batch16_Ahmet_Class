package com.test.bank.tests;

import com.test.bank.pages.BankCustomersPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase{
    @Test
    public void validateCustomerLoginTransactions(){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Balder", "123123",
                "Customer added successfully with customer id :");

        bankManagerPage.openAccountFunctionality(driver, "Ahmet Balder", "Dollar",
                "Account created successfully with account Number");

        bankManagerPage.customersFunctionality("Ahmet", "Balder", "123123");

        bankManagerPage.clickHomeButton();

        BankCustomersPage bankCustomersPage = new BankCustomersPage(driver);

    }
}
