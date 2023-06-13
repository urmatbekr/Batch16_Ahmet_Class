package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectPractice1 {
    @Test
    public void SelectPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/urmatbekrazzakov/Desktop/Techtorial.html");

        WebElement optionBox = driver.findElement(By.xpath("//select[@name='country']"));

        Select choice = new Select(optionBox);

        String actualDefaultOption = choice.getFirstSelectedOption().getText().trim();
        String expected = "UNITED STATES";

        Assert.assertEquals(actualDefaultOption,expected);

        List <WebElement> allCountries = choice.getOptions();
        int count = 0;
        for (int i =0; i<allCountries.size(); i++) {
            count++;
            System.out.println(choice.getOptions().get(i).getText().trim());

        }

        System.out.println(count);
        choice.selectByIndex(112); // the Kyrgyz Republic
        Thread.sleep(1000);

        choice.selectByValue("207"); // Turkey
        Thread.sleep(1000);

        choice.selectByVisibleText("CANADA ");
        Thread.sleep(1000);

    }
}