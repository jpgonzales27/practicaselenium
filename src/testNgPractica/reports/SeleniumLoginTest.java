package testNgPractica.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumLoginTest {
    private WebDriver driver;
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");

        baseUrl = "http://www.letskodeit.com/";
        report = new ExtentReports("C://Users//juamp//Desktop//logintest.html");
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
//        WebDriverWait wait = new WebDriverWait(driver, 7);
//        WebElement javaCourseExit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='comp-jgmoxws4']/*[1]")));
//        javaCourseExit.click();

        WebElement signupLink = driver.findElement(By.xpath("//a[contains(@href,'https://courses.letskodeit.com/login')]"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on signupLink link");
        //WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        //loginLink.click();

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("test@email.com");
        test.log(LogStatus.INFO, "Enter email");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("abcabc");
        test.log(LogStatus.INFO, "Enter password");
        WebElement goButton = driver.findElement(By.xpath("//div[contains(@value,'Login')]"));
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

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = Screenshots.takeScreenshot(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
        }
        driver.quit();
        report.endTest(test);
        report.flush();
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
