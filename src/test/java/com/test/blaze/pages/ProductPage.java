package com.test.blaze.pages;

import Utils.BrowserUtils;
import com.test.blaze.tests.BlazeTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BlazeTestBase {

    public ProductPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h4[@class='card-title']//a")
    List<WebElement> products;

    public void findMacbookPro(WebDriver driver, String productName) throws InterruptedException {

        Thread.sleep(1000);

        for (WebElement prod: products){

            Thread.sleep(1000);

            if (BrowserUtils.getText(prod).equals(productName)){

                BrowserUtils.scrollWithJS(driver, prod);

                prod.click();

                break;
            }
        }

    }
}
