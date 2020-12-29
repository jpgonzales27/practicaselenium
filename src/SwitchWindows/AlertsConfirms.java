package SwitchWindows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertsConfirms {
    WebDriver driver;
    String urlBase;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(urlBase);
    }

    @Test
    public void test() throws InterruptedException {        ;
        driver.findElement(By.id("name")).sendKeys("Juan Pablo");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(5000);
    }

    @Test
    public void test2() throws InterruptedException {        ;
        driver.findElement(By.id("name")).sendKeys("Juan Pablo");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        //alert.accept();
        alert.dismiss();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}
