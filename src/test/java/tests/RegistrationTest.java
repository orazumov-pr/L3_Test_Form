package tests;

import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends TestData {
    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.timeout = 10000;
    }


    @Test
    void sucessfulRegistrationTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName("Oleg");
        registrationPage.typeLastName("Razumov");
        registrationPage.typeEmail("razumov@mail.ru");
        registrationPage.setGender("Male");
        registrationPage.typeNumber("9997776655");
        registrationPage.setDateOfBirth("14", "January", "1977");
        registrationPage.setSubjects("En");
        registrationPage.setHobbies("Music");
        registrationPage.loadPicture("my_abstract_scr.jpg");
        registrationPage.typeAddress("Ulitsa Lenina, 5");
        registrationPage.setStateAndCity("Uttar Pradesh", "Merrut");
        registrationPage.submitForm();


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



