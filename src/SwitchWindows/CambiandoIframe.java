package SwitchWindows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class CambiandoIframe {
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
        // Switch to frame by Id
        driver.switchTo().frame("courses-iframe");
        // Switch to frame by name
        //driver.switchTo().frame("iframe-name");
        // Switch to frame by numbers
        //driver.switchTo().frame(0);
        driver.findElement(By.id("search-courses")).sendKeys("Linux");
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("name")).sendKeys("Holaaaa..");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}
