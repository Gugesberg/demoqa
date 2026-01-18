package demoqaTests;

import  com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
 @BeforeAll
    static void beforeAll(){
     Configuration.browserSize = "1920x1080"; //конфигурация окна браузера
     Configuration.baseUrl = "https://demoqa.com"; //вынесли базовый УРЛ
     Configuration.pageLoadStrategy = "eager"; //стратегия загрузки страницы
     //Configuration.holdBrowserOpen = true; // не закрывать страницу браузера
     //Configuration.timeout = 5000;// default 4000
 }

    @Test
    void fillFormTest()
    { // id и class можно заменить на #
        open("/text-box"); //открытие ресурса
        $("#userName").setValue("Alex"); // ввод значения
        $("#userEmail").setValue("sasha19337@mail.ru"); // ввод значения
        $("#currentAddress").setValue("Энергетиков 3"); // ввод значения
        $("#permanentAddress").setValue("Гареева 102"); // ввод значения
        $("#submit").click(); // нажатие на кнопку

        $("#output #name").shouldHave(text("Alex")); // поиск текста (2 уровня элементов) сокращенная запись
        $("#output #email").shouldHave(text("sasha19337@mail.ru")); // поиск текста (2 уровня элементов)сокращенная запись
        $("#output").$("#currentAddress").shouldHave(text("Энергетиков 3")); // поиск текста (2 уровня элементов) полная запись
        $("#output").$("#permanentAddress").shouldHave(text("Гареева 102")); // поиск текста (2 уровня элементов) полная запись


    }





}
