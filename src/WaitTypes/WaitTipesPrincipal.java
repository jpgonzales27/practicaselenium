package WaitTypes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTipesPrincipal {
    WebDriver driver;
    String urlBase;
    WaitTipesGenericos wt;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com";
        wt = new WaitTipesGenericos(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("Executed Test...");
        driver.get(urlBase);
        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        WebElement element = wt.waitForElement(By.id("user_email"), 3);
        element.clear();
        element.sendKeys("Test");
        wt.clickWhenReady(By.name("commit"), 3);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
