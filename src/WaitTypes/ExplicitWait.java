package WaitTypes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    WebDriver driver;
    String urlBase;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com";
        driver.manage().window().maximize();
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("Executed Test...");
        driver.get(urlBase);
        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        element.clear();
        element.sendKeys("Test");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
