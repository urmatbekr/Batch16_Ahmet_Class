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
import java.util.Arrays;
import java.util.List;

public class SelecPractice2MidLevel {
    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        /*
1-Navigate to the website- done
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"

5-Choose the depart from is Paris

6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */
        WebElement typeTrip = driver.findElement(By.xpath("//input[@value='oneway']"));
        typeTrip.click();

        WebElement optionBox = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passNumber = new Select(optionBox);
        passNumber.selectByValue("4");

        WebElement depFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depFromOpt = new Select(depFrom);
        String actualDefaultOption = depFromOpt.getFirstSelectedOption().getText().trim();
        String expected = "Acapulco";
        Assert.assertEquals(actualDefaultOption, expected);
        Thread.sleep(1000);
        depFromOpt.selectByVisibleText("Paris");

        WebElement depMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select depMonthOpt = new Select(depMonth);
        depMonthOpt.selectByValue("8");
        Thread.sleep(1000);

        WebElement fromby = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select frombyOpt = new Select(fromby);
        frombyOpt.selectByVisibleText("15");

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select fromMonthOpt = new Select(fromMonth);
        depMonthOpt.selectByValue("12");
        Thread.sleep(1000);

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDayOpt = new Select(toDay);
        frombyOpt.selectByVisibleText("15");

        Thread.sleep(1000);
        WebElement classLevel = driver.findElement(By.xpath("//input[@value='First']"));
        classLevel.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlinesOpt = new Select(airlines);

        List<WebElement> actualOptions = airlinesOpt.getOptions();
        List<String> expectedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < actualOptions.size(); i++) {
            Assert.assertEquals(actualOptions.get(i).getText().trim(), expectedOptions.get(i).trim());
        }
        Thread.sleep(1000);

        airlinesOpt.selectByVisibleText("Unified Airlines");

        WebElement clickCont = driver.findElement(By.xpath("//input[@name='findFlights']"));
        clickCont.click();
        Thread.sleep(1000);

        WebElement afterFlightText = driver.findElement(By.xpath("//font[@size='4']"));
        String actualTextAvailable = afterFlightText.getText().trim();
        System.out.println(actualTextAvailable);
        String expectedTextFlight = "After flight finder - No Seats Available";
        Assert.assertEquals(actualTextAvailable, expectedTextFlight);

    }

    @Test
    public void validateOrderMessageShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement typeTrip = driver.findElement(By.xpath("//input[@value='oneway']"));
        typeTrip.click();

        WebElement optionBox = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(optionBox, "4", "value");

        WebElement depFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depFromOpt = new Select(depFrom);
        String actualDefaultOption = depFromOpt.getFirstSelectedOption().getText().trim();
        String expected = "Acapulco";
        Assert.assertEquals(actualDefaultOption, expected);
        Thread.sleep(1000);
        BrowserUtils.selectBy(depFrom, "Paris", "text");

        WebElement depMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(depMonth, "8", "value");
        Thread.sleep(1000);

        WebElement fromby = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(fromby, "15", "text");

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(fromMonth, "12", "value");
        Thread.sleep(1000);

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(toDay, "15", "text");

        Thread.sleep(1000);
        WebElement classLevel = driver.findElement(By.xpath("//input[@value='First']"));
        classLevel.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlinesOpt = new Select(airlines);

        List<WebElement> actualOptions = airlinesOpt.getOptions();
        List<String> expectedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < actualOptions.size(); i++) {
            Assert.assertEquals(actualOptions.get(i).getText().trim(), expectedOptions.get(i).trim());
        }
        Thread.sleep(1000);
        airlinesOpt.selectByVisibleText("Unified Airlines");

        WebElement clickCont = driver.findElement(By.xpath("//input[@name='findFlights']"));
        clickCont.click();
        Thread.sleep(1000);

        WebElement afterFlightText = driver.findElement(By.xpath("//font[@size='4']"));
        String actualTextAvailable = afterFlightText.getText().trim();
        System.out.println(actualTextAvailable);
        String expectedTextFlight = "After flight finder - No Seats Available";
        Assert.assertEquals(actualTextAvailable, expectedTextFlight);

    }
}
