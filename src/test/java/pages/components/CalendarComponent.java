package pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String daySelector = String.format(".react-datepicker__day--%s:not(.react-datepicker__day--outside-month)", day);
        $(daySelector).shouldBe(visible).click();
    }
}

