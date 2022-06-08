package com.cydeo.tests.day11_actions_jsexecuter_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_JSExecutor_test {

    @Test
    public void task7_scroll_test(){

        //TC #7: Scroll using JavascriptExecutor
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink=Driver.getDriver().findElement(By.linkText("Home"));

        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();


        //3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);

        //4- Scroll up to “Home” link
        js.executeScript("arguments[1].scrollIntoView(true)",cydeoLink,homeLink);


        //5- Use below provided JS method only
        //JavaScript method to use :
        //Note: You need to locate the links as web elements and pass them as
        //arguments into executeScript() method

    }
}
