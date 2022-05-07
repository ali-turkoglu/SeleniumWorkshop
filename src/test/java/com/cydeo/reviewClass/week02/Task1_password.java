package com.cydeo.reviewClass.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1_password {

    public static void main(String[] args) {

       /* WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/");

        HandleWait.staticWait(1);

        WebElement forgotPasswordLink=driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();

        HandleWait.staticWait(1);

        WebElement emailBox=driver.findElement(By.name("email"));

        String expectedEmail="mike.smith@garbage.com";
        emailBox.sendKeys(expectedEmail);

        String actualEmail=emailBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        if (actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("PASS email verification ");
        }else{
            System.out.println("FAIL email verification ");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }

        driver.findElement(By.id("form_submit")).click();


        HandleWait.staticWait(3);
        driver.close();


    }
}
/*
Task 1:
 Verify confirmation message
        open chrome browser
        go to https://practice.cydeo.com/
        then click on "forgot_password" link
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'
 */