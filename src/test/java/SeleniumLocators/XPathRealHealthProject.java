package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        /*THESE PARTS SHOULD BE DONE BY XPATH:
        1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->
        2-Click Make an Appointment
        3-Login the username and password provided and Login successfully
        4-Choose the facility either HongKong or Seoul -->send keys

        5-Click apply for hospital admission box if it is displayed and validate it is selected
        6-Healthcare program 'Medicaid'
        7-Visit date should be provided -->send keys
        8-Put your comment for this box -->send keys
        9-Book your appointment

        THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
        10-Validate the header is "Appointment confirmation" (if statement)
        11-Print out the headers and values(only values) on your console.
        12)Click go to homepage and print out url
        13)Driver.quit or close.

                */

        driver.get("https://katalon-demo-cura.herokuapp.com");
        WebElement appoint = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        appoint.click();

//        WebElement expname = driver.findElement(By.xpath("//input[@value='John Doe']"));
//        String textname = expname.getText();
//
//        WebElement exppass = driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']"));
//        String textapss = expname.getText();

        WebElement login = driver.findElement(By.xpath("//input[@id='txt-username']"));
        login.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement submit = driver.findElement(By.xpath("//button[@id='btn-login']"));
        submit.click();

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        WebElement readmission = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (readmission.isDisplayed() && !readmission.isSelected()) {
            readmission.click();
        }

        WebElement medcare = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medcare.click();

        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("21/04/2023");

        WebElement commenets = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        commenets.sendKeys("My appoint date is next week");

        WebElement bookapp = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookapp.click();

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        String actualheader = header.getText().trim();
        String expectedTitle = "Appointment Confirmation";

        if (actualheader.equals(expectedTitle)){
            System.out.println("Passed - ");
            System.out.println(actualheader);
        } else {
            System.out.println("Failed - ");
        }

        WebElement facilities = driver.findElement(By.xpath("//p[contains(text(),'Hongkong')]"));
        System.out.println(facilities.getText());

        WebElement yesans = driver.findElement(By.xpath("//p[contains(text(),'Yes')]"));
        System.out.println(yesans.getText());

        WebElement Medicaid = driver.findElement(By.xpath("//p[contains(text(),'Medicaid')]"));
        System.out.println(Medicaid.getText());

        WebElement dateshow = driver.findElement(By.xpath("//p[contains(text(),'21/04/2023')]"));
        System.out.println(dateshow.getText());

        WebElement comm = driver.findElement(By.xpath("//p[contains(text(),'appoint date')]"));
        System.out.println(comm.getText());

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com");
        String actualUrl= driver.getCurrentUrl();
        System.out.println(actualUrl);

        Thread.sleep(2000);
        driver.close();

    }

}
