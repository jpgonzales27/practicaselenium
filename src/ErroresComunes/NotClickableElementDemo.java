package ErroresComunes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NotClickableElementDemo {
    WebDriver driver;
    String urlBase;
    JavascriptExecutor js;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        urlBase = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {        ;
        driver.get("https://www.freecrm.com/index.html");
        driver.findElement(By.xpath("//a[contains(@class,'btn btn-primary')]")).click();
        driver.findElement(By.name("email")).sendKeys("testing");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui fluid large blue submit button']")));
        loginButton.click();
//        boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
//        if (invisible) {
//            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
//            loginButton.click();
//        }
       // WebElement loginButtonJS = driver.findElement(By.xpath("//input[@value='Login']"));
       // js.executeScript("arguments[0].click();", loginButtonJS);
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
