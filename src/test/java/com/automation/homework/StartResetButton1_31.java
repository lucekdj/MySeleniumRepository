package com.automation.homework;

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

public class StartResetButton1_31 extends DriverUtils {


     @Test
     public void startResetBtn() throws InterruptedException {

         WebDriver driver = getDriver();
         WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(30));

         WebElement startButton = driver.findElement(By.xpath("//button[@title='Start timer']"));
         WebElement resetButton = driver.findElement(By.xpath("//button[@title='Reset and start over']"));
         WebElement timer = driver.findElement(By.xpath("//span[@class='timeLeft']"));

         startButton.click();
         driver.manage().window().fullscreen();
         waitDriver.until(ExpectedConditions.textToBePresentInElement(timer,"00:01:45"));
         startButton.click();
         System.out.println(timer.getText());
         Assert.assertTrue("Time doesn't reach expected", timer.getText().contains("00:01:45"));
         resetButton.click();
         System.out.println(timer.getText());
         Assert.assertTrue("Timer is not reset",timer.getText().contains("00:02:00"));




     }

    @Before

    public void setup(){
        createDriver("https://www.timeanddate.com/timer/");
    }


    @After
    public void cleanUp(){
        quitDriver();
    }


 }
