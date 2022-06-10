package com.cydeo.tests.day13_review;

import com.cydeo.pages.DynamicControls;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_Explicit_wait_test {

    @Test
    public void dynamicControl_test(){

        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

        DynamicControls dynamicControls=new DynamicControls();

        //3- Click to “Remove” button
        dynamicControls.removeButton.click();

        //4- Wait until “loading bar disappears”
       /* Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.invisibilityOf(dynamicControls.loadingBar));
*/
        BrowserUtils.waitForInvisibilityOf(dynamicControls.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        try {
            Assert.assertFalse(dynamicControls.checkbox.isDisplayed());
            Assert.assertTrue(!dynamicControls.checkbox.isDisplayed());

        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControls.textMessage.isDisplayed());
        Assert.assertEquals(dynamicControls.textMessage.getText(),"It's gone!");

        //System.out.println(dynamicControls.textMessage.getText());


    }

}
