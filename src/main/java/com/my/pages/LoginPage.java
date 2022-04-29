package com.my.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.my.creds.Profile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String URL = "http://stellarburgers.nomoreparties.site/login";

    @FindBy (how = How.CSS,using = ".Auth_login__3hAey > h2")
    SelenideElement loginHeader;

    @FindBy (how = How.CSS, using = "[name=\"name\"]")
    SelenideElement emailInput;

    @FindBy (how = How.CSS, using = "[name=\"Пароль\"]")
    SelenideElement passwordInput;

    @FindBy (how = How.CSS,using = ".Auth_fieldset__1QzWN  ~ .button_button__33qZ0 ")
    SelenideElement loginButton;


    public void isLoginPage(){
        loginHeader.shouldHave(Condition.text("Вход"));
    }

    public void login(Profile profile){
        fillLoginInput(profile.getEmail());
        fillPasswordInput(profile.getPassword());
        loginButton.click();
    }

    public void fillLoginInput(String name){
        emailInput.setValue(name);
    }

    public void fillPasswordInput(String password){
        passwordInput.setValue(password);
    }


}
