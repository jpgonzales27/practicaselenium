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

public class SeleccionarBusqueda {
    WebDriver driver;
    String urlBase;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        urlBase = "http://www.goibibo.com/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("Executed Test...");
        driver.get(urlBase);
        String partialText = "Del";
        String textToSelect = "Delhi, India(DEL)";

        //Buscamos el input de busqueda
        WebElement textField = driver.findElement(By.id("gosuggest_inputSrc"));
        textField.sendKeys(partialText);

        //buscamos el id del elemento de la lista de busqueda que queremos seleccionar
        WebElement ulElement = driver.findElement(By.id("react-autosuggest-1"));

        //mostamos el codigo html de los elementos encontrados mayoria de los casos seran li
        String innerHTML = ulElement.getAttribute("innerHTML");
        System.out.println(innerHTML);

        //Creamos una lista de webelements con todos los elemetnos de la lista
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        Thread.sleep(3000);

        //Recorremos la lista buscando el elemento previmente elegido en nuestro texto
        for (WebElement element : liElements) {
            System.out.println(element.getText());
            if (element.getText().contains(textToSelect)) {
                System.out.println("Selected: " + element.getText());
                element.click();
                break;
            }
        }

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
