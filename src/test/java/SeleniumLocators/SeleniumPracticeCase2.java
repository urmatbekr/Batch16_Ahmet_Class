package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumPracticeCase2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        /*
Navigate to "https://www.saucedemo.com/"
Enter username "Java"
Enter password "Selenium"
Click Login button
Validate "Epic sadface: Username and password do not
match any user in this service" message
TIPS:to be able to see this message you need to first see this
message then try to inspect it. (it means at least run one time
with the username and password you provided above to see
the message then inspect the message.
*be careful with it is fully copied or not.
         */

        driver.get("https://www.saucedemo.com");
        WebElement username = driver.findElement(By.xpath("//input[@id = 'user-name']"));
        username.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id = 'login-button']"));
        loginButton.click();

        Thread.sleep(3000);

        WebElement errorText = driver.findElement(By.tagName("h3"));
        String text = errorText.getText().trim();
        System.out.println(text.equals("Epic sadface: Username and password do not match any user in this service")?
                "correct" : "NOT CORRECT" );
        driver.close();
    }
}
