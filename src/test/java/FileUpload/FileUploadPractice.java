package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        ChromeDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement inputElement = driver.findElement(By.cssSelector("#file-upload"));
        inputElement.sendKeys("/Users/urmatbekrazzakov/Downloads/usa.png");
        Thread.sleep(1000);

        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();

        WebElement fileText = driver.findElement(By.cssSelector("#uploaded-files"));
        String expectedText = "usa.png";
        String actual = BrowserUtils.getText(fileText);

        Assert.assertEquals(actual,expectedText);
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile= driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("/Users/urmatbekrazzakov/Downloads/usa.png");
        WebElement firstText = driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        String firstGivenText= BrowserUtils.getText(firstText);
        String expectedGiven= "Select file to send(max 196.45 MB)";
        Assert.assertEquals(firstGivenText,expectedGiven);
        WebElement acceptClick = driver.findElement(By.cssSelector("#terms"));
        acceptClick.click();
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();
        Thread.sleep(500);
        WebElement successFile = driver.findElement(By.xpath("//div//h3"));
        String successText = BrowserUtils.getText(successFile);
        String expectedText = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(successText,expectedText);

    }
}
