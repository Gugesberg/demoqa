package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    public static String relativeUrl = "/register";
    private SelenideElement firsNameLocator = $("#firstname"),
                            lastNameLocator = $("#lastname"),
                            userNameLocator = $("#userName"),
                            passwordLocator = $("#password"),
                            registerButton = $("#register"),
                            backToLoginButton = $("#gotologin"),
                            reCaptchaErrorMessage = $(".mb-1");

    public RegisterPage setFirstName(String value){
        firsNameLocator.setValue(value);
        return this;
    }
    public RegisterPage setLastName(String value){
        lastNameLocator.setValue(value);
        return this;
    }
    public RegisterPage setUserName(String value){
        userNameLocator.setValue(value);
        return this;
    }
    public RegisterPage setPassword(String value){
        passwordLocator.setValue(value);
        return this;
    }
    public RegisterPage clickRegisterButton(){
        registerButton.click();
        return this;
    }
    public RegisterPage clickBackToLoginButton(){
        backToLoginButton.click();
        return this;
    }
    public RegisterPage checkUnfilledReCaptcha(){
        reCaptchaErrorMessage.shouldHave(text("Please verify reCaptcha to register!"));
        return this;
    }
}
