package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload extends DayOne{
    @Test
    public void learnFileUpload() throws InterruptedException {
        WebDriver driver = getDriver();

        WebElement fileUploadInput = getDriver().findElement(By.cssSelector("#uploadFile"));

    fileUploadInput.sendKeys("c:/Users/lucek/Desktop/TestFile.txt");
    //"C:\Users\lucek\Desktop\TestFile.txt"
    Thread.sleep(5000);

    }


    @Before
    public void setup(){
        createDriver("https://demoqa.com/upload-download");
    }


    @After
    public void cleanUp(){
        quitDriver();
    }

}
