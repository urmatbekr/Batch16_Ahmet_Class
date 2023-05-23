package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize(); // maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait time
        driver.get("https://www.youtube.com/"); // url

        WebElement nameSearch = driver.findElement(By.xpath("//input[@id='search']"));
        nameSearch.sendKeys("ed sheeran");
        nameSearch.sendKeys(Keys.ENTER);

        // WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        // searchButton.click();

        List<WebElement> songList = driver.findElements(By.xpath("//a[@id='video-title']")); // elements

        for (WebElement songs : songList) {
            Thread.sleep(2000);
            songs.sendKeys(Keys.ARROW_DOWN);
            if (songs.getAttribute("aria-label").contains("Thinking Out")) {
                songs.click();
                break;
            }

        }
    }
}
