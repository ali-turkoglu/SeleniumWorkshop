package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators_getText_getAttribute {
    public static void main(String[] args) {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberBox=driver.findElement(By.className("login-item-checkbox-label"));
        String expectedLabelText="Remember me on this computer";
        String actualLabelText=driver.findElement(By.className("login-item-checkbox-label")).getText();

        if (actualLabelText.equals(expectedLabelText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL!!");
        }


        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgetPasswordLink=driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgetPasswordText="Forgot your password?";
        String actualForgetPasswordText=forgetPasswordLink.getText();

        if (actualLabelText.equals(expectedLabelText)){
            System.out.println("PASS!!");
        }else {
            System.out.println("FAIL!!");
        }


        // 5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedInHref="forgot_password=yes";
        String actualInHref=forgetPasswordLink.getAttribute("href");

        if (actualInHref.contains(expectedInHref)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL!!");
            System.out.println("actualInHref = " + actualInHref);
            System.out.println("expectedInHref = " + expectedInHref);
        }

        //PS: Inspect and decide which locator you should be using to locate web elements.

    }
}
