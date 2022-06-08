package com.cydeo.tests.day11_actions_jsexecuter_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_dragAndDrop_test {

    @Test
    public void dragDrop_test(){

        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        // Locate "Accept Cookies" button and click
        WebElement acceptCookiesButton=Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));

        //Locate the elements
        WebElement smallCircle=Driver.getDriver().findElement(By.cssSelector("div#draggable"));
        WebElement bigCircle=Driver.getDriver().findElement(By.cssSelector("div#droptarget"));

        //2. Drag and drop the small circle to bigger circle.
        Actions actions=new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,bigCircle).perform();  // or
        actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();



        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actualMessage=Driver.getDriver().findElement(By.xpath("//div[.=('You did great!')]")).getText();
        String expectedMessage="You did great!";

        Assert.assertEquals(expectedMessage,actualMessage);



    }
}
