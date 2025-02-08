package com.tbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;


    // URLs
    protected static final String BASE_URL = "https://thinking-tester-contact-list.herokuapp.com";
    protected static final String LOGIN_URL = BASE_URL + "/login";
    protected static final String REGISTRATION_URL = BASE_URL + "/addUser";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    protected void openLoginPage() {
        driver.get(LOGIN_URL);
    }

    protected void openRegistrationPage() {
        driver.get(REGISTRATION_URL);
    }

    public void waitForUrlToBe(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}