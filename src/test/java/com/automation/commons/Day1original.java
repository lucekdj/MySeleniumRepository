package com.automation.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day1original {


    static WebDriver driver;
    public static void createDriver(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.get("http://18.116.88.132:8080/bank/login");

    }
    public static WebDriver getDriver(){
        return driver;
    }
}
