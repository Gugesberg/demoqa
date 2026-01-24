package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomData.*;

public class PracticeFormPage {
    private SelenideElement firstNameLocator = $("#firstName"),
            lastNameLocator = $("#lastName"),
            userEmailLocator = $("#userEmail"),
            genderLocator = $("#genterWrapper"),
            mobileNumberLocator = $("#userNumber"),
            calendarLocator = $("#dateOfBirthInput"),
            subjectLocator = $("#subjectsInput"),
            hobbieLocator = $("#hobbiesWrapper"),
            uploadPictureLocator = $("#uploadPicture"),
            currentAdressLocator = $("#currentAddress"),
            submitButtonLocator =  $("#submit");

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameLocator.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameLocator.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        userEmailLocator.setValue(value);
        return this;
    }

    public PracticeFormPage chooseGender() {
        genderLocator.$(byText(getRandomGender())).click();
        return this;

    }

    public PracticeFormPage setMobileNumber(String value) {
        mobileNumberLocator.setValue(value);
        return this;
    }

    public PracticeFormPage uploadPicture(File file) {
        uploadPictureLocator.uploadFile(file);
        return this;
    }
    public PracticeFormPage setSubject() {
        subjectLocator.setValue(getRandomSubjects()).pressEnter();
        return this;
    }
    public PracticeFormPage setCurrentAdress(String value) {
        currentAdressLocator.setValue(value);
        return this;
    }
    public PracticeFormPage chooseHobbie() {
        hobbieLocator.$(byText(getRandomHobbie())).click();
        return this;
    }
    public PracticeFormPage selectStateAndCity() {
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        return this;
    }
    public PracticeFormPage choseDateOfBirth() {
        CalendarComponent calendarComponent = new CalendarComponent();
        calendarLocator.click();
        calendarComponent.setDate(getRandomYear(),getRandomMonth(),getRandomDay());
        return this;
    }
    public PracticeFormPage clickSubmitButton() {
        submitButtonLocator.click();
        return this;
    }
    public PracticeFormPage checkThanksForSubmittingModalIsOpen() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("#closeLargeModal").click();
        return this;
    }

}
