package tests.demoqaTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static pages.RegisterPage.relativeUrl;

public class RegisterTests extends DemoqaBaseTest {

    RegisterPage registerPage = new RegisterPage();

    @Test
    void tryToRegisterWithoutCaptcha() {
        open(relativeUrl);
        registerPage.setFirstName("Alex")
                .setLastName("Ivanov")
                .setUserName("Gugesberg")
                .setPassword("12345")
                .clickRegisterButton()
                .checkUnfilledReCaptcha();
    }
}
