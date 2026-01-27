package tests.demoqaTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public class DemoqaBaseTest {
    @DisplayName("Базовый тест для сайта demoqa")
    @BeforeAll
    static void baseTestConfiguration() {
        // Configuration.browser = "firefox";//выбор браузера
        Configuration.browserSize = "1920x1080"; //конфигурация окна браузера
        Configuration.baseUrl = "https://demoqa.com"; //вынесли базовый УРЛ
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }
}
