package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

public class BlazeData {

    @DataProvider (name = "orderData")
    public Object[][] getData(){
        return new Object[][]{
                {"Phones", "Nokia lumia 1520", "820", "Product added", "$820 *includes tax", "ahmet", "Turkiye", "Ankara", "1234123", "05", "2023"},
                {"Phones", "Nokia lumia 1520", "820", "Product added", "$820 *includes tax", "ahmet", "Turkiye", "Ankara", "1234123", "05", "2023"}
        };
    }
}
