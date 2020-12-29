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

public class KeyPress {
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
        driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
        WebElement email = driver.findElement(By.id("user_email"));
        WebElement password = driver.findElement(By.id("user_password"));
        WebElement commit = driver.findElement(By.name("commit"));
        email.clear();
        //password.clear();
        email.sendKeys("test@test.com");
        Thread.sleep(4000);
        email.sendKeys(Keys.TAB);
        //password.sendKeys("123123");
        //commit.sendKeys(Keys.ENTER);



    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
