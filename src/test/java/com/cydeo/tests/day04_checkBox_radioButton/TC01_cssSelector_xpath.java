package com.cydeo.tests.day04_checkBox_radioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01_cssSelector_xpath {

    public static void main(String[] args) {


        //XPATH and CSS Selector PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

       // 3. Locate all the WebElements on the page using XPATH and/or CSS
       // locator only (total of 6)
        //a. “Home” link
        WebElement homeLink1=driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink2=driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homeLink3=driver.findElement(By.cssSelector("a[href='/']"));
        WebElement homeLink4=driver.findElement(By.xpath("//a[.='Home']"));

        //b. “Forgot password” header
        WebElement forgotPasswordText1=driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement forgotPasswordText2=driver.findElement(By.cssSelector("div[class='example']>h2"));
        WebElement forgotPasswordText3=driver.findElement(By.cssSelector("div.example > h2"));
        WebElement forgotPasswordText4=driver.findElement(By.xpath("//div[@class='example']/h2"));

        //c. “E-mail” text
        WebElement emailText=driver.findElement(By.cssSelector("label[for='email']"));
        WebElement emailText1=driver.findElement(By.xpath("//label[@for='email']"));
        WebElement emailText3=driver.findElement(By.xpath("//label[text()='E-mail']"));
        WebElement emailText4=driver.findElement(By.xpath("//label[.='E-mail']"));


        //d. E-mail input box
        //WebElement emailTextInputBox1=driver.findElement(By.name("input[name='email']"));
        WebElement emailTextInputBox2=driver.findElement(By.cssSelector("input[type='text']"));
        WebElement emailTextInputBox3=driver.findElement(By.xpath("//input[@type='text']"));
        WebElement emailTextInputBox4=driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/input"));
        WebElement emailTextInputBox5=driver.findElement(By.xpath("//input[contains(@pattern,'[a-z0-')]"));


        //e. “Retrieve password” button
        WebElement retrievePasswordButton1=driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement retrievePasswordButton2=driver.findElement(By.xpath("//button[contains(@id,'form_submit')]"));
        WebElement retrievePasswordButton5=driver.findElement(By.xpath("//button[@type='submit']"));
        WebElement retrievePasswordButton3=driver.findElement(By.cssSelector("button.radius"));
        WebElement retrievePasswordButton4=driver.findElement(By.cssSelector("button[class='radius']"));

        //f. “Powered by Cydeo text
        WebElement cydeoText=driver.findElement(By.xpath("//div[text()='Powered by ']"));
        WebElement cydeoText2=driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        WebElement cydeoText3=driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        WebElement cydeoText4=driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("forgotPasswordText1.isDisplayed() = " + forgotPasswordText1.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("emailTextInputBox2.isDisplayed() = " + emailTextInputBox2.isDisplayed());
        System.out.println("retrievePasswordButton1.isDisplayed() = " + retrievePasswordButton1.isDisplayed());
        System.out.println("cydeoText.isDisplayed() = " + cydeoText.isDisplayed());


        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible
        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible




    }


}
