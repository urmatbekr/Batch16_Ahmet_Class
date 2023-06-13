package com.test.blaze.pages;

import Utils.BrowserUtils;
import com.github.dockerjava.api.model.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//td")
    List <WebElement> cartProductInfo;

    @FindBy (xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderButton;

    public void cartInfoChecking(String name, String price) throws InterruptedException {
        List<String> expectedArray = Arrays.asList("",name, price,"");
        Thread.sleep(1000);
        for (int i =1; i<cartProductInfo.size()-1; i++){
            Assert.assertEquals(BrowserUtils.getText(cartProductInfo.get(i)),expectedArray.get(i));
        }
        placeOrderButton.click();
    }
}
