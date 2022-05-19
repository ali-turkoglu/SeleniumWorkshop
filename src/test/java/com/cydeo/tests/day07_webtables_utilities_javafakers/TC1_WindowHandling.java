package com.cydeo.tests.day07_webtables_utilities_javafakers;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_WindowHandling {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        //TC #1: Window Handle practice
        //1. Create new test and make set ups

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void window_handling_test(){

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");


        //3. Copy-paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
       /* Set<String > windowSet=driver.getWindowHandles();

        for (String each : windowSet) {
            System.out.println(driver.switchTo().window(each).getTitle() +" : "+ driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        String actualTitle=driver.getTitle();
        String expectedTitle="Etsy";

        Assert.assertTrue(actualTitle.contains(expectedTitle));*/
        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");

        //Lines to be pasted:

        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
    }



}
