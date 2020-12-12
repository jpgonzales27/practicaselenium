package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PracticaWebDriver {

    public static void main(String[] args) throws InterruptedException {
        //open the chrome browser
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String urlBase = "https://letskodeit.teachable.com";
        driver.get(urlBase);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        //driver.findElement(By.id("user_email")).sendKeys("letskodeit@gmail.com");
        driver.findElement(By.partialLinkText("Pract")).click();
        driver.findElement(By.name("enter-name")).sendKeys("Juan Pablo");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("user_email")).sendKeys("juampi@gmail.com");
        //driver.quit();

        //open the firefox browser
        //System.setProperty("webdriver.gecko.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/geckodriver.exe");
        //WebDriver driverf = new FirefoxDriver();
    }
}
