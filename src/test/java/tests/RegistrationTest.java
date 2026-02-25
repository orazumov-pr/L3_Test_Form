package tests;

import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationTest {
    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.timeout = 10000;
    }

    @Test
    void successfulRegistrationTest() {
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
        registrationPage.modalContent();
        registrationPage.modalHeader("Thanks for submitting the form");

        registrationPage.checkField("Student Name", "Oleg Razumov");
        registrationPage.checkField("Student Email", "razumov@mail.ru");
        registrationPage.checkField("Gender", "Male");
        registrationPage.checkField("Mobile", "9997776655");
        registrationPage.checkField("Date of Birth", "14 January,1977");
        registrationPage.checkField("Subjects", "English");
        registrationPage.checkField("Hobbies", "Music");
        registrationPage.checkField("Picture", "my_abstract_scr.jpg");
        registrationPage.checkField("Address", "Ulitsa Lenina, 5");
        registrationPage.checkField("State and City", "Uttar Pradesh Merrut");
    }

}



