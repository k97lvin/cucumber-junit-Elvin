package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {
    @When("user enters librarian user name")
    public void user_enters_librarian_user_name() {
        System.out.println("user enter username");

    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("user enter password");

    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("user see dashboard");

    }


    @When("user enters student username")
    public void userEntersStudentUsername() {

    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
    }




}
