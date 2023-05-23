package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class GetAttributePractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize(); // maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait time

        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html"); // url

        List<WebElement> listLink = driver.findElements(By.tagName("li"));
        int i = 0;
        for (WebElement list: listLink) {

            if (list.getText().length() >= 12) {
                i++;
                System.out.println(i + ") " + list.getText());}

        }

    }
}
