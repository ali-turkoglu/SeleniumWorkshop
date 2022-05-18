package com.cydeo.tests.day05_testNG_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_Simple_Dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC#4: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //1. Open Chrome browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void simpleDropdown(){

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Verify “Simple dropdown” default selected value is correct
        Select simpleDropdown=new Select(driver.findElement(By.xpath(" //select[@id='dropdown']")));

        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualSimpleDropdownText= currentlySelectedOption.getText();
        String expectedSimpleDropdownText="Please select an option";
        //System.out.println("actualSimpleDropdownText = " + actualSimpleDropdownText);

        Assert.assertEquals(actualSimpleDropdownText,expectedSimpleDropdownText);

        //Expected: “Please select an option”


        //4. Verify “State selection” default selected value is correct


        //Expected: “Select a State”
        Select stateDropdown=new Select(driver.findElement(By.cssSelector("select#state")));

        String expectedStateDropdown="Select a State";
        String actualStateDropdown=stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualStateDropdown,expectedStateDropdown);

    }
}
