package com.automation.commons;

import com.automation.utils.DriverUtils;
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



public class BrowserSynchronization extends DriverUtils {

   // implicitly - explicitly

    @Test
    public void learnWaits() throws InterruptedException {
        WebDriver driver = getDriver();
        //Creating an object of WebDriverWait class and passing the driver (to access current driver session) and
        //the duration of seconds we want to wait for the expected condition to be true
        WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(30));

        //We can find this element by:
        //xpath //button[@id='startStopButton']
        //Id startStopButton
        //Css #startStopButton

        // WebElement startButton = driver.findElement(By.id("startStopButton"));
        //WebElement startButton = driver.findElement(By.cssSelector("//button[@id='startStopButton']"));
        WebElement startButton = driver.findElement(By.xpath("//button[@id='startStopButton']"));

        //Using our driverWait variable to call until method to wait for textToBePresentInElement() condition to return true
        //Note: if the condition is true before the time is up it will not wait for the full time

        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar div.progress-bar"));

         startButton.click();
         String expectedValue = "100";
        //explicitly
         driverWait.until(ExpectedConditions.textToBePresentInElement(progressBar,"100%"));

        //Assert.assertTrue("value does not expected", progressBar.getText().contains("100%"));
        Assert.assertTrue("Value does not match expected" + expectedValue, progressBar.getText().contains(expectedValue));

       //Thread.sleep(5000);

        System.out.println("from sout print" + progressBar.getText());
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
