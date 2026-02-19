package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

import java.time.Duration;

public class PracticeFormTestData {


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.timeout = 10000;
    }

    @Test
    void fillFormTest() {
        open("/");

        SelenideElement formsElement = $(byText("Forms"));
        formsElement.shouldBe(visible, Duration.ofSeconds(10));
        executeJavaScript("arguments[0].click();", formsElement);
        $$(".router-link").findBy(text("Practice Form")).click();

        // Заполнение формы

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthSelect);
        $(".react-datepicker__year-select").selectOption(yearSelect);
        $(".react-datepicker__day.react-datepicker__day--0" + daySelect).click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $(byText(hobbieInput)).click();
        $("#uploadPicture").uploadFromClasspath("my_abstract_scr.jpg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Merrut")).click();
        $("#submit").click();

        // Проверки
        $(".modal-content").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Oleg Razumov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("razumov@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9997776655"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("14 January,1977"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("my_abstract_scr.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Ulitsa Lenina, 5"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Merrut"));

    }
}
