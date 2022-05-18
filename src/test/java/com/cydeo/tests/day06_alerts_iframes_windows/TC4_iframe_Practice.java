package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_iframe_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setup() {

        //TC #4: Iframe practice
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make set ups
        //3. Go to: https://practice.cydeo.com/iframe
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/iframe");
    }


    @Test
    public void iframePractice(){



        // option #1- switching to iframe using id attribute value
        driver.switchTo().frame("mce_0_ifr");

        // option #2- switching to iframe using index number
        driver.switchTo().frame(1);

        // option #3- switching to iframe using web element
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.tox-edit-area__iframe")));

        //4. Assert: “Your content goes here.” Text is displayed.
        // locate the p tag
        WebElement yourContentGoesHereText=driver.findElement(By.xpath("//p"));

        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        // To be able to verify the header, we must switch back to "main html"
        driver.switchTo().parentFrame();

        WebElement headerText=driver.findElement(By.xpath("//h3"));

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        Assert.assertTrue(headerText.isDisplayed());

    }

}
