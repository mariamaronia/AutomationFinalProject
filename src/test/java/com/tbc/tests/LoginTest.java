package com.tbc.tests;

import com.tbc.BaseTest;
import com.tbc.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // Log4j Logger Import
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //ლოგერი
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void invalidLogin() {
        openLoginPage();
        logger.info("Navigating to the Login page");

        LoginPage loginPage = new LoginPage(driver);

        // Passing incorrect username and password
        loginPage.login("test1", "test1");
        logger.info("Attempted login with username: test1 and password: test1");

        // Checking the error message
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Incorrect username or password";

        // Asserting error message
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match!");
        logger.info("Error message verified successfully: " + actualErrorMessage);
    }
}