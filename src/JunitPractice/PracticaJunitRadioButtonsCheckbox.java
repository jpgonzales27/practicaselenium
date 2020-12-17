package JunitPractice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PracticaJunitRadioButtonsCheckbox {

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
    public void test1() throws InterruptedException {
        System.out.println("Executed Test...");
        driver.get(urlBase);
        driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Practice')]")).click();
        WebElement bwmradio = driver.findElement(By.id("bmwradio"));
        bwmradio.click();
        WebElement benzradio = driver.findElement(By.id("benzradio"));
        benzradio.click();
        Thread.sleep(2000);
        WebElement bmwcheck = driver.findElement(By.id("bmwcheck"));
        bmwcheck.click();
        WebElement benzcheck = driver.findElement(By.id("benzcheck"));
        benzcheck.click();

        System.out.println("Bmw Radio is selected? "+bwmradio.isSelected());
        System.out.println("Benz Radio is selected? "+benzradio.isSelected());
        System.out.println("Bmw Checkbox is selected? "+bmwcheck.isSelected());
        System.out.println("Benz Checkbox is selected? "+benzcheck.isSelected());


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
