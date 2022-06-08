package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    // #1- initialize the driver instance and object of the class
    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
