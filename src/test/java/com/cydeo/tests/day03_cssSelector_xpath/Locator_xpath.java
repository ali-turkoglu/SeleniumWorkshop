package com.cydeo.tests.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator_xpath {

    public static void main(String[] args) {

        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        WebElement loginBox=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        loginBox.sendKeys("incorrect entry");

        //4- Click to `Reset password` button
        WebElement resetButton=driver.findElement(By.xpath("//button[@class='login-btn']"));
        resetButton.click();

        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        WebElement errorText=driver.findElement(By.xpath("//div[@class='errortext']"));
        String expectedErrorText="Login or E-mail not found";
        String actualErrorText=errorText.getText();

        if (actualErrorText.equals(expectedErrorText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL!!");
            System.out.println("actualErrorText = " + actualErrorText);
            System.out.println("expectedErrorText = " + expectedErrorText);
        }

        //PS: Inspect and decide which locator you should be using to locate web elements.
        //        PS2: Pay attention to where to get the text of this button from
    }
}
