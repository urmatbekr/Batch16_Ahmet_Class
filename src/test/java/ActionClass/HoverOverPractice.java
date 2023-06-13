package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoverOverPractice {
    @Test
    public void hoverPractice1() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");


        Actions actions = new Actions(driver);
        actions.scrollByAmount(400, 400).perform();
        List<WebElement> imgFood = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));

        List<WebElement> names = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='product-description']//p"));

        Map<String, String> allNamesPrice = new HashMap<>();
        Thread.sleep(1000);

        for (int i = 0; i < names.size(); i++) {
            actions.moveToElement(imgFood.get(i)).perform();
            Thread.sleep(100);
            allNamesPrice.put(BrowserUtils.getText(names.get(i)), BrowserUtils.getText(prices.get(i)));
        }

        System.out.println(allNamesPrice);

    }
}
