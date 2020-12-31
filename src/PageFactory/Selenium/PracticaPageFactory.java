package PageFactory.Selenium;

import PageFactory.PageCLass.PracticaLoginPageFactory;
import PageFactory.PageCLass.SearchPageFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PracticaPageFactory {
    WebDriver driver;
    String urlBase;
    PracticaLoginPageFactory loginPageFactory;

    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase="https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
        loginPageFactory = new PracticaLoginPageFactory(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(urlBase);
    }

    @Test
    public void test() throws Exception {
        loginPageFactory.textEmail("Test@Factory.com");
        loginPageFactory.textPassword("123456");
        loginPageFactory.clickLogin();
    }

    @After
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
