package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class JSPractice {
    @Test
    public void jsPractice() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesClick = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        Actions actions = new Actions(driver);
        actions.click(yesClick).perform();
        WebElement yesText = driver.findElement(By.xpath("//p[@class='mt-3']"));
        Assert.assertEquals(BrowserUtils.getText(yesText), "You have selected Yes");

        WebElement impressiveClick = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        actions.click(impressiveClick).perform();

        WebElement impressiveText = driver.findElement(By.xpath("//p[@class='mt-3']"));
        Assert.assertEquals(BrowserUtils.getText(impressiveText), "You have selected Impressive");

        WebElement noClick = driver.findElement(By.xpath("//input[@id='noRadio']"));

        Assert.assertFalse(noClick.isEnabled());

    }

    @Test
    public void practice2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyText = driver.findElement(By.xpath("//div[@id='el_1666192783854_462']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",copyText);
        String expected = "Copyright © 2023";
        String actaul = BrowserUtils.getText(copyText);
        Assert.assertEquals(expected,actaul);

    }

    @Test
    public void buttonclick(){

    }

    @Test
    public void practiceMultipleWindows(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

//        String mainPage = driver.getWindowHandle();
//        Set<String> allPages = driver.getWindowHandles();
//        for (String id : allPages){
//            if (!id.equals(mainPage))
//                driver.switchTo().window(id);
//            break;
//        }
//        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver,"Contact");

    }
}
