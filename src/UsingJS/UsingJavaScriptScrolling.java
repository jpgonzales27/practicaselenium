package UsingJS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UsingJavaScriptScrolling {
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
        Thread.sleep(3000);

        // Scroll Down
        js.executeScript("window.scrollBy(0, 1900);");
        Thread.sleep(2000);

        // Scroll Up
        js.executeScript("window.scrollBy(0, -1900);");
        Thread.sleep(2000);

        // Scroll Element Into View
        WebElement element = driver.findElement(By.id("mousehover"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -190);");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
