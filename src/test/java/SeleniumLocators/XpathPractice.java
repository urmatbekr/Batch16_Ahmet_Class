package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstname = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstname.sendKeys("Urmat");

        WebElement lastname = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastname.sendKeys("Razzak");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("razzak1211@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("3212231231");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("12345");

        WebElement passwordconfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordconfirm.sendKeys("12345");

        WebElement agreeclick = driver.findElement(By.xpath("//input[@name='agree']"));
        agreeclick.click();

        WebElement cont =driver.findElement(By.xpath("//input[@value='Continue']"));
        cont.click();

        WebElement header2 = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been')]"));
        String actualheader = header2.getText().trim();
        String expectedTitle = "Your Account Has Been Created!";

        if (actualheader.equals(expectedTitle)){
            System.out.println("Passed - ");
        } else {
            System.out.println("Failed - ");
        }

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/success";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL is Passed");
        } else {
            System.out.println("URL is Failed");
        }
        driver.quit();




















    }
}
