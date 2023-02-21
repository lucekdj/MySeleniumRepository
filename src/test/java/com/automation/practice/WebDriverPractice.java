package com.automation.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverPractice {

    WebDriver driver;

    public void creteDriver(String urlDriver){
        System.setProperty("webdriver.chrome.driver" , "src/test/java/driver/chromedriver.exe ");

        driver = new ChromeDriver();
        driver.get(urlDriver);
        driver.manage().window().maximize();
    }

    public void quitDriver(){
        driver.close();
        driver.quit();
    }


    public WebDriver getDriver(){
        return driver;
    }



}

