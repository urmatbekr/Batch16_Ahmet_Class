package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumPracticeCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

/*
Navigate to "https://demoqa.com/text-box"
Enter your full name, email, current and permanent address
Click submit button.
Validate that all of your information is displayed and
matching correctly.
TIPS:Think about if conditions.
Example:
Name:John
Email: john@gmail.com
Current Address :Random Address
Permanent  Address : different address
 */
        driver.get("https://demoqa.com/text-box");
        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Urmat Razzak");

        WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("urmat@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("123 Main Str, Chicago, IL, 60111");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("321 Second Rd., Chicago, IL, 60222");

        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        WebElement nameDisplayed = driver.findElement(By.xpath("//p[@id='name']"));
        String textName = nameDisplayed.getText().trim();
        System.out.println(nameDisplayed.isDisplayed() && textName.contains("Urmat Razzak")? "Correct Name" : "NOT Correct Name");;

        WebElement emailDisplayed = driver.findElement(By.xpath("//p[@id='email']"));
        String textEmail = emailDisplayed.getText().trim();
        System.out.println(emailDisplayed.isDisplayed() && textEmail.contains("urmat@gmail.com")? "Correct Email" : "NOT Correct Email");;

        WebElement currentAddressDisplayed =driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String textCurrentAddress = currentAddressDisplayed.getText().trim();
        System.out.println(currentAddressDisplayed.isDisplayed() && textCurrentAddress.contains("123 Main Str, Chicago, IL, 60111")? "Correct current address" :" Not correct current address");

        WebElement permanentAddressDisplayed =driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String textpermanentAddress = permanentAddressDisplayed.getText().trim();
        System.out.println(permanentAddressDisplayed.isDisplayed() && textpermanentAddress.contains("321 Second Rd., Chicago, IL, 60222")? "Correct permanent address" :" Not correct permanent address");

        Thread.sleep(1000);
        driver.close();

    }
}
