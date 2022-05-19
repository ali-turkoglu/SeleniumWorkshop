package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {


    // This method will login with helpdesk1@cybertekschool.com when user calls
    public static void crm_login(WebDriver driver){

        //3. Enter valid username
        WebElement userInput= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userInput.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        //5. Click to `Log In` button
        WebElement passwordInput= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser"+ Keys.ENTER);
    }

    // It is overload method
    public static void crm_login(WebDriver driver,String userName,String password){

        //3. Enter valid username
        WebElement userInput= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userInput.sendKeys(userName);

        //4. Enter valid password
        //5. Click to `Log In` button
        WebElement passwordInput= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys(password+ Keys.ENTER);
    }
}
