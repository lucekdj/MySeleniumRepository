package com.automation.homework;

import com.automation.commons.CommonMethods;
import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Homework2PriceLowToHigh2_1 extends CommonMethods {

    WebDriver dr;
    @Test
    public void dropDownPriceFilter() throws InterruptedException {
        dr = getDriver();
        loginToSauceDemo();

        //By cssSelector-  .product_sort_container
        WebElement dropDownElement = dr.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select dropDownOption = new Select(dropDownElement);
        Thread.sleep(3000);
        dropDownOption.selectByVisibleText("Price (low to high)");
        Thread.sleep(3000);

        List<WebElement> priceItems = dr.findElements(By.xpath("//div[@class='inventory_item_price']"));
        ArrayList<String> prices = new ArrayList<>();
        for(int i=0; i < prices.size(); i++){
            prices.add(priceItems.get(i).getText());
        }


//        for(WebElement prices : priceItems){
//            System.out.println(prices.getText());
//
//        }
       // Assert.assertEquals("$7.99", priceItems.get(0).getText());

        String expectedLowestPrice ="$7.99";
        String actualPrice = priceItems.get(0).getText();
        Assert.assertEquals(expectedLowestPrice,actualPrice);



        WebElement optionLowToHigh = dr.findElement(By.xpath("//option[text()='Price (low to high)']"));
        Assert.assertTrue("Option -Low To High- not visible",optionLowToHigh.isDisplayed());
        dr.navigate().refresh();

        Thread.sleep(3000);

        WebElement dropDownElementAfterRefresh = dr.findElement(By.cssSelector(".product_sort_container"));
        Assert.assertTrue("Drop Down filter option didn't change" +
                " to orginal value after refresh",dropDownElementAfterRefresh.isDisplayed());

        Thread.sleep(2000);

    }




    @Before
    public void setUp() {
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp() {
        quitDriver();


    }
}

