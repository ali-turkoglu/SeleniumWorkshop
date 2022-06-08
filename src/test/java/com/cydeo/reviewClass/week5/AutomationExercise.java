package com.cydeo.reviewClass.week5;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AutomationExercise {

    @Test
    public void blueSearch(){

        Driver.getDriver().get("https://automationexercise.com");

        WebElement productLink=Driver.getDriver().findElement(By.xpath("//a[@href='/products']"));

        productLink.click();

        WebElement searchInputBox=Driver.getDriver().findElement(By.xpath("//input[@name=('search')]"));
        searchInputBox.sendKeys("blue");

        Driver.getDriver().findElement(By.id("submit_search")).click();

        //Driver.getDriver().findElement(By.xpath())


    }
}
