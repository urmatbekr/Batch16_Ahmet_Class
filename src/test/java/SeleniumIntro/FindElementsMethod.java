package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class FindElementsMethod {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize(); // maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait time
        driver.get("file:///Users/urmatbekrazzakov/Desktop/Techtorial.html"); // url

        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); // 4 elements

        for (WebElement box: allBoxes) {
            if (box.isDisplayed() && box.isEnabled() && !box.isSelected() ){
                Thread.sleep(3000);
                box.click();
                System.out.println("selected");
            }

        }






    }
}
