package PageFactory.Selenium;

import PageFactory.PageCLass.SearchPageFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageFactory {
    private WebDriver driver;
    private String baseUrl;
    SearchPageFactory searchPage;

    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com/";

        searchPage = new SearchPageFactory(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws Exception {
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("San Francisco");
        //searchPage.setDepartureDate("10/28/2015");
        //searchPage.setReturnDate("10/31/2015");
    }

    @After
    public void afterClass() {
    }
}
