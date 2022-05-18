package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {


    //TC #5: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void dropdown_task5() {

        // to locate the dropdown and it is ready to use
        Select stateList = new Select(driver.findElement(By.cssSelector("select#state")));
        //3. Select Illinois

        stateList.selectByValue("IL");
        //4. Select Virginia
        stateList.selectByValue("VA");
        //5. Select California
        stateList.selectByValue("CA");

        //6. Verify final selected option is California.
        String expectedOptionText1 = "California";
        String expectedOptionText2 = "Illinois";
        String expectedOptionText3 = "Virginia";

        String actualOptionText = stateList.getFirstSelectedOption().getText();
        // en son CA seçili oldugu için sadece o true
        // bu method accual selected anlamına gelir


        Assert.assertEquals(actualOptionText, expectedOptionText1);
        //Assert.assertEquals(actualOptionText,expectedOptionText2);
        // Assert.assertEquals(actualOptionText,expectedOptionText3);

    }

    @Test
    public void dropdown_task6() {

        //3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
        //Select month using : value attribute
        //Select day using : index number

        yearDropdown.selectByVisibleText("1923");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertTrue(expectedYear.equals(actualYear));
        Assert.assertEquals(expectedMonth, actualMonth);
        Assert.assertEquals(expectedDay, actualDay);

    }


    //Use all Select options. (visible text, value, index)


}
