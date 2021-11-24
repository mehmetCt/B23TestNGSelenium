package com.cydeo.pages;

import com.cydeo.utils.ConfigReader;
import com.cydeo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement warningMessage;


    public void login(){
        usernameBox.sendKeys(ConfigReader.read("username"));
        passwordBox.sendKeys(ConfigReader.read("password"));
        loginButton.click();
    }

    public void login(String username,String password){

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }




}
