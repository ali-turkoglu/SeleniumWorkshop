package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        // 1- Setting up the web driver manager
        WebDriverManager.chromedriver().setup(); //  --> ilgili class'ı import et


        // 2- Create instance of the chrome driver obj.
        // Open empty browser
        WebDriver driver=new ChromeDriver();

        // 3- Test if driver is working as expected
        driver.get("https://www.google.com.tr");
    }
}
