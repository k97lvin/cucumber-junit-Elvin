package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.pages.BasePage;
import com.pages.OrderPage;
import com.pages.ViewAllOrdersPage;
import com.pages.WebTableLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinition {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

    @Given("user is already logged in and on order page")
    public void userIsAlreadyLoggedInAndOnOrderPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webtableUrl"));
        webTableLoginPage.login();
        basePage.order.click();
    }

    @When("user selects product type {string}")
    public void userSelectsProductType(String arg0) {
        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(arg0);
    }

    //    @And("user enters quantity {int}")
//    public void userEntersQuantity(int arg0) {
//    }
    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {
        //orderPage.inputQuantity.clear();

        orderPage.inputQuantity.sendKeys(arg0 +"");
//orderPage.inputQuantity.sendKeys(String.valueOf(arg0));
    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String arg0) {
        orderPage.inputName.sendKeys(arg0);
    }

    @And("user enters street {string}")
    public void userEntersStreet(String arg0) {
        orderPage.inputStreet.sendKeys(arg0);
    }

    @And("user enters city {string}")
    public void userEntersCity(String arg0) {
        orderPage.inputCity.sendKeys(arg0);
    }

    @And("user enters state {string}")
    public void userEntersState(String arg0) {
        orderPage.inputState.sendKeys(arg0);
    }

    @And("user enters zipcode {string}")
    public void userEntersZipcode(String arg0) {
        orderPage.inputZip.sendKeys(arg0);
    }

    @And("user selects credit card type {string}")
    public void userSelectsCreditCardType(String exceptedCardType) {
//        List<WebElement> cardTypes = orderPage.cardType;
//        for (WebElement cardType : cardTypes) {
//            if (cardType.getAttribute("value").equalsIgnoreCase(exceptedCardType)) {
//
//                cardType.click();
//            }
//        }
        BrowserUtils.clickRadioButton(orderPage.cardType, exceptedCardType);
    }

    @And("user enters credit card number {string}")
    public void userEntersCreditCardNumber(String arg0) {
        orderPage.cardNoInput.sendKeys(arg0);
    }

    @And("user enters expiry date {string}")
    public void userEntersExpiryDate(String arg0) {
        orderPage.cardExpInput.sendKeys(arg0);
    }

    @And("user enters process order button")
    public void userEntersProcessOrderButton() {
        orderPage.processOrderBtn.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void userShouldSeeInFirstRowOfTheWebTable(String arg0) {
        Assert.assertEquals(viewAllOrdersPage.nameCustomerCell.getText(),arg0);
    }


}
