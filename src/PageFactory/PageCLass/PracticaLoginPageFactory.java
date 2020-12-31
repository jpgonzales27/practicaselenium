package PageFactory.PageCLass;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticaLoginPageFactory {

    WebDriver driver;

    //Relacionando los elemementos de la inferaz con FindBy
    @FindBy(id="user_email")
    WebElement email;

    @FindBy(id="user_password")
    WebElement password;

    @FindBy(name="commit")
    WebElement buttonLogin;

    //Contructor con instancia del driver
    public PracticaLoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void textEmail(String text) throws InterruptedException {
        email.clear();
        Thread.sleep(2000);
        email.sendKeys(text);
    }

    public void textPassword(String text) throws InterruptedException {
        password.clear();
        Thread.sleep(2000);
        password.sendKeys(text);
    }

    public void clickLogin(){
        buttonLogin.click();
    }

}
