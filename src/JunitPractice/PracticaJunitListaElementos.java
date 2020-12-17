package JunitPractice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticaJunitListaElementos {


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
        boolean isChecked = false;
        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio' and @name='cars']"));
        for (int i = 0; i < elements.size() ; i++) {
            isChecked = elements.get(i).isSelected();
            if(!isChecked) {
                elements.get(i).click();
                Thread.sleep(2000);
            }
        }
    }

    @After
    public void tearDown()throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        }

    }


