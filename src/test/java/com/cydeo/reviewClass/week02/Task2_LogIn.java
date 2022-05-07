package com.cydeo.reviewClass.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2_LogIn {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String expectedTitle="Web Orders Login";
        if (expectedTitle.equals(driver.getTitle())){
            System.out.println("success");
        }else {
            System.exit(-1);
        }
        WebElement userNameBox=driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement userPasswordBox=driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement signInButton=driver.findElement(By.id("ctl00_MainContent_login_button"));

        userNameBox.sendKeys("Tester");
        userPasswordBox.sendKeys("test");
        signInButton.click();

        String expectedHomePageTitle="Web Orders";
        if (expectedHomePageTitle.equals(driver.getTitle())){
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.exit(-1);
        }

        HandleWait.staticWait(2);
        driver.close();

    }

}
/*
Basic login authentication
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Verify title equals: String expectedTitle = "Web Orders Login"
- Enter username: Tester
- Enter password: test
- Click “Sign In” button
- Verify title equals: String expectedHomePageTitle = "Web Orders"
 */