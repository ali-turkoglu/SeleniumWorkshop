package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test(){

        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        WebElement chooseFileButton=Driver.getDriver().findElement(By.id("file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\alitu\\OneDrive\\Desktop\\test.txt");

        //3. Upload the file.
        WebElement uploadButton=Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement fileUploadedHeader=Driver.getDriver().findElement(By.tagName("h3"));
        String actualMessage=fileUploadedHeader.getText();
        String expectedMessage="File Uploaded!";


        //4. Assert:
        //-File uploaded text is displayed on the page
        Assert.assertEquals(expectedMessage,actualMessage);





    }


}
