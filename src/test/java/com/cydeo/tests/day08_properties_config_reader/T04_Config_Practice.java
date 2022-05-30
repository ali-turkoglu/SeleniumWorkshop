package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T04_Config_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        // we are getting the browserType dynamically from our configuration.properties file
        String browserType= ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String envAddress=ConfigurationReader.getProperty("env");
        driver.get(envAddress);
    }


    @Test
    public void google_search_test(){

        //3- Write “apple” in search box
        WebElement inputBox=driver.findElement(By.xpath("//input[@name='q']"));
        inputBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);


        //4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle=ConfigurationReader.getProperty("searchValue")+" - Google'da Ara";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }

}
