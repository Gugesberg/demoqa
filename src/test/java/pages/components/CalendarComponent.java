package pages.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class CalendarComponent {
    //static SelenideElement _day = $(".react-datepicker__day");
    static SelenideElement _month = $(".react-datepicker__month-select");
    static SelenideElement _year = $(".react-datepicker__year-select");
    public CalendarComponent setDate(String year, String month, String day){
        //$(".react-datepicker__input-container").click();
        _year.selectOption(year);
        _month.selectOption(month);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
        return this;
    }
}
