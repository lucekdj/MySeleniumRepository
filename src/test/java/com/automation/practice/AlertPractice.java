package com.automation.practice;
import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPractice extends CommonMethods {

    @Test
    public void findAlert() throws InterruptedException{
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frm1']"));
        driver.switchTo().frame(frame1);

        WebElement drop = driver.findElement(By.id("selectnav1"));
        Select dropOptions = new Select(drop);

        driverWait.until(ExpectedConditions.textToBePresentInElement(drop, "- Alerts"));
        dropOptions.selectByVisibleText("- Alerts");

        //explicitly changing frames to fix frame-refreshing issue.
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame1);
        WebElement click = driver.findElement(By.xpath("//button[@id=\"alertBox\"]"));
        click.click();
        Thread.sleep(2000);

        Alert alert1 = driverWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);

        Assert.assertTrue("Alert Box did not appear.", alert1.getText().equalsIgnoreCase("I am an alert box!"));
    }

    @Before
    public void setUp(){
        createDriver("https://www.hyrtutorials.com/p/frames-practice.html");
    }
    @After
    public void cleanUp(){
        quitDriver();
    }
}