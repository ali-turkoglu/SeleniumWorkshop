package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    //This method will accept int (in seconds) and execute Thread.sleep for given duration
    public static void sleep(int second){

        try {
            Thread.sleep(second*1000);
        }catch (Exception e){

        }
    }


    // This method will create a logic to switch to the tab/window where given is open
    // accept 3 arguments 1- webdriver 2- expectedInUrl  3- expectedTitle to be compare against actual
    public static void switchWindowAndVerify(WebDriver driver,String expectedInUrl,String expectedTitle){

        Set<String > allWindowHandles=driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: "+ driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        //5. Assert: Title contains “expectedTitle”
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


    // This method accepts a String "expectedTitle" and Asserts if it is true
    public static void verifyTitle(WebDriver driver,String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }



}
