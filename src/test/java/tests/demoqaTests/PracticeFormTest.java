package tests.demoqaTests;

import  com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.*;
import pages.PracticeFormPage;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static pages.PracticeFormPage.relativeUrl;

public class PracticeFormTest extends DemoqaBaseTest {
    PracticeFormPage practiceFormTestPage = new PracticeFormPage();

    @Test
    void fillPracticeFormTest() {

        File image = new File("src/test/resources/files/testImage.jpeg");
        open(relativeUrl);
        practiceFormTestPage.setFirstName("Alex")
                .setLastName("Ivanov")
                .setEmail("sasha19337@mail.ru")
                .chooseGender("Male")
                .setMobileNumber("7927675913")
                .choseDateOfBirth().setSubject("Eng")
                .chooseHobbie("Sports").chooseHobbie("Music")
                .uploadPicture(image)
                .setCurrentAdress("Gareeva 102k2")
                .selectStateAndCity()
                .clickSubmitButton();



/*
        $("tr:nth-child(1) > td:nth-child(2)").shouldHave(text("Alex Ivanov"));
        $("tr:nth-child(2) > td:nth-child(2)").shouldHave(text("sasha19337@mail.ru"));
        $("tr:nth-child(3) > td:nth-child(2)").shouldHave(text("Male"));
        $("tr:nth-child(4) > td:nth-child(2)").shouldHave(text("7927675913"));
        $("tr:nth-child(5) > td:nth-child(2)").shouldHave(text("21 August,1994"));
        $("tr:nth-child(6) > td:nth-child(2)").shouldHave(text("English"));
        $("tr:nth-child(7) > td:nth-child(2)").shouldHave(text("Sports, Reading"));
        $("tr:nth-child(8) > td:nth-child(2)").shouldHave(text("testImage.jpeg"));
        $("tr:nth-child(9) > td:nth-child(2)").shouldHave(text("Gareeva 102k2"));
        $("tr:nth-child(10) > td:nth-child(2)").shouldHave(text("NCR Delhi"));

*/
    }
}