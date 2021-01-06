package DataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Constantes;
import utilities.ExcelUtility;
import utilities.ExcelUtility_SingleDataSet;

import java.util.concurrent.TimeUnit;

public class Ejemplo3 {
    private WebDriver driver;


    @BeforeClass
    public void setUp() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/geckodriver.exe");
        driver = new FirefoxDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constantes.URL);
        //driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        //driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
        Thread.sleep(5000);
        // Tell the code about the location of Excel file
        ExcelUtility_SingleDataSet.setExcelFile(
                Constantes.File_Path + Constantes.File_Name, "Sheet1");
    }

    @Test
    public void testUsingExcel() throws Exception {
        String username = ExcelUtility_SingleDataSet.getCellData(1, 0);
        String password = ExcelUtility_SingleDataSet.getCellData(1, 1);
        //click en sign in
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        // Enter username
        driver.findElement(By.id("email")).sendKeys(username);
        // Enter password
        driver.findElement(By.id("password")).sendKeys(password);
        // Click Login button
        driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
        Thread.sleep(2000);

        // Find if error messages exist
        //PRIMER FORMA PARA ENCONTAR UN ELEMENTO DE ERROR
        System.out.println("PRIMER FORMA PARA ENCONTAR UN ELEMENTO DE ERROR");
       String mensajeActual;
       String mensajeErrorEsperado = "Your username or password is invalid. Please try again.";
       mensajeActual = driver.findElement(By.cssSelector("span.dynamic-text.help-block")).getText();
//       mensajeActual = driver.findElement(By.xpath("//span[contains(text(),'Your username or password is invalid. Please try again')]")).getText();
       Assert.assertEquals(mensajeActual,mensajeErrorEsperado);
        // Set the test result in the Excel file
       ExcelUtility_SingleDataSet.setCellData("Pass", 1, 2);
       System.out.println("Test Passed");


        //SEGUNDA FORMA PARA ENCONTAR UN ELEMENTO DE ERROR
//        System.out.println("SEGUNDA FORMA PARA ENCONTAR UN ELEMENTO DE ERROR");
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.dynamic-text.help-block")));
//        System.out.println("Elemento :"+element.getText());
//        boolean result = element.isEnabled();
//        Assert.assertTrue(result);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
