package com.weborders.tests.functional_tests.login;

import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.weborders.utilities.ApplicationConstants.LOGIN_ERROR_MESSAGE;
import static org.testng.Assert.assertEquals;

public class ErrorMessageValidationTest extends TestBase {

    @Test (groups = {"regression", "smoke"})
    public void wrongEmailTest() {
        extentLogger = report.createTest("Wrong email test");
        extentLogger.info("Entering login information");
        pages.login().login("admin", "test");

        String actualError = pages.login().errorMessage.getText();
        extentLogger.info("Verifying error message");
        assertEquals(actualError, LOGIN_ERROR_MESSAGE);
        extentLogger .pass("Passed:Wrong email test");

    }

    @Test (groups = "regression")
    public void wrongPasswordTest() {
        extentLogger = report.createTest("Wrong password test");
        extentLogger.info("Entering login information");
        pages.login().login(ConfigurationReader.getProperty("username"), "wrong password");

        String actualError = pages.login().errorMessage.getText();
        extentLogger.info("Verifying error message");
        assertEquals(actualError, LOGIN_ERROR_MESSAGE);
        extentLogger .pass("Passed:Wrong password test");
// Feyaz Khan Changed 
        
    }

    @Test
    public void blankUsername() {
        extentLogger = report.createTest("Blank username test");
        extentLogger.info("Entering login information");
        pages.login().password.sendKeys("wrong password");
        pages.login().loginButton.click();

        String actualError = pages.login().errorMessage.getText();
        extentLogger.info("Verifying error message");
        assertEquals(actualError, LOGIN_ERROR_MESSAGE);
        extentLogger .pass("Passed:Blank username test");

    }

    @Test
    public void blankPassword() {
        extentLogger = report.createTest("Blank password test");
        extentLogger.info("Entering login information");
        pages.login().username.sendKeys(ConfigurationReader.getProperty("username"));
        pages.login().loginButton.click();

        String actualError = pages.login().errorMessage.getText();
        extentLogger.info("Verifying error message");
        assertEquals(actualError, LOGIN_ERROR_MESSAGE);
        extentLogger .pass("Passed:Blank password test");
    }

}
