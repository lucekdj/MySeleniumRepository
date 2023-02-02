package com.automation.commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class BrowserSynchronization extends DayOne{



    @Test
    public void learnWaits() throws InterruptedException {
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(100));

        //We can find this element by:
        //xpath //button[@id='startStopButton']
        //Id startStopButton
        //Css #startStopButton

        // WebElement startButton = driver.findElement(By.id("startStopButton"));
        //WebElement startButton = driver.findElement(By.cssSelector("//button[@id='startStopButton']"));
        WebElement startButton = driver.findElement(By.xpath("//button[@id='startStopButton']"));

        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar div.progress-bar"));

         startButton.click();
         String expectedValue = "100";

         driverWait.until(ExpectedConditions.textToBePresentInElement(progressBar,"100%"));

        //Assert.assertTrue("value does not expected", progressBar.getText().contains("100%"));
        Assert.assertTrue("Value does not match expected" + expectedValue, progressBar.getText().contains(expectedValue));

       //Thread.sleep(5000);

        System.out.println(progressBar.getText());
    }


    @Before
    public void setup(){
        createDriver("https://demoqa.com/progress-bar");
    }


    @After
    public void cleanUp(){
        quitDriver();
    }
}
