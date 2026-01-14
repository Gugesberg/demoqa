import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CssXpathExamples {
    void cssXpathdiff() {
        $("[data-test-id=email]").click();
        $(by("data-test-id", "email")).setValue("1");
        $(byId("email")).setValue("1");
        $("#email").setValue("1");
    }
}
