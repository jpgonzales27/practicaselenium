package JunitPractice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PracticaJunitBasico {

    WebDriver driver;
    String urlBase = "https://letskodeit.teachable.com";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        System.out.println("Executed Test...");
        driver.get(urlBase);
        //driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("test");
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }


}
