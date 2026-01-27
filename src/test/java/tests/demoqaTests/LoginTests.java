package tests.demoqaTests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;
import utils.RandomData;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.LoginPage.relativeUrl;
import static utils.RandomData.getRandomPassword;
import static utils.RandomData.getRandomUserName;


@DisplayName("Тесты на авторизацию")
public class LoginTests extends DemoqaBaseTest {
    LoginPage loginPage = new LoginPage();

    //@Disabled("заведён баг (номер в джире) ")
    @DisplayName("Авторизация под несуществующей учёткой")
    @ValueSource(strings = {"Alex","Пгпуыиукп"})
    //@CsvSource дата провайдер для нескольких аргументов
    @ParameterizedTest(name = "Авторизация под несуществующей учёткой с именем пользователя {0}")
    void negativeAuthorizationTest(String userName) {
        open(relativeUrl);
        loginPage.setUserName(userName)
                .setPassword(getRandomPassword())
                .pushLoginButton()
                .checkFailedAuthorization();
    }
    @DisplayName("авторизация без заполнения имени пользователя")
    @Tag("Smoke")
    @Test
    void authorizationWithNullLogin() {
        open(relativeUrl);
        loginPage.setPassword(getRandomPassword())
                .pushLoginButton()
                .checkUnfilledUserName();
    }
    @DisplayName("авторизация без заполнения пароля")
    @Test
    void authorizationWithNullPassword() {
        open(relativeUrl);
        loginPage.setUserName(getRandomUserName())
                .pushLoginButton()
                .checkUnfilledPassword();
    }
}
