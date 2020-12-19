package UsingJS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UsingJavascript {
    WebDriver driver;
    String urlBase;
    private JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com/p/practice";
        js = (JavascriptExecutor) driver;
        //Espera implicita nosotros le decimos a seleemiun que espere 10 segungos para buscar los elementos
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test3() throws InterruptedException {
        // Navigation
        // driver.get(baseUrl);
        js.executeScript("window.location = 'https://letskodeit.teachable.com/p/practice';");

        // driver.get() method waits for the page to load completely before going to the next statement
        // Adding Thread.sleep() because we are opening URL using js.executeScript() and it does not wait for the page to load completely
        // If we do not add wait, then Selenium WebDriver will immediately try to find the element and it might have issues with just a little slow connection
        Thread.sleep(3000);
        // Finding element
        // WebElement textBox = driver.findElement(By.id("name"));
        WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');");
        textBox.sendKeys("test");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
