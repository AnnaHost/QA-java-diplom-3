import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.my.creds.Profile;
import com.my.creds.ProfileDataGenerator;
import com.my.pages.LoginPage;
import com.my.pages.MainPage;
import com.my.pages.RegistrationPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginPageTest {

    Profile profile;


    @Before
    public void setUp() {
        profile = ProfileDataGenerator.getRandom();
        RegistrationPage registrationPage = open(RegistrationPage.URL, RegistrationPage.class);
        registrationPage.registerNewUser(profile);
    }

    @AfterClass
    public static void tearDown(){
        Selenide.closeWebDriver();
    }

    @Test
    public void loginFromMainPageUsingButtonFromHeader() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.goToLoginPageUsingButtonFromHeader();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(profile);
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());

        webdriver().shouldHave(url(MainPage.URL));
    }
}
