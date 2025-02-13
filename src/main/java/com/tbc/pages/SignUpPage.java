package com.tbc.pages;

import com.tbc.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "submit")
    WebElement clickButton;

    @FindBy(id = "error")
    WebElement errorMessage;

    public void registration(String firstName, String lastName, String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstNameField));

        sendKeysToElement(firstNameField, firstName);
        sendKeysToElement(lastNameField, lastName);
        sendKeysToElement(emailField, email);
        sendKeysToElement(passwordField, password);
        clickOnElement(clickButton);
    }

    public String signUpErrorMessage() {
        return getElementText(errorMessage).trim();
    }
}
