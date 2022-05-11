package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators_getText {

    public static void main(String[] args) {


        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        WebElement InputBox=driver.findElement(By.name("USER_LOGIN"));
        InputBox.sendKeys("incorrect");


        //4- Enter incorrect password: “incorrect”
        WebElement PasswordBox=driver.findElement(By.name("USER_PASSWORD"));
        PasswordBox.sendKeys("incorrect");

        //5- Click to login button.
        WebElement logInButton=driver.findElement(By.className("login-btn"));
        logInButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        String expectedErrorMessage="Incorrect login or password";
        String actualErrorMessage=driver.findElement(By.className("errortext")).getText();

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error Message verification PASS!!");
        }else {
            System.out.println("Error message verification FAIL!!");
        }

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
    }

}
