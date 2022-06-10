package com.cydeo.tests.day13_review;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.tests.day11_actions_jsexecuter_practice.ActionsPractices;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_doubleClick {

    @Test
    public void t1_doubleClick_test(){

        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        DoubleClickPage doubleClickPage=new DoubleClickPage();

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double click on the text “Double-click me to change my text color.”
        Actions actions=new Actions(Driver.getDriver());
        actions.doubleClick(doubleClickPage.textToDoubleClick).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        String actualValue=doubleClickPage.textToDoubleClick.getAttribute("style");
        String expectedValue="color: red;";

        Assert.assertEquals(expectedValue,actualValue);

        //
        //NOTE: FOLLOW POM



    }

}
