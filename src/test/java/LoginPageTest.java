import com.codeborne.selenide.WebDriverRunner;
import com.my.creds.Profile;
import com.my.creds.ProfileDataGenerator;
import com.my.pages.LoginPage;
import com.my.pages.MainPage;
import com.my.pages.RegistrationPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class LoginPageTest {

    Profile profile;


    @Before
    public void setUp(){
        profile = ProfileDataGenerator.getRandom();
        RegistrationPage registrationPage = open(RegistrationPage.URL,RegistrationPage.class);
        registrationPage.registerNewUser(profile);
    }

    @Test
    public void loginFromMainPageUsingButtonFromHeader(){
        MainPage mainPage = open(MainPage.URL,MainPage.class);
        mainPage.goToLoginPageUsingButtonFromHeader();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(profile);
        try{
            webdriver().wait(132123);
        } catch (Exception exception){

        }

        webdriver().shouldHave(url(MainPage.URL));
    }
}
