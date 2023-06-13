package FramesAndFrame;

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
import java.util.List;

public class FramePractice {
    @Test
    public void framePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement headerFrame = driver.findElement(By.xpath("//h3"));
        System.out.println(headerFrame.getText());

        driver.switchTo().frame("mce_0_ifr");
        WebElement textFrame = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textFrame.clear();
        Thread.sleep(500);
        textFrame.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        headerFrame = driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(headerFrame));


    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        /*
        TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Python" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
         */

        WebElement linkPavilion = driver.findElement(By.linkText("Pavilion"));
        linkPavilion.click();
        BrowserUtils.switchById(driver);
        System.out.println(driver.getTitle());
        Actions actions = new Actions(driver);
        actions.scrollByAmount(400, 400).perform();
        WebElement Selenium = driver.findElement(By.partialLinkText("Selenium"));

        WebElement SeleniumPython = driver.findElement(By.partialLinkText("Python"));

        actions.moveToElement(Selenium).perform();

        SeleniumPython.click();

        String secondTitle = driver.getTitle();
        String expectedtitle = "Python Archives - qavalidation";
        Assert.assertEquals(secondTitle,expectedtitle);


        List<WebElement> PythonList = driver.findElements(By.xpath("//p//a"));
        for (WebElement textList: PythonList){
            System.out.println(BrowserUtils.getText(textList));
        }

        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */

        //driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        BrowserUtils.switchByTitle(driver,"iframe");
        driver.switchTo().frame("Framename1");
        WebElement cat1 = driver.findElement(By.linkText("Category1"));
        cat1.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting");

        WebElement header1 = driver.findElement(By.xpath("//h1"));
        String headtext=BrowserUtils.getText(header1);
        String expected = "Category Archives: SeleniumTesting";

        Assert.assertEquals(headtext,expected);
        Thread.sleep(2000);
        List <WebElement> linkHeaders = driver.findElements(By.xpath("//h3"));
        for (WebElement links:linkHeaders){
            System.out.println(BrowserUtils.getText(links));
        }

        BrowserUtils.switchByTitle(driver,"iframe");
        driver.switchTo().frame("Framename1");
        WebElement frameText = driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(frameText));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement cat3 = driver.findElement(By.linkText("Category3"));

        BrowserUtils.switchByTitle(driver, "Category Archives: SoftwareTesting");
        WebElement headerOne = driver.findElement(By.xpath("//h1"));
        System.out.println(headerOne.getText());



    }
}
