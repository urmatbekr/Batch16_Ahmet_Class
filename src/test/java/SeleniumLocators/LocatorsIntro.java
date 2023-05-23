package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    // LOCATORS --> is a wya to locate (find) element ad manipulate on it.
    public static void main(String[] args) throws InterruptedException {
        // ID Locator:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("file:///Users/urmatbekrazzakov/Desktop/Techtorial.html");
        driver.manage().window().maximize();

        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim();// it gets text from element

        String expectHeader = "Techtorial Academy";
        System.out.println(header.getText());

        System.out.println(actualHeader.equals(expectHeader)? "correct": "wrong");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        // NAME Locator
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");

        WebElement Name = driver.findElement(By.name("lastName"));
        Name.sendKeys("Bulbul");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("312229391");

        WebElement userName = driver.findElement(By.name("userName"));
        userName.sendKeys("adc@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("12 Main St.");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");

        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("34221");

        // Class Locator:

        WebElement alltools = driver.findElement(By.className("group_checkbox"));
        System.out.println(alltools.getText());

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected()? "Selected": "NOT Selected");

        WebElement javaBox3 = driver.findElement(By.id("cond3"));
        if (javaBox3.isDisplayed() && !javaBox3.isSelected()){
            javaBox3.click();
        }
        System.out.println(javaBox3.isSelected()? "Selected": "NOT Selected");

        WebElement javaBox4 = driver.findElement(By.id("cond4"));
        if (javaBox4.isDisplayed() && !javaBox4.isSelected()){
            javaBox4.click();
        }
        System.out.println(javaBox4.isSelected()? "Selected": "NOT Selected");


        // TAG NAME Locator:

        WebElement header2= driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement useTag = driver.findElement(By.tagName("u"));
        System.out.println(useTag.getText());

        Thread.sleep(2000);

        driver.quit();
    }
}
