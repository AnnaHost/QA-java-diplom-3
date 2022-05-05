import com.codeborne.selenide.Selenide;
import com.my.creds.Profile;
import com.my.creds.ProfileDataGenerator;
import com.my.pages.LoginPage;
import com.my.pages.MainPage;
import com.my.pages.ProfilePage;
import com.my.pages.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorTest {

    Profile profile;

    @Before
    public void setUp() {
        profile = ProfileDataGenerator.getRandom();
        RegistrationPage registrationPage = open(RegistrationPage.URL, RegistrationPage.class);
        registrationPage.registerNewUser(profile);
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор» на страницу с конструктором")
    public void goToMainPageUsingConstructorButton() {
        LoginPage loginPage = open(LoginPage.URL, LoginPage.class);
        loginPage.login(profile);
        MainPage mainPage = page(MainPage.class);
        mainPage.goToProfilePage();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.goToConstructorPageUsingConstructorButton();

        mainPage = page(MainPage.class);
        mainPage.isConstructorBlockVisible();
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers на страницу с конструктором")
    public void goToMainPageUsingLogoButton() {
        LoginPage loginPage = open(LoginPage.URL, LoginPage.class);
        loginPage.login(profile);
        MainPage mainPage = page(MainPage.class);
        mainPage.goToProfilePage();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.goToConstructorPageUsingLogo();

        mainPage = page(MainPage.class);
        mainPage.isConstructorBlockVisible();
    }


    @Test
    @DisplayName("Переход в раздел «Соусы»")
    public void switchToSauces() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);

        mainPage.goToSaucesTab();

        mainPage.isSaucesTabOpen();
    }

    @Test
    @DisplayName("Переход в раздел «Булки»")
    public void switchToBuns() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.goToFillingsTab();

        mainPage.goToBunsTab();

        mainPage.isBunsTabOpen();
    }

    @Test
    @DisplayName("Переход в раздел «Начинки»")
    public void switchToFillings() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);

        mainPage.goToFillingsTab();

        mainPage.isFillingsTabOpen();
    }
}
