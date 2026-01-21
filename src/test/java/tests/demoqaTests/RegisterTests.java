package tests.demoqaTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static pages.RegisterPage.relativeUrl;

public class RegisterTests extends DemoqaBaseTest {


    @Test
    void tryToRegisterWithoutCaptcha(){
        open(relativeUrl);
        RegisterPage.setFirstName("Alex");
        RegisterPage.setLastName("Ivanov");
        RegisterPage.setUserName("Gugesberg");
        RegisterPage.setPassword("12345");
        RegisterPage.clickRegisterButton();
        RegisterPage.checkUnfilledReCaptcha();
    }
}
