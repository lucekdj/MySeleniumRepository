package com.automation.homework;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrderPlacedSuccessScreen2_3 extends DriverUtils {


    @Test
    public void hover() throws InterruptedException {

        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);
        Thread.sleep(1000);

        //1 In a new Homework class open this page: https://magento.softwaretestingboard.com/

        //get method will get to the website you want to work on
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(2000);
        ////div[@class='products-grid grid']
        WebElement hotSellers = driver.findElement(By.xpath("//ol"));

        actions.scrollToElement(hotSellers).build().perform();
        Thread.sleep(2000);
        actions.scrollByAmount(0,-300);

        // 2Once on the page scroll down to the bottom of the page where the “Hot Sellers” section is visible
        WebElement heroHoodie = driver.findElement(By.xpath("//a[@title='Hero Hoodie']"));

        actions.moveToElement(heroHoodie).build().perform();
        Thread.sleep(2000);

        WebElement addButton = driver.findElement(By.xpath("//ol[@class='product-items widget-product-grid']/li[4]//span[text()='Add to Cart']"));
        Assert.assertTrue("add button is not visible", addButton.isDisplayed());

        WebElement mediumSize = driver.findElement(By.xpath("//ol[@class='product-items widget-product-grid']/li[4]/div/div/div[2]/div/div/div[contains(text(),'M')]"));
        WebElement greenColor = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-53']"));

        actions.click(mediumSize).build().perform();
        Thread.sleep(2000);

        actions.click(greenColor).build().perform();
        Thread.sleep(2000);

        actions.click(addButton).build().perform();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        //a[@class='action showcart']
        WebElement cartBtn = driver.findElement(By.xpath("//a/*[contains(text(),'My Cart')]//ancestor::a"));
        Thread.sleep(2000);
        actions.click(cartBtn).build().perform();
        Thread.sleep(2000);

        WebElement proceedToCheck = driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
        actions.click(proceedToCheck).build().perform();
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.xpath("//div[@class='control _with-tooltip']/input[@id='customer-email']"));
        email.sendKeys("LoloPolo193@gmail.com");
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Lolo");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("POLO");
        Thread.sleep(1000);

        WebElement company = driver.findElement(By.xpath("//input[@name='company']"));
        company.sendKeys("LOL");
        Thread.sleep(1000);

        WebElement streetAddress = driver.findElement(By.xpath("//form[@class='form form-shipping-address']//fieldset/div/div/div/input[@name='street[0]']"));
        streetAddress.sendKeys("12 Qwerty");
        Thread.sleep(1000);

        WebElement city = driver.findElement(By.xpath("//form[@class='form form-shipping-address']/div/div[4]/div/input[@name='city']"));
        city.sendKeys("Chicago");
        Thread.sleep(1000);

        WebElement state = driver.findElement(By.xpath("//*[@name='region_id']"));

        Select selectOption = new Select(state);
        selectOption.selectByVisibleText("Illinois");
        Thread.sleep(3000);

        WebElement zip = driver.findElement(By.xpath("//form[@class='form form-shipping-address']/div/div[7]/div/input[@name='postcode']"));
        zip.sendKeys("60634");
        Thread.sleep(1000);

        WebElement country = driver.findElement(By.xpath("//*/div/select[@name='country_id']"));
        selectOption = new Select(country);
        selectOption.selectByVisibleText("United States");
        Thread.sleep(3000);

        WebElement phNr = driver.findElement(By.xpath("//*/input[@name='telephone']"));
        phNr.sendKeys("600-100-200");
        Thread.sleep(1000);

        WebElement shippingMet = driver.findElement(By.xpath("//td/input[@class='radio']"));
        actions.click(shippingMet).build().perform();
        Thread.sleep(1000);

        WebElement nextButton = driver.findElement(By.xpath("//div[@class='primary']/button[@class='button action continue primary']"));
        nextButton.click();
        Assert.assertTrue("form is not displayed",nextButton.isDisplayed());
        Thread.sleep(3000);


        //9 Then hit place order and assert that your order has been placed by checking the success screen.

        WebElement placeOrderBtn = driver.findElement(By.xpath("//*/span[contains(text(),'Place Order')]"));
        placeOrderBtn.click();
        Assert.assertTrue("order has not been placed", placeOrderBtn.isDisplayed());
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



