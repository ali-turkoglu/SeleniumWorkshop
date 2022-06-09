package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.DynamicallyLoaded1Page;
import com.cydeo.pages.DynamicallyLoaded7Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractice {

    @Test
    public void dynamic_load_7_test() {
        //TC#4 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        // Create object of DynamicLoad7Page to reach any assert web elements
        DynamicallyLoaded7Page dynamicallyLoaded7Page = new DynamicallyLoaded7Page();

        //3. Assert: Message “Done” is displayed.
        Assert.assertTrue(dynamicallyLoaded7Page.doneMessage.isDisplayed());

        //4. Assert: Image is displayed.
        Assert.assertTrue(dynamicallyLoaded7Page.spongeBobImage.isDisplayed());

        //Note: Follow POM
    }

    @Test
    public void dynamically_load_1_test(){

        //TC#5 : Dynamically Loaded Page Elements 1
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicallyLoaded1Page dynamicallyLoaded1Page=new DynamicallyLoaded1Page();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);



        //2. Click to start

        dynamicallyLoaded1Page.startButton.click();

        //3. Wait until loading bar disappears

        wait.until(ExpectedConditions.invisibilityOf(dynamicallyLoaded1Page.loadingBar));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicallyLoaded1Page.username.isDisplayed());

        //5. Enter username: tomsmith
        dynamicallyLoaded1Page.username.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword
        dynamicallyLoaded1Page.password.sendKeys("sdfsdf");

        //7. Click to Submit button
        dynamicallyLoaded1Page.submitButton.click();

        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicallyLoaded1Page.errorMessage.isDisplayed());


        //Note: Follow POM Design Pattern

    }

}
