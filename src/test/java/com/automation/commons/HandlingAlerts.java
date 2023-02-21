package com.automation.commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingAlerts extends CommonMethods{

    @Test
    public void learnAlertHandling() throws InterruptedException {
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement button1 = driver.findElement(By.id("alertButton"));
        WebElement button2 = driver.findElement(By.id("timerAlertButton"));
        WebElement button3 = driver.findElement(By.id("confirmButton"));
        WebElement button4 = driver.findElement(By.id("promtButton"));

        button1.click();

        //Alert interface has a couple of methods in order to handle alerts
        //switchTo().alert(); will switch to the presently active alert
        //We are creating instance of this interface by switching to current alert on the page
        driverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        //the .dismiss() method essentially just dismisses or closes the alert and switches back to the main frame
        alert.dismiss();


        button2.click();
        //here we are using an explicit wait to wait for the alert to show up before continuing
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        alert.dismiss();


        button3.click();
        // Explicit wait to wait for the alert to show up
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        //the alert.accept() method is essentially the same as clicking "OK" or confirming the alert
        alert.accept();
        //The alert.dismiss() method is essentially the same as clicking "Cancel" or declining the alert
        //alert.dismiss();

        WebElement selectionResult = driver.findElement(By.cssSelector("#confirmResult"));
        Assert.assertTrue("User did not select Ok/accept the alert", selectionResult.getText().equalsIgnoreCase("You selected ok"));
        Thread.sleep(1000);


        button4.click();
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        //this method will type in whatever String you pass to it into the input of the alert
        alert.sendKeys("Hello world!");
        Thread.sleep(3000);
        alert.accept();


        Assert.assertEquals("You entered Hello world!",driver.findElement(By.xpath("//span[@id='promptResult']")).getText());

        //We can create an alert by using Webdriver
        //Alert alert1 = driverWait.until(ExpectedConditions.alertIsPresent());

        //driverWait.until(ExpectedConditions.alertIsPresent());
        // alert2 = driver.switchTo().alert();






        Thread.sleep(3000);
    }
    @Before
    public void setUp() {
        createDriver("https://demoqa.com/alerts");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }


}
