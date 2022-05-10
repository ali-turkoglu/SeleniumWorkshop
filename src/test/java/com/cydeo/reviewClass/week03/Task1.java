package com.cydeo.reviewClass.week03;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://todomvc.com/");

        WebElement JSElement=driver.findElement(By.xpath("//div[.='JavaScript']"));
        JSElement.click();


        WebElement Polimer=driver.findElement(By.linkText("Polymer"));
        Polimer.click();

        HandleWait.staticWait(2);
        String toDoItem="This Todo is added";
        WebElement todoBox=driver.findElement(By.id("new-todo"));
        todoBox.sendKeys(toDoItem+ Keys.ENTER);

        String locator="//label[.='"+toDoItem+"']";
        WebElement customToDoItem=driver.findElement(By.xpath(locator));

        if (customToDoItem.isDisplayed()){
            System.out.println("We added our toDo item successfully");
        }

        driver.close(); // driver.quit() --> to close all opened windows

    }
}
/*
    Here is this week's task:
Write a basic browser automation framework to validate a Polymer website.
The focus should be on the interaction with the browser.
The Web Application under test http://todomvc.com/
    The first step should be to load the website,
    click within the JavaScript tab,
    and select the Polymer link.
    The second step should be: Add one Todo item
    Then Verify that the item added.
     */