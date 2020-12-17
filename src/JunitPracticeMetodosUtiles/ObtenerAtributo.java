package JunitPracticeMetodosUtiles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ObtenerAtributo {

    WebDriver driver;
    String urlBase;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Executed Test...");
        driver.get(urlBase);
        WebElement element = driver.findElement(By.id("name"));
        String text = element.getAttribute("name");
        System.out.println(text);
        String text2 = element.getAttribute("class");
        System.out.println(text2);
        String text3 = element.getAttribute("id");
        System.out.println(text3);
        String tex4 = element.getAttribute("placeholder");
        System.out.println(tex4);
        String text5 = element.getAttribute("type");
        System.out.println(text5);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
