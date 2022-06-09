package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    // #1- initialize the driver instance and object of the class
    public LibraryLoginPage(){
      /*
      initElement method will create connection in between the current
         driver session (instance ) and the object of the current class.
         */
      PageFactory.initElements(Driver.getDriver(),this);

    }

    // #2- use @FindBy annotation to locate web elements

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUsername;


    @FindBy(xpath = "//label[text()='Password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//Button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[text()='This field is required.']")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[text()='Please enter a valid email address.']")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath = "//div[text()='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordMessage;


}
