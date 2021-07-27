package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage extends BasePage{

    public ContactInfoPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//div[@class='pull-left']/h1")
    public WebElement fullName;

    @FindBy(xpath = "//a[@class='phone']")
    public WebElement phone;

    @FindBy(xpath = "  //a[@class='email']")
    public WebElement email;
}