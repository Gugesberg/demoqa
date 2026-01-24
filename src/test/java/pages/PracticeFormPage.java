package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomGender.getRandomGender;

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
    public PracticeFormPage setSubject(String value) {
        subjectLocator.setValue(value).pressEnter();
        return this;
    }
    public PracticeFormPage setCurrentAdress(String value) {
        currentAdressLocator.setValue(value);
        return this;
    }
    public PracticeFormPage chooseHobbie(String value) {
        hobbieLocator.$(byText(value)).click();
        return this;
    }
    public PracticeFormPage selectStateAndCity() {
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        return this;
    }
    public PracticeFormPage choseDateOfBirth() {
        calendarLocator.click();
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--021").click();
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
