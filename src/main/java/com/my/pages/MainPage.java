package com.my.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    public static final String URL = "http://stellarburgers.nomoreparties.site/";

    @FindBy (how = How.CSS, using = ".AppHeader_header__logo__2D0X2 ~ .AppHeader_header__link__3D_hX ")
    SelenideElement linkToLoginPage;


    public void  goToLoginPageUsingButtonFromHeader(){
        linkToLoginPage.click();
    }
}
