package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
       public static SelenideElement userNameLocator = $("#userName");
       public static SelenideElement passwordLocator = $("#password");
       public static SelenideElement loginButtonLocator = $("#login");
       public static SelenideElement newUserButtonLocator = $("#newUser");
       public static SelenideElement invalidUsernameOrPasswordMessage = $(".mb-1");
       public static String relativeUrl = "/login";


       public static void pushLoginButton(){
           loginButtonLocator.click();

       }
       public static void pushNewUserButton(){
           newUserButtonLocator.click();

       }
       public static void setUserName(String value){
           userNameLocator.setValue(value);

       }
       public static void setPassword(String value){
           passwordLocator.setValue(value);
       }
       public static void checkFailedAuthorization() {
           invalidUsernameOrPasswordMessage.shouldHave(text("Invalid username or password!"));
       }
       public static void checkUnfilledUserName(){
           userNameLocator.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
       }
       public static void checkUnfilledPassword(){
           passwordLocator.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
       }
}



