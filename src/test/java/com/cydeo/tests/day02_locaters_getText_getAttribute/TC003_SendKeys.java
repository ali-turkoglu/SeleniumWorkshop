package com.cydeo.tests.day02_locaters_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC003_SendKeys {

    public static void main(String[] args) throws InterruptedException {


        //TC#3: Google search
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Write “apple” in search box
        //4- Press ENTER using Keys.ENTER

        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("apple"+ Keys.ENTER);

        // 5- Verify title:
        // Expected: Title should start with “apple” word
        String  expectedTitle="apple";
        String actualTitle=driver.getTitle();

        if (actualTitle.startsWith(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        Thread.sleep(3000);

        driver.close();


    }
}
