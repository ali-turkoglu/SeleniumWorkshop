package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_alert_Practices {

    WebDriver driver;
    @BeforeMethod
    public void setup() {
        //TC #1: Information alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_test1(){

        //3. Click to “Click for JS Alert” button
        WebElement jsAlertButton=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertButton.click();

        // To click the pop up menu button we need to switch driver's focus to Alert itself
        Alert alert=driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed
        WebElement alertClickMessage=driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));

       // String accualMessage=driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']")).getText();
       // String expectedMessage="You successfully clicked an alert";
       // Assert.assertTrue(accualMessage.equals(expectedMessage));

        Assert.assertTrue(alertClickMessage.isDisplayed());
    }

    @Test
    public void alert_test2(){

        //3. Click to “Click for JS Confirm” button
        WebElement JSConfirmButton=driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        JSConfirmButton.click();

        //4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultMessageElement=driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
        String actualMessage=driver.findElement(By.xpath("//p[.='You clicked: Ok']")).getText();
        String expectedMessage="You clicked: Ok";

        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
