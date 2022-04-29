import com.my.creds.Profile;
import com.my.creds.ProfileDataGenerator;
import com.my.pages.LoginPage;
import com.my.pages.RegistrationPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationPageTest {

    private Profile profile;

    @Before
    public void setUp(){
        profile = ProfileDataGenerator.getRandom();
    }

    @Test
    public void registrationWithValidData(){
        RegistrationPage registrationPage = open(RegistrationPage.URL,RegistrationPage.class);
        registrationPage.registerNewUser(profile);

        LoginPage loginPage = page(LoginPage.class);

        loginPage.isLoginPage();
    }

    @Test
    public void registrationWithShortPassword(){
        RegistrationPage registrationPage = open(RegistrationPage.URL,RegistrationPage.class);
        profile.setPassword("123");

        registrationPage.registerNewUser(profile);

        registrationPage.isInvalidPassportTextDisplayed();
    }
}
