package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDowns extends CommonMethods{

    @Test
    public void LearnDropdowns() throws InterruptedException {

        WebDriver driver = getDriver();

        driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        Thread.sleep(3000);

        WebElement dropdown = driver.findElement(By.xpath("//select"));
        WebElement selectCountryTitle = driver.findElement(By.id("Select Country"));


        System.out.println(selectCountryTitle.getText());
        System.out.println(selectCountryTitle.getAttribute("id"));
        System.out.println(selectCountryTitle.getAttribute("class"));
        System.out.println(selectCountryTitle.getAttribute("aria-controls"));
        System.out.println(selectCountryTitle.getAttribute("role"));

        System.out.println("-------------------------");
        //Select class has a constructor with parameter WebElement therefore we need to pass an element to the class
        // the element we pass it should be the dropdown we want to manipulate
        Select countriesDropdown = new Select(dropdown);


        List<WebElement> optionList = countriesDropdown.getOptions();

        for(WebElement option :optionList){
            //System.out.println(option.getText());
            System.out.println(option.getText() + "\t" + option.getAttribute("value"));

        }


        //System.out.println(countriesDropdown.getOptions());
        countriesDropdown.selectByVisibleText("Bermuda");
        Thread.sleep(3000);
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
