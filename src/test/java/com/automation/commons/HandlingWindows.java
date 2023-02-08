package com.automation.commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Set;

public class HandlingWindows extends CommonMethods{

    @Test
    public void learnWindowHandling() throws InterruptedException {

        WebDriver driver = getDriver();

        driver.navigate().to("https://demoqa.com/browser-windows");

        //#tabButton
        //#windowButton
        WebElement tabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
        //WebElement tabButton = driver.findElement(By.ByCssSelector("#tabButton"));
        WebElement windowButton = driver.findElement(By.id("windowButton"));
        //WebElement windowButton = driver.findElement(By.cssSelector("#windowButton"));

        String primaryWindow = driver.getWindowHandle();

        tabButton.click();
        Thread.sleep(1000);
        windowButton.click();

        System.out.println(driver.getWindowHandles()); //  [CDwindow-1A7F718E6E989460F6C04FA77A78E44A - dynamic window handle
        Thread.sleep(3000);

        Set<String> windowSet = driver.getWindowHandles();
        ArrayList<String> windowList = new ArrayList<>(windowSet);

        for (String windowHandle:windowSet){
            Thread.sleep(3000);
            if (!windowHandle.equals(primaryWindow)){
            driver.switchTo().window(windowHandle);
            WebElement header = driver.findElement(By.tagName("h1"));
                System.out.println(header.getText());
                System.out.println(windowHandle);
                System.out.println(driver.getCurrentUrl());

                driver.close();

            }
        }

        driver.switchTo().window(primaryWindow);
        Thread.sleep(3000);


    }

    @Test
    public void windowHandlingExample() throws InterruptedException {

        WebDriver driver = getDriver();
        //driver.navigate().to("https://magento.softwaretestingboard.com/");

        Actions actions = new Actions(driver);

        String primaryWindow = driver.getWindowHandle();

        WebElement shopNewYogaBtn = driver.findElement(By.xpath("//span[contains(text(),'Shop New Yoga')]"));

        actions.keyDown(Keys.CONTROL).click(shopNewYogaBtn).keyUp(Keys.CONTROL).build().perform();

        ArrayList<String> windowList = new ArrayList<>(driver.getWindowHandles());

        for (String windowHandle: windowList){
            if(!windowHandle.equals(primaryWindow)){
                driver.switchTo().window(windowHandle);

                if(!driver.getCurrentUrl().contains("/collections/yoga-new.html")){
                //if(!driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/collections/yoga-new.html")){

                    driver.close();

                }
            }
        }

        WebElement category = driver.findElement(By.xpath("//li[@class='item category8']/strong"));

        Assert.assertTrue("Category does not match expected",
                category.getText().equalsIgnoreCase("new luma yoga collection"));

        Thread.sleep(3000);

        driver.close();
        driver.switchTo().window(primaryWindow);
        // don't need to initialize here because we are in the same window
        // shopNewYogaBtn = driver.findElement(By.xpath("//span[contains(text(),'Shop New Yoga')]"));

         Assert.assertTrue("Shop yoga button is not visible ", shopNewYogaBtn.isDisplayed());


         Thread.sleep(3000);
    }


    @Before
    public void setup(){
        createDriver("https://magento.softwaretestingboard.com/");
    }


    @After
    public void cleanUp(){
        quitDriver();
    }
}
