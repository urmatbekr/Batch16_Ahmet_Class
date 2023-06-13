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

public class DragandDrop {
    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement dropArea = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getText(dropArea);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(expectedMessage,actualMessage);

        String actualbackgroundColor = dropArea.getCssValue("background-color");
        String expectedbackgroundColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualbackgroundColor,expectedbackgroundColor);

        WebElement circleElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(circleElement,dropArea).perform();

        WebElement dropResult = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualNewMessage = BrowserUtils.getText(dropResult);
        String expectedNewMessage = "You did great!";
        Assert.assertEquals(actualNewMessage,expectedNewMessage);


    }

    @Test
    public void DragPractice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement dragLeftArea = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage = BrowserUtils.getText(dragLeftArea);
        String expectedMessage = "Drag the small circle here ...";
        Assert.assertEquals(expectedMessage,actualMessage);

        String colorBox= dragLeftArea.getCssValue("background-color");
        String expectedBoxColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(colorBox,expectedBoxColor);

        Thread.sleep(2000);
        WebElement circleDragible = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(circleDragible).moveToElement(dragLeftArea).release().perform();

        WebElement dropResult = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualNewMessage = BrowserUtils.getText(dropResult);
        String expectedNewMessage = "You did great!";
        Assert.assertEquals(actualNewMessage,expectedNewMessage);

    }
}
