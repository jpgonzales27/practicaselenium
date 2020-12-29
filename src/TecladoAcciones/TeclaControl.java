package TecladoAcciones;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TeclaControl {
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
        driver.get(urlBase);
        driver.findElement(By.id("openwindow")).sendKeys(Keys.COMMAND + "a");
        Thread.sleep(2000);
        //driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        //Thread.sleep(2000);
        //String selectAll = Keys.chord(Keys.COMMAND, "a");
        //driver.findElement(By.id("openwindow")).sendKeys(selectAll);
        //Thread.sleep(4000);

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
