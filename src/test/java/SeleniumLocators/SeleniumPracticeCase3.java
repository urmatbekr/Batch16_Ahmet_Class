package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumPracticeCase3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        /*
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Validate current url is
"https://www.saucedemo.com/inventory.html"
         */

        driver.get("https://www.saucedemo.com");

        WebElement username = driver.findElement(By.xpath("//input[@id = 'user-name']"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id = 'login-button']"));
        loginButton.click();

        Thread.sleep(3000);

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL is Passed");
        } else {
            System.out.println("URL is Failed");
        }
        driver.close();

    }
}
