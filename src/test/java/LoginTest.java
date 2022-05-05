import com.codeborne.selenide.Selenide;
import com.my.creds.Profile;
import com.my.creds.ProfileDataGenerator;
import com.my.pages.ForgotPasswordPage;
import com.my.pages.LoginPage;
import com.my.pages.MainPage;
import com.my.pages.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest {

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
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromMainPageUsingButtonFromHeader() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.goToLoginPageUsingButtonFromHeader();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(profile);

        mainPage = page(MainPage.class);
        mainPage.isUserAuthorised();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPageUsingCentralButton() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.goToLoginPageUsingCentralButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(profile);

        mainPage = page(MainPage.class);
        mainPage.isUserAuthorised();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationPage() {
        RegistrationPage registrationPage = open(RegistrationPage.URL, RegistrationPage.class);
        registrationPage.goToLoginPageFromRegistrationPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(profile);

        MainPage mainPage = page(MainPage.class);
        mainPage.isUserAuthorised();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.URL, ForgotPasswordPage.class);
        forgotPasswordPage.goToLoginPageFromForgotPasswordPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(profile);

        MainPage mainPage = page(MainPage.class);
        mainPage.isUserAuthorised();
    }
}
