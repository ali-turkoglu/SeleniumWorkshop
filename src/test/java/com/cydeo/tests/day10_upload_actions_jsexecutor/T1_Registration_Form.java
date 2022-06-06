package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class T1_Registration_Form {

   public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void window_handling_test() throws FileNotFoundException {

        Properties properties=new Properties();
        FileInputStream stream=new FileInputStream("configuration.properties");

        driver.get(ConfigurationReader.getProperty("env"));





    }



}
//TC#1: Registration form confirmation
//Note: Use JavaFaker OR read from configuration.properties file when possible.
//1. Open browser
//2. Go to website: https://practice.cydeo.com/registration_form
//3. Enter first name
//4. Enter last name
//5. Enter username
//6. Enter email address
//7. Enter password
//8. Enter phone number
//9. Select a gender from radio buttons
//10.Enter date of birth
//11.Select Department/Office
//12.Select Job Title
//13.Select programming language from checkboxes
//14.Click to sign up button
//15.Verify success message “You’ve successfully completed registration.” is
//displayed.
//Note:
//1. Use new Driver utility class and method
//2. User JavaFaker when possible
//3. User ConfigurationReader when it makes sense