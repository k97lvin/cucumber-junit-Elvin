package com.cydeo.step_definitions;

/*
In the class we will be able to pass pre- & post- conditions to
 each scenario and each step
 */

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 1)
    public void setupScenario() {
        System.out.println("===Setting up browser using cucumber @Before ");
    }

    @After
    public void teardownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        //    System.out.println("===Closing browser using cucumber @After ");
        //  System.out.println("===Take screenshot if scenario ended ");
    }

    @BeforeStep(order = 2)
    public void setupStep() {
        System.out.println("_____________applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("____________> applying teardown using @AfterStep");
    }


}
