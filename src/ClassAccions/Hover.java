package ClassAccions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Hover {
    WebDriver driver;
    String urlBase;
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com/p/practice";
        js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(urlBase);
    }

    @Test
    public void test() throws InterruptedException {        ;
        js.executeScript("window.scrollBy(0, 800)");
        Thread.sleep(2000);

        WebElement mainElement = driver.findElement(By.id("mousehover"));

        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        Thread.sleep(2000);

        WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
        action.moveToElement(subElement).click().perform();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}
