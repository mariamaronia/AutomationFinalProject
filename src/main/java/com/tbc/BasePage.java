package com.tbc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // დალოდება სანამ ელემენტი გახდება ხილვადი
    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ელემენტებისთვის ტექსტების გადაცემა
    protected void sendKeysToElement(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.sendKeys(text);
    }

    // ელემენტზე ქლიქი
    protected void clickOnElement(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        element.click();
    }

    // ელემენტის ტექსტის დაბრუნება
    protected String getElementText(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getText();
    }

    // URL-ის გადამოწმება
    protected void waitForUrlToBe(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    // ელემენტის ატრიბუტის მნიშვნელობის გადამოწმება
    protected String getElementAttribute(By locator, String attribute) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getAttribute(attribute);
    }
}