package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
       public static String relativeUrl = "/login";
       private SelenideElement userNameLocator = $("#userName"),
                               passwordLocator = $("#password"),
                               loginButtonLocator = $("#login"),
                               newUserButtonLocator = $("#newUser"),
                               invalidUsernameOrPasswordMessage = $(".mb-1");



       public LoginPage pushLoginButton(){
           loginButtonLocator.click();
           return this;

       }
       public LoginPage pushNewUserButton(){
           newUserButtonLocator.click();
           return this;

       }
       public LoginPage setUserName(String value){
           userNameLocator.setValue(value);
           return this;

       }
       public LoginPage setPassword(String value){
           passwordLocator.setValue(value);
           return this;
       }
       public LoginPage checkFailedAuthorization() {
           invalidUsernameOrPasswordMessage.shouldHave(text("Invalid username or password!"));
           return this;
       }
       public LoginPage checkUnfilledUserName(){
           userNameLocator.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
           return this;
       }
       public LoginPage checkUnfilledPassword(){
           passwordLocator.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
           return this;
       }
}



