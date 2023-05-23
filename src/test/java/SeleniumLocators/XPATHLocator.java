package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

            //  Relative XPATH
        driver.get("https://the-internet.herokuapp.com/abtest");
      //  WebElement abtesting = driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
       // abtesting.click();
            // Absolute XPATH
        WebElement header = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3\n"));
        System.out.println(header.getText());

        WebElement para = driver.findElement(By.xpath("/html/body/div[2]/div/div/p\n"));
        System.out.println(para.getText());

        WebElement linkE = driver.findElement(By.xpath("//a[contains(text(),'Elemental')]"));
        linkE.click();


    }

}
