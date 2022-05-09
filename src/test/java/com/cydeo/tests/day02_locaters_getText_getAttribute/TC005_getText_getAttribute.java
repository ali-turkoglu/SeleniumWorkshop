package com.cydeo.tests.day02_locaters_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC005_getText_getAttribute {

    public static void main(String[] args) {

        //TC #5: getText() and getAttribute() method practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        // Expected: Registration form
        WebElement formHeader=driver.findElement(By.className("page-header"));
        String actualHeader=formHeader.getText();
        String expectedHeader="Registration form";

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header text verification PASS");
        }else {
            System.out.println("Header text verification FAIL!");
        }

        //4- Locate “First name” input box
        WebElement firstNameBox=driver.findElement(By.name("firstname"));


        //5- Verify placeholder attribute’s value is as expected:
        //Expected: first name
        String actualPlaceHolder=firstNameBox.getAttribute("placeholder");
        String expectedPlaceHolder="first name";

        if (actualHeader.equals(expectedHeader)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL!");
        }

    }


}
