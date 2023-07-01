package WaitTimes;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicityWait {

    @Test
    public void validateTheTest(){
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement start= driver.findElement(By.xpath("//button"));
        start.click();
        WebElement givenText = driver.findElement(By.xpath("//h4[contains(text(),'Hello')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        givenText=wait.until(ExpectedConditions.visibilityOf(givenText));
        Assert.assertEquals(BrowserUtils.getText(givenText), "Hello World!");

    }

    @Test
    public void validateText2(){
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (checkbox.isEnabled() && !checkbox.isSelected())
        checkbox.click();
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();
        WebElement textGone= driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(textGone));
        Assert.assertEquals(BrowserUtils.getText(textGone), "It's gone!");
    }
}
