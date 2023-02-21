package com.automation.homework;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iframe2_7 extends CommonMethods {


    @Before
    public void setUp() {
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp() {
        quitDriver();


    }




    @Test
    public void iframeHandle() throws InterruptedException {

        WebDriver driver = getDriver();
        driver.navigate().to("https://www.hyrtutorials.com/p/frames-practice.html");

        WebElement iframe2 = driver.findElement(By.id("frm2"));

        Actions actions = new Actions(driver);
//        actions.scrollToElement(iframe2).build().perform();
//        Thread.sleep(10000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",iframe2);
        Thread.sleep(5000);

         driver.switchTo().frame(iframe2);





        //WebElement firstName = driver.findElement(By.id("firstName"));
        //firstName.sendKeys("Lolo");
        driver.findElement(By.id("firstName")).sendKeys("Lolo");

        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement genderM = driver.findElement(By.id("malerb"));
        WebElement language = driver.findElement(By.id("englishchbx"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement registerBtn = driver.findElement(By.xpath("//*[@id='registerbtn']"));



        lastName.sendKeys("Polo");
        Thread.sleep(2000);
        genderM.click();
        Thread.sleep(2000);
        language.click();
        Thread.sleep(2000);
        email.sendKeys("LoloPolo123@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("LoloPolo123");
        Thread.sleep(2000);
        registerBtn.click();

        Thread.sleep(2000);
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }
}
