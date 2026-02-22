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


        //Checkings
        registrationPage.checkSummaryForm("Thanks for submitting the form");
        registrationPage.checkField();

    }
}



