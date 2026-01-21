package tests.demoqaTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.LoginPage.relativeUrl;


public class LoginTests extends DemoqaBaseTest {

    @Test
    void negativeAuthorizationTest(){
        open(relativeUrl);
        LoginPage.setUserName("Alex");
        LoginPage.setPassword("12345");
        LoginPage.pushLoginButton();
        LoginPage.checkFailedAuthorization();
    }
    @Test
    void authorizationWithNullLogin(){
        open(relativeUrl);
        LoginPage.setPassword("12345");
        LoginPage.pushLoginButton();
        LoginPage.checkUnfilledUserName();
    }
    @Test
    void authorizationWithNullPassword(){
        open(relativeUrl);
        LoginPage.setUserName("Alex");
        LoginPage.pushLoginButton();
        LoginPage.checkUnfilledPassword();
    }
}
