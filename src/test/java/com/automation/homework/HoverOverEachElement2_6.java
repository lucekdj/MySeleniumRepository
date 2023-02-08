package com.automation.homework;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoverOverEachElement2_6 extends CommonMethods {


    @Test
    public void hoverEachElement() throws InterruptedException {

        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement hotSellers = driver.findElement(By.xpath("//h2[@class='title']"));
        // it doesn't scroll to the center of page,it scroll -HotSellers- title to the center.
        //jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", hotSellers);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", hotSellers);
        Thread.sleep(1000);

        List<WebElement> productList = driver.findElements(By.xpath("//li[@class='product-item']"));

        for (WebElement option : productList ){

            actions.moveToElement(option).build().perform();
            Thread.sleep(1000);

            //This -Add to Cart- can't be find and test doesn't pass.
           // WebElement addCartBtn = driver.findElement(By.xpath("//span[text()='Add to Cart']"));

            WebElement addCartBtn = driver.findElement(By.xpath("//button[contains(@title,'Add to Cart')]"));
            Assert.assertTrue("-Add Btn- is not displayed", addCartBtn.isDisplayed());
            System.out.println(addCartBtn.getText());
        }

/*
        List<WebElement> listOfHotSellersItems = driver.findElements(By.xpath("//li[@class='product-item']"));

        List<WebElement> addToCartBtn = driver.findElements(By.xpath("//span[contains(text(),'Add to Cart')]"));

        for (int i = 0; i < listOfHotSellersItems.size(); i++) {
            actions.moveToElement(listOfHotSellersItems.get(i)).build().perform();
            Thread.sleep(1000);
           Assert.assertTrue("Add to Cart not Displayed", addToCartBtn.get(i).isDisplayed());
        }
*/
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
