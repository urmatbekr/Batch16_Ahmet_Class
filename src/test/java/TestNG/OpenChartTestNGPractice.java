package TestNG;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.redProperty("QA_url"));
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys(ConfigReader.redProperty("QA_openChart_username"));
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.sendKeys(ConfigReader.redProperty("QA_openChart_password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement closeSmallwindo = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeSmallwindo.click();
        WebElement DashBoredButton = driver.findElement(By.xpath("//i[@class='fas fa-tag']"));
        DashBoredButton.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < boxes.size(); i++) {
            Thread.sleep(2000);
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertTrue(boxes.get(i).isEnabled());
            Assert.assertTrue(!boxes.get(i).isSelected());
            boxes.get(i).click();
            Thread.sleep(1000);
            Assert.assertTrue(boxes.get(i).isSelected());
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }

    @Test
    public void findElementInDesendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement closeSmallwindo = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeSmallwindo.click();
        WebElement DashBoredButton = driver.findElement(By.xpath("//i[@class='fas fa-tag']"));
        DashBoredButton.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();

        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();

        Thread.sleep(2000);
        for (int i = 1; i < allProducts.size(); i++) {
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());

        }

        Collections.sort(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Thread.sleep(2000);
        Assert.assertEquals(actualProductOrder, expectedProductOrder);

    }

    @Test
    public void findElementInAsendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement closeSmallwindo = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeSmallwindo.click();
        WebElement DashBoredButton = driver.findElement(By.xpath("//i[@class='fas fa-tag']"));
        DashBoredButton.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        Thread.sleep(2000);
        WebElement productName = driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();
        Thread.sleep(3000);

        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();

        Thread.sleep(2000);

        for (int i = 1; i < allProducts.size(); i++) {
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());

        }
        Collections.sort(expectedProductOrder);
        Collections.reverse(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Thread.sleep(2000);
        Assert.assertEquals(actualProductOrder, expectedProductOrder);

    }

}
