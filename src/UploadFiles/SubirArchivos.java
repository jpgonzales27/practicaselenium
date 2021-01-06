package UploadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SubirArchivos {


    private WebDriver driver;
    private String baseUrl;


    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        baseUrl = "https://the-internet.herokuapp.com/upload";
        //System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void fileUpload() {
        File file = new File("C:\\Users\\juamp\\Desktop\\texto.txt");
        String path = file.getAbsolutePath();
        String expectedResult = "File Uploaded!";
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        String result = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).getText();
        Assert.assertEquals(result,expectedResult);
        System.out.println("Test Passed");

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
