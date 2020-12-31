package PageObjectModel.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticaClass {
    public static WebElement element = null;

    //Encontramos el elemento email
    private static WebElement fieldEmail (WebDriver driver){
        element = driver.findElement(By.id("user_email"));
        return element;
    }

    //llenando el campo email
    public static void textEmail(WebDriver driver,String text) throws InterruptedException {
        element = fieldEmail(driver);
        element.clear();
        Thread.sleep(2000);
        element.sendKeys(text);
    }

    //Encontramos el elemento password
    private static WebElement fieldPassword (WebDriver driver){
        element = driver.findElement(By.id("user_password"));
        return element;
    }

    //llenanoo el campo password
    public static void textPassword(WebDriver driver , String text) throws InterruptedException {
        element = fieldPassword(driver);
        element.clear();
        Thread.sleep(2000);
        element.sendKeys(text);
    }

    //Encontramos el boton de login
    private static WebElement buttonLogin (WebDriver driver){
        element = driver.findElement(By.name("commit"));
        return element;
    }

    //Haciendo Click en el boton login
    public static void clickLogin(WebDriver driver){
        element = buttonLogin(driver);
        element.click();
    }
}
