package com.my.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    public static final String URL = "http://stellarburgers.nomoreparties.site/";

    @FindBy (how = How.CSS, using = ".AppHeader_header__logo__2D0X2 ~ .AppHeader_header__link__3D_hX ")
    SelenideElement linkToLoginPageFromHeader;

    @FindBy(how = How.CSS,using = ".BurgerConstructor_basket__totalContainer__2Z-ho ~ button")
    SelenideElement linkToLoginPageButton;

    @FindBy(how = How.CSS,using = ".AppHeader_header__logo__2D0X2 ~ a")
    SelenideElement linkToProfilePage;

    @FindBy (how = How.CSS,using = ".BurgerConstructor_basket__totalContainer__2Z-ho ~ button")
    SelenideElement createOrderButton;

    @FindBy (how = How.CSS,using = ".BurgerIngredients_ingredients__1N8v2 h1")
    SelenideElement constructorLabel;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__1N8v2 .tab_tab__1SPyG:nth-child(1n)")
    SelenideElement bunsTab;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo  > .text:nth-child(1)")
    SelenideElement bunsTitle;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__1N8v2 .tab_tab__1SPyG:nth-child(2n)")
    SelenideElement saucesTab;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo  > .text:nth-child(3)")
    SelenideElement saucesTitle;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__1N8v2 .tab_tab__1SPyG:nth-child(3n)")
    SelenideElement fillingsTab;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo  > .text:nth-child(5)")
    SelenideElement fillingsTitle;

    public void  goToLoginPageUsingButtonFromHeader(){
        linkToLoginPageFromHeader.click();
    }

    public void  goToLoginPageUsingCentralButton(){
        linkToLoginPageButton.click();
    }

    public void  goToProfilePage(){
        linkToProfilePage.click();
    }

    public void isUserAuthorised(){
        createOrderButton.shouldHave(Condition.text("Оформить заказ"));
    }

    public void goToBunsTab(){
        bunsTab.click();
    }

    public void isBunsTabOpen(){
        bunsTitle.shouldBe(visible);
    }

    public void goToSaucesTab(){
        saucesTab.click();
    }

    public void isSaucesTabOpen(){
        saucesTitle.shouldBe(visible);
    }

    public void goToFillingsTab(){
        fillingsTab.click();
    }

    public void isFillingsTabOpen(){
        fillingsTitle.shouldBe(visible);
    }

    public void isConstructorBlockVisible(){
        constructorLabel.shouldBe(visible);
    }
}
