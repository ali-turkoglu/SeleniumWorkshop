package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC001_YahooVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://yahoo.com");

        String currentTitle=driver.getTitle();
        System.out.println("title = " + currentTitle);


        String expectedTitle="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        boolean result=expectedTitle.equals(currentTitle);
        System.out.println((result)?"Title is as expected. Verification PASSED!":"Title is NOT as expected. Verification FAILED! ");

        Thread.sleep(3000);

        driver.close();

    }
}
