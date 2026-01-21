package tests.demoqaTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.LoginPage.relativeUrl;


public class LoginTests extends DemoqaBaseTest {
    LoginPage loginPage = new LoginPage();

    @Test
    void negativeAuthorizationTest() {
        open(relativeUrl);
        loginPage.setUserName("Alex")
                .setPassword("12345")
                .pushLoginButton()
                .checkFailedAuthorization();
    }

    @Test
    void authorizationWithNullLogin() {
        open(relativeUrl);
        loginPage.setPassword("12345")
                .pushLoginButton()
                .checkUnfilledUserName();
    }

    @Test
    void authorizationWithNullPassword() {
        open(relativeUrl);
        loginPage.setUserName("Alex")
                .pushLoginButton()
                .checkUnfilledPassword();
    }
}
