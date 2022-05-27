package com.cydeo.reviewClass.week04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AutomationExercises {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.automationexercise.com/");

        WebElement testCaseButton=driver.findElement(By.xpath("//button[text()='Test Cases']"));
        System.out.println("testCaseButton.isDisplayed() = " + testCaseButton.isDisplayed());


        // Verify that home page is visible successfully : What they mean? --> Verify that you have Hope Page URL and Title, another option verify that test cases button is displayed
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        // verify Title
        Assert.assertEquals(actualTitle,expectedTitle,"Home Page is NOT displayed");

        WebElement testCases = driver.findElement(By.xpath("(//button[.='Test Cases'])[1]"));

        testCases.click();

        // Verify user is navigated to test cases page successfully
        //Verification with the text inside the webPage
        String expectedText = "Test Cases";
        String actualText = driver.findElement(By.xpath("//h2/b")).getText();
        Assert.assertEquals(actualText,expectedText,"Verify Page HAS Test Cases in it");
        // Better way: verify URL has test_cases in it
        Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"));

    }
}
