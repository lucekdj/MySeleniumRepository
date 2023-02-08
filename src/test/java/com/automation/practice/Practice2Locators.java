package com.automation.practice;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Practice2Locators extends DriverUtils {


  @Test
  public void fillTheForm() throws InterruptedException {

      WebDriver driver = getDriver();
      Actions actions = new Actions(driver);
      Thread.sleep(3000);

      // we navigate to- we can use methods  forward(),back(),etc
      // driver.get() - we can't use this methods
      // in Before already we get the website
     // driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
     // Thread.sleep(3000);


      WebElement firstName = driver.findElement(By.xpath("//h2/div/div/div[2]/input[@name='firstname']"));
      firstName.sendKeys("lolo");
      Thread.sleep(1000);

      WebElement lastName = driver.findElement(By.xpath("//*/input[@name='lastname']"));
      lastName.sendKeys("polo");
      Thread.sleep(1000);

      WebElement genderName = driver.findElement(By.xpath("//*/input[@id='sex-0']"));
      actions.click(genderName).build().perform();
      Thread.sleep(1000);

      WebElement yearOfExp = driver.findElement(By.xpath("//input[@id='exp-1']"));
      yearOfExp.click();
      Thread.sleep(1000);

      WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
      date.sendKeys("02/06/2023");
      Thread.sleep(1000);

      WebElement profession = driver.findElement(By.xpath("//input[@id='profession-0']"));
      actions.click(profession).build().perform();
      Thread.sleep(3000);

      WebElement automation = driver.findElement(By.cssSelector("#tool-1"));
      actions.click(automation).build().perform();
      Thread.sleep(3000);

      WebElement continentsOption = driver.findElement(By.xpath("//select[@id='continents']"));
      Select continentsDropDown = new Select(continentsOption);
      continentsDropDown.selectByVisibleText("Africa");
      Thread.sleep(3000);

      WebElement seleniumCommends = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
      Select seleniumDropDown = new Select(seleniumCommends);
      seleniumDropDown.selectByVisibleText("Browser Commands");
      Thread.sleep(3000);

      // WebElement imageUpload = driver.findElement(By.xpath("//input[@id='photo']"));
      WebElement imageUpload = driver.findElement(By.cssSelector(".input-file "));
        imageUpload.sendKeys("c:/Users/lucek/Desktop/image (15).png");
        //"C:\Users\lucek\Desktop\image (15).png"
        Thread.sleep(2000);



  }

  @Before

    public void setup(){
        createDriver("https://www.techlistic.com/p/selenium-practice-form.html");
    }


    @After
    public void cleanUp(){
        quitDriver();
    }

}
