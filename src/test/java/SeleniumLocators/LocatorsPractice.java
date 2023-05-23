package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);

         /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */

        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Urmat");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Razzak");

        Thread.sleep(3000);

        WebElement genderbox = driver.findElement(By.id("sex-1"));
        genderbox.click();

        WebElement yearExp = driver.findElement(By.id("exp-3"));
        if (yearExp.isDisplayed() && !yearExp.isSelected()) {
            yearExp.click();
        }

        WebElement datestart = driver.findElement(By.id("datepicker"));
        datestart.sendKeys("05/12/2023");

        WebElement profession = driver.findElement(By.id("profession-0"));
        if (profession.isDisplayed() && !profession.isSelected()) {
            profession.click();
        }

        WebElement tool = driver.findElement(By.id("tool-2"));
        if (tool.isDisplayed() && !tool.isSelected()) {
            tool.click();
        }

        WebElement continents = driver.findElement(By.id("continents"));
        continents.sendKeys("Africa");

        WebElement submitbutton = driver.findElement(By.id("submit"));
        submitbutton.click();

        Thread.sleep(5000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.techlistic.com/p/selenium-practice-form.html";
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("URL is Passed");
        } else {
            System.out.println("URL is Failed");
        }

        driver.close();

    }
}
