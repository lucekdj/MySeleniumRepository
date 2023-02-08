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


        //.getWindowHandle() returns the String window handle of the current window
        //Here we are saving the window handle of the current window as a String variable so that we can return to it later
        String primaryWindow = driver.getWindowHandle();

        tabButton.click();
        Thread.sleep(1000);
        windowButton.click();

        System.out.println(driver.getWindowHandles()); //  [CDwindow-1A7F718E6E989460F6C04FA77A78E44A - dynamic window handle
        Thread.sleep(3000);

        //Here we are taking the return type Set<String> and casting it to an ArrayList<String> for easy access
        Set<String> windowSet = driver.getWindowHandles();
        ArrayList<String> windowList = new ArrayList<>(windowSet);


        //Here we are creating a for each loop to cycle through the elements of the windows list and then we are
        //making sure that the current window isn't the primary window we were originally in
        for (String windowHandle:windowSet){
            if (!windowHandle.equals(primaryWindow)){
                Thread.sleep(3000);

                //Here we are switch to the current window that passed all above conditions
                driver.switchTo().window(windowHandle);
                WebElement header = driver.findElement(By.tagName("h1"));
                System.out.println(header.getText());
                System.out.println(windowHandle);
                System.out.println(driver.getCurrentUrl());
//This method is different from driver.quit() it closes the specific window that is currently active
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


        //Since driver.getWindowHandles() method returns a set of window handles we can pass it to the constructor
        //of the arraylist which will cast it into an ArrayList
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

        //Here on out we are in a new window
        WebElement category = driver.findElement(By.xpath("//li[@class='item category8']/strong"));

        Assert.assertTrue("Category does not match expected",
                category.getText().equalsIgnoreCase("new luma yoga collection"));

        Thread.sleep(3000);

        //Closing the current tab
        driver.close();
        //Switching to the original window
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
