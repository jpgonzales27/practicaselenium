package SwitchWindows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CambiandoVentana {
    WebDriver driver;
    String urlBase;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(urlBase);
    }

    @Test
    public void test() throws InterruptedException {
        // Get the handle
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Handle: " + parentHandle);
        // Find Open Window button
        driver.findElement(By.id("openwindow")).click();

        // Get all handles
        Set<String> handles = driver.getWindowHandles();
        // Switching between handles
        for (String handle: handles) {
            System.out.println(handle);
            if(!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                driver.findElement(By.id("search-courses")).sendKeys("linux");
                Thread.sleep(2000);
                driver.close();
            }
        }

        driver.switchTo().window(parentHandle);
        driver.findElement(By.id("name")).sendKeys("Hola de nuevo");
        Thread.sleep(2000);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
