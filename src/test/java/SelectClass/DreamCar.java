package SelectClass;

import Utils.BrowserUtils;
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
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void HeaderOfCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.cars.com/");

        /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button

9-Validate the header "New Lexus RX 350 for sale"

10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */

        WebElement newUsed = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsed, "new", "value");

        WebElement makes = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makes, "lexus", "value");

        WebElement models = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(models, "lexus-rx_350", "value");

        WebElement carDistance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(carDistance, "40", "value");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        zipcode.sendKeys("60056");

        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceOpt = new Select(price);
        String actualDefaultOptionPrice = BrowserUtils.getText(priceOpt.getFirstSelectedOption());
        String expectedPrice = "No max price";
        Assert.assertEquals(actualDefaultOptionPrice, expectedPrice);
        Thread.sleep(1000);

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        searchButton.click();
        Thread.sleep(2000);

        WebElement secondHeader = driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String secondText = BrowserUtils.getText(secondHeader);
        System.out.println(secondText);
        String expected = "New Lexus RX 350 for sale";
        Assert.assertEquals(secondText, expected);

        Thread.sleep(2000);
        WebElement sortingpage = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sortingpage, "list_price", "value");
        Thread.sleep(2000);

        //List <WebElement> rx350cars = driver.findElements(By.xpath(""));

        List<WebElement> LexusCars = driver.findElements(By.xpath("//h2[@class='title']"));

        for (WebElement title:LexusCars
             ) {
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(title));
        }

        Thread.sleep(2000);

        List<WebElement> pricesList = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List <Integer> priceClear = new ArrayList<>();
        List<Integer> expectPrice = new ArrayList<>();

        for (int i = 0; i<pricesList.size(); i++) {
            priceClear.add(Integer.parseInt(pricesList.get(i).getText().replace("$","").replace(",","")));
            expectPrice.add(Integer.parseInt(pricesList.get(i).getText().replace("$","").replace(",","")));

        }
        Collections.sort(expectPrice);
        Assert.assertEquals(priceClear,expectPrice);
        System.out.println(priceClear);
        System.out.println(expectPrice);
    }
}
