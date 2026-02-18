package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.timeout = 10000; // Увеличим таймаут для надежности
    }

    @Test
    void fillFormTest() {
        open("/");

        // Навигация
        $(".card-body").find(byText("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        // Заполнение формы
        fillPersonalInfo();
        fillGender();
        fillMobileNumber();
        fillDateOfBirth();
        fillSubjects();
        fillHobbies();
        uploadPicture();
        fillCurrentAddress();
        selectStateAndCity();

        submitForm();

        // Проверки
        verifyModalAppears();
        verifySubmittedData();
    }

    private void fillPersonalInfo() {
        $("#firstName").shouldBe(visible).setValue("Oleg");
        $("#lastName").setValue("Razumov");
        $("#userEmail").setValue("razumov@mail.ru");
    }

    private void fillGender() {
        $("#genterWrapper").$(byText("Male")).click();
    }

    private void fillMobileNumber() {
        $("#userNumber").setValue("9997776655");
    }

    private void fillDateOfBirth() {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1977");
        $(".react-datepicker__day--014:not(.react-datepicker__day--outside-month)")
                .shouldBe(visible).click();
    }

    private void fillSubjects() {
        $("#subjectsInput").setValue("En").pressEnter();
    }

    private void fillHobbies() {
        $(byText("Music")).click();
    }

    private void uploadPicture() {
        $("#uploadPicture").uploadFromClasspath("my_abstract_scr.jpg");
    }

    private void fillCurrentAddress() {
        $("#currentAddress").setValue("Ulitsa Lenina, 5");
    }

    private void selectStateAndCity() {
        $("#state").scrollTo().click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Merrut")).click();
    }

    private void submitForm() {
        $("#submit").scrollTo().click();
    }

    private void verifyModalAppears() {
        $(".modal-content").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
    }

    private void verifySubmittedData() {
        verifyTableRow("Student Name", "Oleg Razumov");
        verifyTableRow("Student Email", "razumov@mail.ru");
        verifyTableRow("Gender", "Male");
        verifyTableRow("Mobile", "9997776655");
        verifyTableRow("Date of Birth", "14 January,1977");
        verifyTableRow("Subjects", "English");
        verifyTableRow("Hobbies", "Music");
        verifyTableRow("Picture", "my_abstract_scr.jpg");
        verifyTableRow("Address", "Ulitsa Lenina, 5");
        verifyTableRow("State and City", "Uttar Pradesh Merrut");
    }

    private void verifyTableRow(String label, String expectedValue) {
        $(".table-responsive")
                .$(byText(label))
                .parent()
                .shouldHave(text(expectedValue));
    }
}