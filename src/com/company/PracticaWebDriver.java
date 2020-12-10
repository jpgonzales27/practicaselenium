package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaWebDriver {

    public static void main(String[] args) {
        //open the chrome browser
        System.setProperty("webdriver.chrome.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String urlBase = "https://letskodeit.teachable.com/p/practice";
        driver.get(urlBase);
        driver.manage().window().maximize();
        driver.quit();

        //open the firefox browser
        //System.setProperty("webdriver.gecko.driver","C://Users//juamp//Documents//selenium jars drivers/drivers/geckodriver.exe");
        //WebDriver driverf = new FirefoxDriver();
    }
}
