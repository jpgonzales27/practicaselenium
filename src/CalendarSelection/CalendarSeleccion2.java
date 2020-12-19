package CalendarSelection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarSeleccion2 {
    WebDriver driver;
    String urlBase;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "https://www.expedia.com/";
        //Espera implicita nosotros le decimos a seleemiun que espere 10 segungos para buscar los elementos
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("Executed Test...");
        driver.get(urlBase);
        WebElement element = driver.findElement(By.id("d1-btn"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver,3);
        WebElement selectDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='uitk-calendar']//div[@class='uitk-new-date-picker-menu-months-container']/div[1]/table")));

        List<WebElement> allValidDates = selectDate.findElements(By.tagName("button"));

        Thread.sleep(3000);


        for (WebElement allValidDate : allValidDates) {
            System.out.println(allValidDate);
        }

        for (WebElement date : allValidDates) {
            String dia = date.getAttribute("data-day");
            System.out.println(dia);
            if (dia.equals("31")) {
                date.click();
                break;
            }
        }

        WebElement doneButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='uitk-flex uitk-new-date-picker-menu-footer']/button/span")));
        doneButton.click();

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
