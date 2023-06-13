package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeActions2 {
    @Test
    public void practiceDragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement dropElement = driver.findElement(By.xpath("//div[.='Drop here']"));

        WebElement dropText = driver.findElement(By.xpath("//div[.='Drop here']"));
        String actualText = BrowserUtils.getText(dropText);
        String expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);

        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropElement).perform();

        WebElement dropText1 = driver.findElement(By.xpath("//div[.='Drop here']"));
        String actualText1 = BrowserUtils.getText(dropText1);
        String expectedText1 = "Dropped!";
        Assert.assertEquals(actualText, expectedText);

        Thread.sleep(2000);

        String actualbackgroundColor = dropElement.getCssValue("background-color");
        String expectedbackgroundColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualbackgroundColor, expectedbackgroundColor);

    }

    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement acceptClick = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptClick.click();

        WebElement notAccept = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actualMessage = BrowserUtils.getText(notAccept);
        String expectedMessage = "Not Acceptable";
        Assert.assertEquals(expectedMessage,actualMessage);

        WebElement dropBox = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-accept']//div[@id='droppable']"));
        String actualDropMessage = BrowserUtils.getText(dropBox);
        String expectedDropMessage = "Drop here";
        Assert.assertEquals(expectedDropMessage,actualDropMessage);

        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.clickAndHold(notAccept).moveToElement(dropBox).release().perform();

    }


}
