package com.tbc.tests;

import com.tbc.BaseTest;
import com.tbc.pages.ContactListPage;
import com.tbc.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tbc.utils.RandomEmailGenerator;

public class SignUpTest extends BaseTest {

    @Test
    public void emailIsAlreadyExists() {
        openRegistrationPage();

        SignUpPage signUpPage = new SignUpPage(driver);

        // გადავცემ ისეთ იმეილს რომელიც უკვე არსებობს
        signUpPage.registration("test1", "test1", "test@gmail.com", "test123");

        String actualErrorMessage = signUpPage.signUpErrorMessage();
        String expectedErrorMessage = "Email address is already in use";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "არასწორი ერორი");

    }

    @Test
    public void emailChecking(){
        openRegistrationPage();

        SignUpPage signUpPage = new SignUpPage(driver);

        // გადავცემ ისეთ მეილს, რომელიც არ ჯდება ვალიდაციაში
        signUpPage.registration("f", "f", "f", "f");

        String actualErrorMessage = signUpPage.signUpErrorMessage();
        String expectedErrorMessage = "User validation failed: email: Email is invalid, password: Path `password` (`f`) is shorter than the minimum allowed length (7).";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "არასწორი ერორი");

    }

    @Test
    public void lastNameIsMissing(){
        openRegistrationPage();

        SignUpPage signUpPage = new SignUpPage(driver);

        // გადავცემ ყველა პარამეტრს გარდა გვარისა
        String randomEmail = RandomEmailGenerator.generateRandomEmail();
        signUpPage.registration("testiko", "", randomEmail, "test123");

        String actualErrorMessage = signUpPage.signUpErrorMessage();
        String expectedErrorMessage = "User validation failed: lastName: Path `lastName` is required.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "არასწორი ერორი");

    }

    @Test
    public void validRegistration(){
        openRegistrationPage();

        SignUpPage signUpPage = new SignUpPage(driver);

        // გადავცემ ყველა პარამეტრს სწორად და იუზერი რეგისტრირდება
        String randomEmail = RandomEmailGenerator.generateRandomEmail();
        signUpPage.registration("Test", "Testadze", randomEmail, "test123!");

        waitForUrlToBe("https://thinking-tester-contact-list.herokuapp.com/contactList");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://thinking-tester-contact-list.herokuapp.com/contactList";
        Assert.assertEquals(actualUrl, expectedUrl, "URL არასწორია");

        ContactListPage contactListPage = new ContactListPage(driver);
        String expectedButtonText = "Logout";
        String actualButtonText = contactListPage.getNewPageButtonText();

        Assert.assertEquals(actualButtonText, expectedButtonText, "ღილაკი ვერ მოიძებნა");

    }
}