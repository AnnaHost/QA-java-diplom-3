import com.codeborne.selenide.Selenide;
import com.my.creds.Profile;
import com.my.creds.ProfileDataGenerator;
import com.my.pages.LoginPage;
import com.my.pages.MainPage;
import com.my.pages.ProfilePage;
import com.my.pages.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ProfileTest {

    Profile profile;

    @AfterClass
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @Before
    public void setUp() {
        profile = ProfileDataGenerator.getRandom();
        RegistrationPage registrationPage = open(RegistrationPage.URL, RegistrationPage.class);
        registrationPage.registerNewUser(profile);

    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void goToProfilePage() {
        LoginPage loginPage = open(LoginPage.URL, LoginPage.class);
        loginPage.login(profile);

        MainPage mainPage = page(MainPage.class);
        mainPage.goToProfilePage();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.isProfilePage();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logout() {
        LoginPage loginPage = open(LoginPage.URL, LoginPage.class);
        loginPage.login(profile);
        MainPage mainPage = page(MainPage.class);
        mainPage.goToProfilePage();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.logout();

        loginPage = page(LoginPage.class);
        loginPage.isUnauthorised();
    }
}
