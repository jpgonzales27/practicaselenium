package UploadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class FileUploadAutoIt {
    private WebDriver driver;
    private String baseUrl;
    private JavascriptExecutor js;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        baseUrl = "https://mega.nz/start";
        //System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void fileUpload() throws AWTException, InterruptedException, IOException {
        driver.findElement(By.cssSelector("a.default-white-button.top-login-button")).click();
        driver.findElement(By.id("login-name")).sendKeys("juampi7237@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("jpga270391");
        driver.findElement(By.cssSelector("div.top-dialog-login-button.big-red-button.height-32")).click();
        Thread.sleep(10000);
//        WebElement element = driver.findElement(By.cssSelector("a.dropdown-item.fileupload-item"));
        WebElement element = driver.findElement(By.id("fileselect1"));
        js.executeScript("arguments[0].click();",element);

        Runtime.getRuntime().exec("C:\\Users\\juamp\\Documents\\selenium\\01-selenium\\scripts\\fileUpload.exe");


    }

    @AfterClass
    public void afterClass() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
    }
}
