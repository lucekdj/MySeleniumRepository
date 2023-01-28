package commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DayTwo extends DayOne{

    @Before

    public void setup(){
       createDriver();
    }

@Test
    public void login() throws InterruptedException {
    //createDriver();    method not needed because we create WebDriver on line25
    // we create  method on day one class _get driver_ and using here on line 26 to call Web driver
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
    //Assert.assertTrue("Not on the product page",!productsPageTitle.isDisplayed());

    //ArrayList<WebElement> inventoryItemDescriptions = (ArrayList<WebElement>) driver.findElement(By.className("inventory_item_desc"));
    List<WebElement> inventoryItemDescriptions =  driver.findElements(By.className("inventory_item_desc"));

    for(WebElement webElement:inventoryItemDescriptions){
        System.out.println(webElement.getText());
        System.out.println("##########################");

    }



    List<WebElement> inventoryItemTitles = driver.findElements(By.className("inventory_item_name"));

    for (int i = 0; i < inventoryItemDescriptions.size(); i++){
        System.out.println(inventoryItemTitles.get(i).getText());
        System.out.println(inventoryItemDescriptions.get(i).getText());

        System.out.println("============================");
    }


    Thread.sleep(1000);

    //driver.findElement(By.id("this id doesn't exist"));
    //driver.quit();




}

@After
    public void cleanUp(){
        quitDriver();
}
}
