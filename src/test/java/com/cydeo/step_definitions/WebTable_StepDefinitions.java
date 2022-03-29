package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.pages.WebTableLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTable_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("user is on he login page of web table app")
    public void user_is_on_he_login_page_of_web_table_app() {
        String url = ConfigurationReader.getProperty("webtableUrl");
        Driver.getDriver().get(url);
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTableLoginPage.inputUsername.sendKeys(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTableLoginPage.inputPassword.sendKeys(string);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        webTableLoginPage.loginButton.click();
    }

    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyTitleContains("order");
    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String userName, String password) {
        webTableLoginPage.inputUsername.sendKeys(userName);
        webTableLoginPage.inputPassword.sendKeys(password);
        webTableLoginPage.loginButton.click();

    }
}
