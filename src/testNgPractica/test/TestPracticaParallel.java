package testNgPractica.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestPracticaParallel {
    WebDriver driver;
    String urlBase;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser){
        urlBase = "https://letskodeit.teachable.com/";
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(urlBase);
        driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement emailFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password")));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("commit")));
        emailFiled.clear();
        passwordField.clear();
        Thread.sleep(3000);
        emailFiled.sendKeys("pruebaTestNg@gmail.com");
        passwordField.sendKeys("123123");
        loginButton.click();

    }

    @AfterClass
    public void cleanup() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
