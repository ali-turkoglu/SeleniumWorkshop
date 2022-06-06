package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class T1_Registration_Form {

    public WebDriver driver;


    @Test
    public void window_handling_test() throws FileNotFoundException {


        //TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();

        //3. Enter first name
        WebElement firstNameInput = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstNameInput.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement lastNameInput = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastNameInput.sendKeys(faker.name().lastName());

        //5. Enter username
        String user=faker.name().username().replace(".","");
        WebElement userNameInput = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userNameInput.sendKeys(user);

        //6. Enter email address

        WebElement emailInput = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys(user+"@"+faker.bothify("??????.com"));

        //7. Enter password
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(faker.numerify("#########"));


        //8. Enter phone number
        WebElement phoneInput = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneInput.sendKeys(faker.bothify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement genderMaleButton=Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        genderMaleButton.click();

        //10.Enter date of birth
        WebElement dayOfBirth=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dayOfBirth.sendKeys("11/05/2000");

        //11.Select Department/Office
        Select departmentDropdown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));


        //12.Select Job Title
        Select job_titleDropdown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        job_titleDropdown.selectByIndex(faker.number().numberBetween(1,8));


        //13.Select programming language from checkboxes
        WebElement javaCheckbox=Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        javaCheckbox.click();


        //14.Click to sign up button
        WebElement signinButton=Driver.getDriver().findElement(By.cssSelector("button[type='submit']"));
        signinButton.click();

        //15.Verify success message “You’ve successfully completed registration.” is
        //displayed.

    }

}






//Note:
//1. Use new Driver utility class and method
//2. User JavaFaker when possible
//3. User ConfigurationReader when it makes sense