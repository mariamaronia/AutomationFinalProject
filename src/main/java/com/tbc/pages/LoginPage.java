package com.tbc.pages;

import com.tbc.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "submit")
    WebElement loginClick;

    @FindBy(id = "error")
    WebElement errorText;

    // ლოგინის მეთოდი BasePage მეთოდების გამოყენებით
    public void login(String username, String password) {
        sendKeysToElement(usernameInput, username); // BasePage მეთოდი
        sendKeysToElement(passwordInput, password); // BasePage მეთოდი
        clickOnElement(loginClick);                 // BasePage მეთოდი
    }

    // შეცდომის მესიჯის მიღება
    public String getErrorMessage() {
        return getElementText(errorText); // BasePage მეთოდი ტექსტის მისაღებად
    }
}