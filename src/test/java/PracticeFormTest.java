import  com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; //конфигурация окна браузера
        Configuration.baseUrl = "https://demoqa.com"; //вынесли базовый УРЛ
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeFormTest()
    {
        File image = new File("src/test/resources/files/testImage.jpg");
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("sasha19337@mail.ru");
        $(".custom-radio:nth-child(1) > .custom-control-label").click();
        $("#userNumber").setValue("7927675913");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--013").click();
        //$(".subjects-auto-complete__value-container").click();
        //$("#react-select-2-option-0").click();
        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();
        $(".custom-checkbox:nth-child(2) > .custom-control-label").click();
        //$("#uploadPicture").uploadFile(image);
        $("#currentAddress").setValue("Gareeva 102k2");
        $("#submit").click();

        $("tr:nth-child(1) > td:nth-child(2)").shouldHave(text("Alex Ivanov"));
        $("tr:nth-child(2) > td:nth-child(2)").shouldHave(text("sasha19337@mail.ru"));
        $("tr:nth-child(3) > td:nth-child(2)").shouldHave(text("Male"));
        $("tr:nth-child(4) > td:nth-child(2)").shouldHave(text("7927675913"));
        $("tr:nth-child(5) > td:nth-child(2)").shouldHave(text("13 January,2026"));
        $("tr:nth-child(7) > td:nth-child(2)").shouldHave(text("Sports, Reading"));
        $("tr:nth-child(9) > td:nth-child(2)").shouldHave(text("Gareeva 102k2"));


    }
}