package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/urmatbekrazzakov/Desktop/Techtorial.html");

        //LINKTEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();

        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader)? "Correct": "False");



        /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */

        driver.navigate().back();

        WebElement selenLink = driver.findElement(By.linkText("Selenium"));
        selenLink.click();

        WebElement seleniumLink = driver.findElement(By.tagName("h1"));
        String actualSelen = seleniumLink.getText().trim();
        String expectedSelen = "Selenium automates browsers. That's it!";
        System.out.println(actualSelen.equals(expectedSelen)? "Correct": "False");

        driver.navigate().back();

        WebElement cucmLink = driver.findElement(By.linkText("Cucumber"));
        cucmLink.click();

        WebElement cucmberLink = driver.findElement(By.tagName("h1"));
        String actualcucmber = cucmberLink.getText().trim();
        String expectedcucmber = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualcucmber.equals(expectedcucmber)? "Correct": "False");


        driver.navigate().back();

        WebElement ngLink = driver.findElement(By.linkText("TestNG"));
        ngLink.click();

        WebElement TestNGLink = driver.findElement(By.tagName("h2"));
        String actualNG = TestNGLink.getText().trim();
        String expectedNG = "TestNG";
        System.out.println(actualNG.equals(expectedNG)? "Correct": "False");

        driver.navigate().back();

        Thread.sleep(3000);
        // Locator PARTIALLINKTEXT:
        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());

        driver.quit();
    }

}
