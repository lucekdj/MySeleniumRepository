package com.automation.homework;

import com.automation.commons.DayOne;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework1XpathLocators1_27 extends DayOne {

    WebDriver dr;
    @Before
    public void setUp(){
       createDriver("https://www.saucedemo.com/");
    }


    @Test
    public void login() throws InterruptedException {
        dr = getDriver();

        WebElement usernameInput = dr.findElement(By.id("user-name"));
        WebElement passwordInput = dr.findElement(By.id("password"));
        WebElement loginButton = dr.findElement(By.id("login-button"));

        usernameInput.sendKeys("standard_user");
        Thread.sleep(1000);
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();



        WebElement productPage = dr.findElement(By.className("title"));
        Assert.assertTrue("Product Page Not Displayed ", productPage.isDisplayed());
        System.out.println(productPage.getText());
        Thread.sleep(1000);
        WebElement addToTheShoppingCart = dr.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        System.out.println(addToTheShoppingCart.getText());
        Thread.sleep(500);
        addToTheShoppingCart.click();
        Thread.sleep(500);
        WebElement shoppingCart = dr.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();
        Thread.sleep(500);
        WebElement itemInTheShoppingCart = dr.findElement(By.className("inventory_item_name"));
        Assert.assertTrue("item is not in the cart", itemInTheShoppingCart.isDisplayed());
        Thread.sleep(1000);
        WebElement removeFromShoppingCart = dr.findElement(By.id("remove-sauce-labs-backpack"));
        removeFromShoppingCart.click();
        //Assert.assertTrue("item is not in the cart", removeFromShoppingCart.isDisplayed());
        Thread.sleep(2000);
        WebElement continueShopping = dr.findElement(By.id("continue-shopping"));
        continueShopping.click();
        Thread.sleep(2000);



    }
    @After
    public void cleanUp(){
        quitDriver();
    }



}
