package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DayOne  {

//    to bylo w day 1 now is in driver utils
    private static WebDriver driver;
    public  void createDriver(String url) {
        System.setProperty("webdriver.chrome.driver" , "src/test/java/driver/chromedriver.exe ");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }
    public void quitDriver(){
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
