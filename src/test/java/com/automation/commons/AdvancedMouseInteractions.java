package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class AdvancedMouseInteractions extends CommonMethods{


    @Test
    public void learnAdvanceMouseInterventions() throws InterruptedException {
        WebDriver driver = getDriver();

        //Creating object of the action class and passing WebDriver as a parameter to its contructor
        Actions actions = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Right')]"));


        //Actions class has a lot of diff methods to perform various diff advanced mouse interactions and actions.
        //In this cae we are calling double click method and passing an element we want ot click on.
        //We are then calling build method in order to build the actual sequence
        //And then the .perform() method which actually performs the actions

        actions.doubleClick(doubleClickBtn).build().perform();

        Thread.sleep(2000);

        //The actions .contextClick() method will perform a right click/context click (synonym) on the
        // WebElement that is passes as a parameter
        actions.contextClick(rightClickBtn).build().perform();

        Thread.sleep(2000);

        //moveToElement with doubleClickBtn parameter - in this case we are performing same action double click
        // But we are using the move to element method to first move the mouse to the element anf then perform double click
        actions.moveToElement(doubleClickBtn).doubleClick().build().perform();

        Thread.sleep(2000);

        //HOVERS

        driver.navigate().to("http://the-internet.herokuapp.com/hovers");
        Thread.sleep(1000);
        //here we are using the .moveToElement() method to essentially hover over a specific element
        WebElement hoverIcon = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        actions.moveToElement(hoverIcon).build().perform();
        Thread.sleep(2000);

        WebElement hoverIcon2 = driver.findElement(By.xpath("//div[@class='figure'][2]"));
        actions.moveToElement(hoverIcon2).build().perform();
        Thread.sleep(2000);

        WebElement hoverIcon3 = driver.findElement(By.xpath("//div[@class='figure'][3]"));
        actions.moveToElement(hoverIcon3).build().perform();
        Thread.sleep(2000);

        actions.moveToElement(hoverIcon).build().perform();
        WebElement viewProfileLink = driver.findElement(By.xpath("//div[@class='figure'][1]//a"));
        //this method will hold down ctrl key click and pick up
        actions.keyDown(Keys.COMMAND).click(viewProfileLink).keyUp(Keys.COMMAND).build().perform();
        Thread.sleep(2000);


    }


    @Test
    public void learnDragAndDrop() throws InterruptedException {

        WebDriver driver = getDriver();

        Actions actions = new Actions(driver);

        driver.navigate().to("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("draggable"));


        actions.dragAndDrop(draggable,droppable).build().perform();

        Thread.sleep(3000);

        driver.navigate().to("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        actions.dragAndDropBy(slider, 80,0).build().perform();

        Thread.sleep(4000);

        actions.dragAndDropBy(slider, 20,0).build().perform();


    }

    @Test
    public void learnScroll() throws InterruptedException {
        WebDriver driver=getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        loginToSauceDemo();
        WebElement footer =driver.findElement(By.className("footer_copy"));

        //ScrollToElement() method will scroll to the WebElement passed as the parameter
        actions.scrollToElement(footer).build().perform();
        Thread.sleep(3000);

        //Scroll by amount method will scroll by specified amount on the x and y axis
        actions.scrollByAmount(0,500).build().perform();
        Thread.sleep(5000);
        actions.scrollByAmount(0,-300).build().perform();
        Thread.sleep(5000);
    }

////div[text()='Sauce Labs Onesie']

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/buttons");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }

}
