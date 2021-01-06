package testNgPractica.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test1 {
    private WebDriver driver;
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        baseUrl = "http://www.letskodeit.com/";
        report = SreenshotsMultiplesTestCases.getInstance();
        test = report.startTest("Verify Welcome Text");
        driver = new ChromeDriver();
        test.log(LogStatus.INFO, "Browser Started...");

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application opened");
    }

    @Test
    public void test1_validLoginTest() throws Exception {

        WebElement signupLink = driver.findElement(By.xpath("//a[contains(@href,'https://courses.letskodeit.com/login')]"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on signupLink link");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("test@email.com");
        test.log(LogStatus.INFO, "Enter email");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("abcabc");
        test.log(LogStatus.INFO, "Enter password");
        WebElement goButton = driver.findElement(By.xpath("//input[contains(@value,'Login')]"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked Go button");
        Thread.sleep(3000);

        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.xpath("//h1[contains(text(),'All Courses')]"));
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
