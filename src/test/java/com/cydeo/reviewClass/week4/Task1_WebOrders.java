package com.cydeo.reviewClass.week4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1_WebOrders {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void webOrdersSignIn(){

        //1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        //2.    Login with-----Username: Tester, password: test
        WebElement userInputBox=driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        userInputBox.sendKeys("Tester");

        WebElement passwordInputBox=driver.findElement(By.xpath("//input[@type='password']"));
        passwordInputBox.sendKeys("test"+ Keys.ENTER);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //3.    Click on check all button verify all the checkboxes are checked
        WebElement checkAllButton=driver.findElement(By.linkText("Check All"));
        checkAllButton.click();
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement each : checkBoxes) {
            Assert.assertTrue(each.isSelected());

        }


        //4.    Click on uncheck all button verify that all the checkboxes are unchecked
        WebElement uncheckAllButton=driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnUncheckAll']"));
        uncheckAllButton.click();
        List<WebElement> uncheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement each : uncheckBoxes) {
            Assert.assertFalse(each.isSelected());

        }



    }

    @Test
    public void deletePersonTest() throws InterruptedException {
        //1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        //2.    Login with-----Username: Tester, password: test
        WebElement userInputBox=driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        userInputBox.sendKeys("Tester");

        WebElement passwordInputBox=driver.findElement(By.xpath("//input[@type='password']"));
        passwordInputBox.sendKeys("test"+ Keys.ENTER);


        System.out.println("Implementing step 3 and 4 of Test Case 2");
        String name = "Mark Smith";
    /*
    Locate the checkBox using the person's Name: Bob Feather
    find with name(child)--> go to parent (whole row) --> down to td of checkbox */
        //td[.='Bob Feather']/../td[1]/input
        //td[.='Bob Feather']/preceding-sibling::*/input
        String locatorOfCheckBoxWithName = "//td[.='"+name+"']/../td[1]/input";
       Thread.sleep(2000);
        WebElement checkBox = driver.findElement(By.xpath(locatorOfCheckBoxWithName));
        checkBox.click();  // select the checkbox with click()

        // locate delete button and click
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        // put some waiting time
        Thread.sleep(2000);
// After we delete, we can get all the names of the customers as a List, then verify that deleted name is NOT in the list
        // need to get all the names from the table
        // common locator : //tr//td[2]
        List<WebElement> namesElements = driver.findElements(By.xpath("//tr//td[2]"));
        for (WebElement namesElement : namesElements) {
            // verify each elements text that it does not contain deleted person
            Assert.assertFalse(namesElement.getText().contains(name));
        }

    }


}
