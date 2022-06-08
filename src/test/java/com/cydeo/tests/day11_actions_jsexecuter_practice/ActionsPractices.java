package com.cydeo.tests.day11_actions_jsexecuter_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void task4_task5_test(){

        //TC #4: Scroll practice
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        Actions actions=new Actions(Driver.getDriver());

        //4- Scroll using Actions class “moveTo(element)” method
        WebElement cydeoLinkButton=Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.moveToElement(cydeoLinkButton).perform();


        // To see
        BrowserUtils.sleep(3);
        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        WebElement homeButton=Driver.getDriver().findElement(By.linkText("Home"));
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

    }
}
