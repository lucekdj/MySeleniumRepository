package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.sql.DriverManager.getDriver;

public abstract class CommonMethods extends DriverUtils {

    public void loginToSauceDemo()  {

        WebDriver driver = getDriver();

//colling login page elements
        WebElement usernameInput = getDriver().findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));


// here we are in login page
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();




    }

}
