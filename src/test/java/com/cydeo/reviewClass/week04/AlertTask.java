package com.cydeo.reviewClass.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AlertTask {

    @Test
    public void alertTest(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/index.html");

        // Navigate "Laptop": call the utility method

        ReviewUtils.getLink(driver,"Laptop");

        ReviewUtils.getLink(driver,"Sony vaio i5");

        ReviewUtils.getLink(driver,"Add to cart");

        // After this stop I should see the alerts

        Alert alert=driver.switchTo().alert();
        alert.accept();


    }

}
