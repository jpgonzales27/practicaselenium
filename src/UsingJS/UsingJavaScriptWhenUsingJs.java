package UsingJS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UsingJavaScriptWhenUsingJs {
    WebDriver driver;
    String urlBase;
    private JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com/p/practice";
        js = (JavascriptExecutor) driver;
        //Espera implicita nosotros le decimos a seleemiun que espere 10 segungos para buscar los elementos
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://www.retailmenot.com/");
        driver.findElement(By.xpath("//div[text()='Log In / Sign up']")).click();
        Thread.sleep(3000);

        WebElement checkBoxElement = driver.findElement(By.id("subscribe"));
        System.out.println("Displayed: " + checkBoxElement.isDisplayed());
        System.out.println("Selected: " + checkBoxElement.isSelected());

        //checkBoxElement.click();
        js.executeScript("arguments[0].click();", checkBoxElement);


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
