package com.my.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    @FindBy(how = How.CSS, using = ".Account_listItem__35dAP button")
    SelenideElement signOutButton;

    @FindBy(how = How.CSS, using = ".AppHeader_header__logo__2D0X2")
    SelenideElement logoButton;

    @FindBy(how = How.CSS, using = ".AppHeader_header__list__3oKJj li:nth-child(1)")
    SelenideElement constructorButton;


    public void isProfilePage() {
        signOutButton.shouldHave(Condition.text("Выход"));
    }

    public void logout() {
        signOutButton.click();
    }

    public void goToConstructorPageUsingLogo() {
        logoButton.click();
    }

    public void goToConstructorPageUsingConstructorButton() {
        constructorButton.click();
    }
}
