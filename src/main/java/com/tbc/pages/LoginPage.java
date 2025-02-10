package com.tbc.pages;

import com.tbc.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
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

    public  void login(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(usernameInput));


            usernameInput.sendKeys(username);
            passwordInput.sendKeys(password);
            loginClick.click();
            errorText.getText();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOf(errorText));
        return errorElement.getText().trim();
    }
}



