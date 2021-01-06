package testNgPractica.reports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PracticaPOMLogin {
    WebDriver driver;
    ExtentTest test;

    public PracticaPOMLogin(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public void clickSignUpLink() {
        WebElement signupLink = driver.findElement(By.xpath("//a[contains(@href,'https://courses.letskodeit.com/login')]"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on signupLink link");
    }

    public void sendTextEmail(String email){
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
        test.log(LogStatus.INFO, "Enter email");
    }

    public void sendTextPassword(String password){
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        test.log(LogStatus.INFO, "Enter password");
    }

    public void clickButtonGo(){
        WebElement goButton = driver.findElement(By.xpath("//input[contains(@value,'Login')]"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked Go button");
    }

    public boolean findTextAllCourses() throws InterruptedException {
        Thread.sleep(3000);

        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.xpath("//h1[contains(text(),'All Courses')]"));
            if(welcomeText!=null) return true;
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;

    }


    public void login(String email, String password) {
        clickSignUpLink();
        sendTextEmail(email);
        sendTextPassword(password);
        clickButtonGo();
    }
}
