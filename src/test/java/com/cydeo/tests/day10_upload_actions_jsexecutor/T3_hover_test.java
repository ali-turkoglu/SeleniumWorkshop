package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_hover_test {

    @Test
    public void hovering_test(){

        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

       // Locate all images under here
        WebElement firstImage=Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement secondImage=Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement thirdImage=Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        // Locate all the user text under here
        WebElement user1=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        Actions actions=new Actions(Driver.getDriver());

        //2. Hover over to first image
        actions.moveToElement(firstImage).perform();
        BrowserUtils.sleep(3);
        actions.moveToElement(user1).perform();
        BrowserUtils.sleep(3);

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(firstImage.isDisplayed());


        //b. “view profile” is displayed

        //4. Hover over to second image
        //5. Assert:
        //a. “name: user2” is displayed
        //b. “view profile” is displayed
        //6. Hover over to third image
        //7. Confirm:
        //a. “name: user3” is displayed
        //b. “view profile” is displayed



    }
}
