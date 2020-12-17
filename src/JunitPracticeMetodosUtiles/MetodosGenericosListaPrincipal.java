package JunitPracticeMetodosUtiles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MetodosGenericosListaPrincipal {
    WebDriver driver;
    String urlBase;
    MetodosGenericosListaElementos metodosGenericosListaElementos;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://letskodeit.teachable.com/p/practice";
        metodosGenericosListaElementos = new MetodosGenericosListaElementos(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Executed Test...");
        driver.get(urlBase);
        List<WebElement> element = metodosGenericosListaElementos.getElementList("//input[contains(@class,'inputs')]","xpath");
        System.out.println("Size ="+element.size());
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("Executed Test...");
        driver.get(urlBase);
        boolean result1 = metodosGenericosListaElementos.isElementPresent("name", "id");
        System.out.println("Is Element Present: " + result1);
        boolean result2 = metodosGenericosListaElementos.isElementPresent("name-not-present", "id");
        System.out.println("Is Element Present: " + result2);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
