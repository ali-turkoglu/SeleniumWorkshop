package com.cydeo.tests.day02_locaters_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC001_CydeoVerifications {

    public static void main(String[] args) {

        // 1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");

        // 3. Verify URL contains
        // Expected: cydeo
        String expectedURL="cydeo";
        String currentURL=driver.getCurrentUrl();

        if (currentURL.contains(expectedURL)){
            System.out.println("URL verification PASSED!");
        }else{
            System.out.println("URL verification FAILED!");
        }

        // 4. Verify title:
        //  Expected: Practice
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verificaton PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }

        driver.close();





    }
}


