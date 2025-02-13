package com.tbc.tests;

import com.tbc.BaseTest;
import com.tbc.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void invalidLogin() {
        openLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        // გადაეცა არასწორი იუზერინეიმი და პაროლი
        loginPage.login("test1", "test1");

        // ერორის შემოწმება
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Incorrect username or password";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match!");
    }
}