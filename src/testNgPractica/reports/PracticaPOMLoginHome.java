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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PracticaPOMLoginHome {
    private WebDriver driver;
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;
    PracticaPOMLogin pomLoginHome;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        baseUrl = "http://www.letskodeit.com/";
        report = SreenshotsMultiplesTestCases.getInstance();
        test = report.startTest("Verify Welcome Text");
        driver = new ChromeDriver();
        test.log(LogStatus.INFO, "Browser Started...");
        pomLoginHome = new PracticaPOMLogin(driver,test);
        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application opened");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        pomLoginHome.clickSignUpLink();
        pomLoginHome.sendTextEmail("test@email.com");
        pomLoginHome.sendTextPassword("abcabc");
        pomLoginHome.clickButtonGo();
        pomLoginHome.findTextAllCourses();
        boolean exist = pomLoginHome.findTextAllCourses();
        Assert.assertTrue(exist);
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
