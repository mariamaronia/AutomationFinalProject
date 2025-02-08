package com.tbc.pages;

import com.tbc.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactListPage extends BasePage {
    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    private By logOutClick = By.id("logout");



    public String getNewPageButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(logOutClick));
        return button.getText().trim();
    }

};
