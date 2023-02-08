package com.automation.commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DayTwo extends DayOne{



@Test
    public void login() throws InterruptedException {
    //createDriver();    method not needed because we create WebDriver on line 39
    // to call method  we created   on day one class _getDriver_ what returns this method
    /*
    public  void createDriver(String url) {
        System.setProperty("webdriver.chrome.driver" , "src/test/java/driver/chromedriver.exe ");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();
        }
     */
    // and using here on line 39 to call Web driver
    //-private static void  method -from class day one



    WebDriver driver = getDriver();

        //colling login page elements
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));


        // here we are in login page
        usernameInput.sendKeys("standard_user");
        Thread.sleep(1000);
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(1000);
        loginButton.click();


        Thread.sleep(1000);
        //After we logged in
        // here we call element  in product page

        WebElement productsPageTitle = driver.findElement(By.className("title"));

        System.out.println(productsPageTitle.getText());

        Assert.assertTrue("Not on the product page",productsPageTitle.isDisplayed());
        //Assert.assertFalse("It is on the product page", productsPageTitle.isDisplayed());
        //Assert.assertTrue("Not on the product page",!productsPageTitle.isDisplayed());



        //ArrayList<WebElement> inventoryItemDescriptions = (ArrayList<WebElement>) driver.findElement(By.className("inventory_item_desc"));
        List<WebElement> inventoryItemDescriptions =  driver.findElements(By.className("inventory_item_desc"));

        List<WebElement> inventoryItemTitles = driver.findElements(By.className("inventory_item_name"));

        for (int i = 0; i < inventoryItemTitles.size(); i++){
        System.out.println(inventoryItemTitles.get(i).getText());
        System.out.println(inventoryItemDescriptions.get(i).getText());

        System.out.println("============================");
        }


        //    for(WebElement webElement:inventoryItemDescriptions){
        //        System.out.println(webElement.getText());
        //        System.out.println("##########################");
        //
        //    }


        Thread.sleep(1000);




    }


    @Before

    public void setup(){
        createDriver("https://www.saucedemo.com/");
    }


    @After
    public void cleanUp(){
        quitDriver();
    }

}
