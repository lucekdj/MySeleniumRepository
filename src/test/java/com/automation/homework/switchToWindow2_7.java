package com.automation.homework;

import com.automation.commons.CommonMethods;
import org.checkerframework.checker.units.qual.K;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class switchToWindow2_7 extends CommonMethods {


    // 1  in before  -setup()- ,we call -createDriver()-   which is created in-DriverUtils- class
    // to create driver -ChromeDriver- and takes this url website
    //  open https://magento.softwaretestingboard.com/
    @Before
    public void setup() {
        createDriver("https://magento.softwaretestingboard.com/");
    }


    @Test
    public void switchWindow() throws InterruptedException {

        // we call -getDrive()-which return driver from  ,path> @Before -setUp()-
        // which has -createDriver()-  which has -driver-  in -DriverUtils- class
        // to get driver and perform actions
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();

        // 1  in before -method create Driver
        //  open https://magento.softwaretestingboard.com/
        // 2 Command/Control click on the “Sale” option in the header
        WebElement SaleBtn = driver.findElement(By.xpath("//span[contains(text(),'Sale')] "));
        actions.keyDown(Keys.CONTROL).click(SaleBtn).keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);

        //switchTo() the new opened tab (window)
        String mainWindow = driver.getWindowHandle();
        Set<String> setOfWindowsList = driver.getWindowHandles();
        ArrayList<String> listOfWindowHandles = new ArrayList<>(setOfWindowsList);
        //ArrayList<String> listOfWindowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println(mainWindow);
        System.out.println(listOfWindowHandles);

//        for (int i = 0; i < listOfWindowHandles.size(); i++) {
//            if (!listOfWindowHandles.get(i).equals(mainWindow)) {
//                driver.switchTo().window(listOfWindowHandles.get(i));
//                Thread.sleep(2000);
//                System.out.println(driver.getTitle());
//                System.out.println(driver.getCurrentUrl());
//
//                WebElement PromoBlock = driver.findElement(By.xpath("//div[@class='blocks-promo']"));
//
//                Assert.assertTrue("Promotion block not displayed", PromoBlock.isDisplayed());
//                //Close the tab and
//                driver.close();
//
//                Thread.sleep(2000);
//            }
//        }
//        // and switch back to the primary tab
//        //Assert that you are back on the landing page
//        driver.switchTo().window(mainWindow);
//        System.out.println(driver.getCurrentUrl() + "++++" + driver.getTitle());
//        WebElement welcomePage = driver.findElement(By.xpath("//div[@class='panel header']//*[text()='Default welcome msg!']"));
//        Assert.assertTrue("main window is not displayed", welcomePage.isDisplayed());
//
//        Thread.sleep(1000);



        for(String windowHandle : listOfWindowHandles) {

            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(3000);

                //Assert that all of the promotion block are displayed
                WebElement PromoBlock = driver.findElement(By.xpath("//div[@class='blocks-promo']"));
                Assert.assertTrue("Promotion block not displayed", PromoBlock.isDisplayed());
                driver.close();

            }
        }
         //and switch back to the primary tab
        //Assert that you are back on the landing page
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getCurrentUrl() + "++++" + driver.getTitle());
        WebElement welcomePage = driver.findElement(By.xpath("//div[@class='panel header']//*[text()='Default welcome msg!']"));
        Assert.assertTrue("main window is not displayed", welcomePage.isDisplayed());

        Thread.sleep(1000);



    }

    @After public void cleanUp() {
            quitDriver();

    }
}

//        for (String windowHandle : listOfWindowHandles) {
//            if (!windowHandle.equals(mainWindow)) {
//                driver.switchTo().window(mainWindow);
//                if (driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/sale.html")) {
//                    WebElement PromoBlock = driver.findElement(By.xpath("//div[@class='blocks-promo']"));
//
//                    Assert.assertTrue("Promotion block not displayed", PromoBlock.isDisplayed());
//                    driver.close();
//
//                } else {
//                    driver.close();
//                    Thread.sleep(3000);
//
//                }
//            }
//        }
