package com.test.blaze.pages;

import Utils.BrowserUtils;
import com.test.bank.tests.BankTestBase;
import com.test.blaze.tests.BlazeTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BlazeTestBase {

    public HomePage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[@id='itemc']")
    List<WebElement> categories;

    @FindBy (css = "#cartur")
    WebElement cartButton;


    public void findFromCategories (String nameCategory){
        for (WebElement categ: categories){
            if (BrowserUtils.getText(categ).equals(nameCategory)){
                categ.click();
                break;
            }
        }

    }
    public void cartClick(){
        cartButton.click();
    }

}
