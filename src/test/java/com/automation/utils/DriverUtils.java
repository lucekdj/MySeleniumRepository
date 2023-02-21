package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtils {


    private static WebDriver driver;

    public  void createDriver(String url) {
        System.setProperty("webdriver.chrome.driver" , "src/test/java/driver/chromedriver.exe ");

        driver = new ChromeDriver();
        driver.get(url);

        //Sets up an implicit wait that waits the Duration.ofSeconds() for every element while checking every 500
        //mili seconds before throwing NoSuchElementFoundException
        //Note: if the element exists before the time is up it will not wait for the full time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // this method will maximize the window of the current driver session
        driver.manage().window().maximize();

        //driver.get("http://18.116.88.132:8080/bank/login");  // it was orgin

    }
    public void quitDriver(){
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
