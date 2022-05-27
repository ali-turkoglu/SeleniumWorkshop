package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTablesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T01_WebTable_Order_Verify {


    WebDriver driver;

    @BeforeMethod
    public void setup() {

        //TC #1: Web table practice
        //1. Go to: https://practice.cydeo.com/web-tables

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }


    @Test
    public void order_name_verify_test() {

        WebElement bobMartinCell = driver.findElement(By.xpath("//table[@class='SampleTable']//tr//td[.='Bob Martin']"));

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”

        String expectedName="Bob Martin";
        String accualName=bobMartinCell.getText();

       /* if (expectedName.equals(accualName)){
            System.out.println("Pass!");
        }else {
            System.out.println("Fail!!!");
        }*/
        Assert.assertEquals(expectedName,accualName);


        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        String expectedOrderDate="";
        String accualOrderDate=driver.findElement(By.xpath("//table[@class='SampleTable']//tr//td[.='Bob Martin']/following-sibling::td[3]")).getText();

        Assert.assertEquals(expectedName,accualName);

    }


    @Test
    public void test2(){

        String actualOrderDate=WebTablesUtils.returnOrderDate(driver,"Samuel Jackson");

        System.out.println(actualOrderDate);

        String expectedOrderDate="12/21/2021";

        WebTablesUtils.orderVerify(driver,"Samuel Jackson",expectedOrderDate);

    }



}
