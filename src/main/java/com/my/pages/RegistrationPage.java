package com.my.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.my.creds.Profile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.webdriver;

public class RegistrationPage {

    public static final String URL = "http://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH,using = "//form/fieldset[1]/div/div/input")
    SelenideElement nameInput;

    @FindBy(how = How.XPATH,using = "//form/fieldset[2]/div/div/input")
    SelenideElement emailInput;

    @FindBy(how = How.CSS,using = "input[name=\"Пароль\"]")
    SelenideElement passwordInput;

    @FindBy(how = How.CSS, using = ".Auth_form__3qKeq > button")
    SelenideElement registrationButton;

    @FindBy(how = How.CSS, using = ".input__error ")
    SelenideElement invalidPassportText;

    public void fillNameInput(String name){
        nameInput.setValue(name);
    }

    public void fillEmailInput(String email){
        emailInput.setValue(email);
    }

    public void fillPasswordInput(String password){
        passwordInput.setValue(password);
    }

    public void registerNewUser(Profile profile){
        fillNameInput(profile.getName());
        fillEmailInput(profile.getEmail());
        fillPasswordInput(profile.getPassword());
        registrationButton.click();
    }

    public boolean isInvalidPassportTextDisplayed(){
        return invalidPassportText.isDisplayed();
    }

}
