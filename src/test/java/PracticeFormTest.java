import  com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; //конфигурация окна браузера
        Configuration.baseUrl = "https://demoqa.com"; //вынесли базовый УРЛ
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
    }

    @Test
    void fillPracticeFormTest()
    {
        File image = new File("src/test/resources/files/testImage.jpeg");
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("sasha19337@mail.ru");
        $(".custom-radio:nth-child(1) > .custom-control-label").click();
        $("#userNumber").setValue("7927675913");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Eng").pressEnter();
        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();
        $(".custom-checkbox:nth-child(2) > .custom-control-label").click();
        $("#uploadPicture").uploadFile(image);
        $("#currentAddress").setValue("Gareeva 102k2");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

/*
        $$(".table table-dark table-striped table-bordered table-hover").shouldHave(exactTexts("Alex Ivanov",
                "sasha19337@mail.ru", "Male","7927675913","13 January,2026","English","Sports, Reading",
                "testImage.jpeg","Gareeva 102k2","NCR Delhi")); // todo : сделать проверку всех элементов внутри коллекции
*/
        $("tr:nth-child(1) > td:nth-child(2)").shouldHave(text("Alex Ivanov"));
        $("tr:nth-child(2) > td:nth-child(2)").shouldHave(text("sasha19337@mail.ru"));
        $("tr:nth-child(3) > td:nth-child(2)").shouldHave(text("Male"));
        $("tr:nth-child(4) > td:nth-child(2)").shouldHave(text("7927675913"));
        $("tr:nth-child(5) > td:nth-child(2)").shouldHave(text("13 January,2026"));
        $("tr:nth-child(6) > td:nth-child(2)").shouldHave(text("English"));
        $("tr:nth-child(7) > td:nth-child(2)").shouldHave(text("Sports, Reading"));
        $("tr:nth-child(8) > td:nth-child(2)").shouldHave(text("testImage.jpeg"));
        $("tr:nth-child(9) > td:nth-child(2)").shouldHave(text("Gareeva 102k2"));
        $("tr:nth-child(10) > td:nth-child(2)").shouldHave(text("NCR Delhi"));
*/

    }
}