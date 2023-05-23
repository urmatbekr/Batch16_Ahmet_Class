package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize(); // maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait time
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html"); // url

        WebElement collaps = driver.findElement(By.xpath("//button"));
        collaps.click();

        List<WebElement> boxList = driver.findElements(By.tagName("//div[@role='checkbox']"));

        for (WebElement boxes: boxList) {
            if (boxes.getAttribute("aria-checked").equals("false")) {
                boxes.click();
            }
        }

    }
}
