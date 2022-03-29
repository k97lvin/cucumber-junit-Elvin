package com.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    public WebTableLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement inputUsername;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    public void login() {
        this.inputUsername.sendKeys("Test");
        this.inputPassword.sendKeys("Tester");
        this.loginButton.click();
    }

    public void login(String username, String password) {
        inputPassword.sendKeys(password);
        inputUsername.sendKeys(username);
        loginButton.click();
    }
    public void loginWithConfig() {
     inputUsername.sendKeys(ConfigurationReader.getProperty("webtableUrl"));
     inputPassword.sendKeys(ConfigurationReader.getProperty("webtableUrl"));
     loginButton.click();
    }





}
