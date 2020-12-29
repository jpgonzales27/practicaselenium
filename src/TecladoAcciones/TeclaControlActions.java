package TecladoAcciones;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TeclaControlActions {
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
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
