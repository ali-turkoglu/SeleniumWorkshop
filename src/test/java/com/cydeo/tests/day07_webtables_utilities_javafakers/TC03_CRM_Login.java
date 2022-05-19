package com.cydeo.tests.day07_webtables_utilities_javafakers;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC03_CRM_Login {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        //TC #1: Window Handle practice
        //1. Create new test and make set ups

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void crm_login_test(){

        //TC #3: Login scenario
        //1. Create new test and make set ups
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com");

        //3. Enter valid username
        WebElement userInput= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userInput.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        //5. Click to `Log In` button
        WebElement passwordInput= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser"+ Keys.ENTER);



        //6. Verify title is as expected:
        //Expected: Portal
        String expectedTitle="Portal";

        BrowserUtils.verifyTitle(driver,expectedTitle);




        //USERNAME PASSWORD
        //helpdesk1@cybertekschool.com UserUser
        //Helpdesk2@cybertekschool.com UserUser
    }



}
