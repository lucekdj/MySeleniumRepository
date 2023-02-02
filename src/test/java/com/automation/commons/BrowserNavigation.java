package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;



public class BrowserNavigation extends CommonMethods{

   @Test
   public void learnBrowserNavigation() throws InterruptedException {
       WebDriver driver = getDriver();

       Thread.sleep(3000);

        //driver.navigate().to(url) essentially opens up a different url in the same

       driver.navigate().to("http://18.116.88.132:8080/bank/login");
       Thread.sleep(3000);

       driver.navigate().back();
       Thread.sleep(3000);

       driver.navigate().forward();

       driver.navigate().refresh();
       Thread.sleep(3000);

   }

   @Test
   public void practice1() throws InterruptedException {

       WebDriver driver = getDriver();

       loginToSauceDemo();
       Thread.sleep(3000);


   }


   @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }



}


