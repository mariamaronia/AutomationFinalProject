package com.tbc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    // დალოდება სანამ ელემენტი გახდება ხილვადი
    protected WebElement waitForElementToBeVisible(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    // ელემენტებისთვის ტექსტების გადაცემა
    protected void sendKeysToElement(WebElement locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.sendKeys(text);
    }

    // ელემენტზე ქლიქი
    protected void clickOnElement(WebElement locator) {
        WebElement element = waitForElementToBeVisible(locator);
        element.click();
    }

    // ელემენტის ტექსტის დაბრუნება
    protected String getElementText(WebElement locator) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getText();
    }
};