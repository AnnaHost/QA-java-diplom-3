package com.my.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    public static final String URL = "http://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.CSS, using = "div > p > a")
    SelenideElement linkToLoginPage;

    public void goToLoginPageFromForgotPasswordPage() {
        linkToLoginPage.click();
    }

}
