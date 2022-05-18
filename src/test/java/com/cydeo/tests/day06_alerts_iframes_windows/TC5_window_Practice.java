package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC5_window_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

//TC #5: Window Handle practice
        //1. Create a new class called: T5_WindowsPractice
        //2. Create new test and make set ups
        //3. Go to : https://practice.cydeo.com/windows
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void multiple_window_test() {

        // Storing the main page's window handle as string is
        // good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        //4. Assert: Title is “Windows”

        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        System.out.println("Title before click: " + actualTitle);

        //5. Click to: “Click Here” link
        WebElement linkText = driver.findElement(By.linkText("Click Here"));
        linkText.click();

        System.out.println("Title after click: " + driver.getTitle());

        //6. Switch to new Window.
        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        String actualTitleAfterClick = driver.getTitle();
        Assert.assertTrue(actualTitleAfterClick.equals(expectedTitleAfterClick));

        //if we want to go back to main page we can use already stored main handle
        driver.switchTo().window(mainHandle);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
