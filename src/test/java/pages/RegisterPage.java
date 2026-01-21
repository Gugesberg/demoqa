package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    public static SelenideElement firsNameLocator = $("#firstname");
    public static SelenideElement lastNameLocator = $("#lastname");
    public static SelenideElement userNameLocator = $("#userName");
    public static SelenideElement passwordLocator = $("#password");
    public static SelenideElement registerButton = $("#register");
    public static SelenideElement backToLoginButton = $("#gotologin");
    public static String relativeUrl = "/register";
    public static SelenideElement reCaptchaErrorMessage = $(".mb-1");

    public static void setFirstName(String value){
        firsNameLocator.setValue(value);
    }
    public static void setLastName(String value){
        lastNameLocator.setValue(value);
    }
    public static void setUserName(String value){
        userNameLocator.setValue(value);
    }
    public static void setPassword(String value){
        passwordLocator.setValue(value);
    }
    public static void clickRegisterButton(){
        registerButton.click();
    }
    public static void clickBackToLoginButton(){
        backToLoginButton.click();
    }
    public static void checkUnfilledReCaptcha(){
        reCaptchaErrorMessage.shouldHave(text("Please verify reCaptcha to register!"));
    }
}
