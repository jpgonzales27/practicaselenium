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

public class SubirArchivosRobot {


    private WebDriver driver;
    private String baseUrl;
    private JavascriptExecutor js;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        baseUrl = "https://the-internet.herokuapp.com/upload";
        //System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void fileUpload() throws AWTException, InterruptedException {
        String expectedResult = "File Uploaded!";
        StringSelection ss = new StringSelection("C://Users//juamp//Desktop//texto.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        WebElement element = driver.findElement(By.id("file-upload"));
        js.executeScript("arguments[0].click();",element);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

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
