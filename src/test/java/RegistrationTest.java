import com.codeborne.selenide.Selenide;
import com.my.creds.Profile;
import com.my.creds.ProfileDataGenerator;
import com.my.pages.LoginPage;
import com.my.pages.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private Profile profile;

    @AfterClass
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @Before
    public void setUp() {
        profile = ProfileDataGenerator.getRandom();
    }

    @Test
    @DisplayName("Регистрация с корректными данными")
    public void registrationWithValidData() {
        RegistrationPage registrationPage = open(RegistrationPage.URL, RegistrationPage.class);

        registrationPage.registerNewUser(profile);

        LoginPage loginPage = page(LoginPage.class);
        loginPage.isLoginPage();
    }

    @Test
    @DisplayName("Попытка регистрации с коротким паролем")
    public void registrationWithShortPassword() {
        RegistrationPage registrationPage = open(RegistrationPage.URL, RegistrationPage.class);

        profile.setPassword("123");
        registrationPage.registerNewUser(profile);

        assertTrue(registrationPage.isInvalidPassportTextDisplayed());

    }
}
