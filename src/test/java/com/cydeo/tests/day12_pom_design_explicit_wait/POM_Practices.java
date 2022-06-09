package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POM_Practices {

    LibraryLoginPage libraryLoginPage;

    @Test
    public void required_field_error_message_test(){

        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");


        //3- Do not enter any information
        //4- Click to “Sign in” button
        libraryLoginPage=new LibraryLoginPage();
        libraryLoginPage.signInButton.click();


        //5- Verify expected error is displayed:
        //Expected: This field is required.

        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

        Driver.closeDriver();



    }

    @Test
    public void invalidEmailErrorMessage(){

        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Enter invalid email format
        libraryLoginPage=new LibraryLoginPage();

        libraryLoginPage.inputUsername.sendKeys("ksdjlrrrerf");

        libraryLoginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.


        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());


    }

    @Test
    public void wrongEmailErrorMessage(){

        //TC #3: Library negative login
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Enter incorrect username or incorrect password
        LibraryLoginPage libraryLoginPage=new LibraryLoginPage();

        libraryLoginPage.inputUsername.sendKeys("lskd@sdf.kkk");

        libraryLoginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordMessage.isDisplayed());

        //NOTE: FOLLOW POM DESIGN PATTERN


    }

}
