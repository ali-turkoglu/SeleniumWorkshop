package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators_cssSelector {
    public static void main(String[] args) {

        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        WebElement loginButton=driver.findElement(By.cssSelector("input.login-btn"));
        String expectedLoginButtonText="Log In";
        String actualLoginButtonText=loginButton.getAttribute("value");

        if (actualLoginButtonText.equals(expectedLoginButtonText)){
            System.out.println("Login button verification PASS");
        }else{
            System.out.println("Login button verification FAIL");
            System.out.println("actualLoginButtonText = " + actualLoginButtonText);
            System.out.println("expectedLoginButtonText = " + expectedLoginButtonText);

        }

        driver.close();

        //PS: Inspect and decide which locator you should be using to locate web  elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}
