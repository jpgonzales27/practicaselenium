package JunitPractice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PracticaJunitDisableElements {

    WebDriver driver;
    String urlBase = "https://letskodeit.teachable.com";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        System.out.println("Executed Test...");
        driver.get(urlBase);

        WebElement e1 = driver.findElement(By.id("gs_htif0"));
        System.out.println("E1 is Enabled? " + e1.isEnabled());

        WebElement e2 = driver.findElement(By.id("gs_taif0"));
        System.out.println("E2 is Enabled? " + e2.isEnabled());

        WebElement e3 = driver.findElement(By.id("lst-ib"));
        System.out.println("E3 is Enabled? " + e3.isEnabled());
        e3.sendKeys("letskodeit");

        WebElement e4 = driver.findElement(By.name("q"));
        e4.sendKeys("Juan Pablo");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
