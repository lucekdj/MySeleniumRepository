package com.automation.practice;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Practice1 extends CommonMethods {



        @Test
        public void practice1 () throws InterruptedException {
            WebDriver driver = getDriver();

            loginToSauceDemo();

            Thread.sleep(3000);

            WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
            Assert.assertTrue("is Displayed ", shoppingCart.isDisplayed());
            System.out.println(shoppingCart.getText());




        }
        @After
        public void cleanUp(){
            quitDriver();
        }

        @Before
        public void setUp(){
            createDriver("https://www.saucedemo.com/");
        }
}
