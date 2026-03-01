package tests.testdata;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableData;
import tests.utils.RandomValues;

import static tests.testdata.TestData.*;


public class PracticeFormTestsRandomValues {

    RandomValues randomValues = new RandomValues();
    ResultTableData resultTableData = new ResultTableData();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.timeout = 10000;
    }

    @Test
    void fillFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.openPage()
                .typeFirstName(randomValues.firstName)
                .typeLastName(randomValues.lastName)
                .typeEmail(randomValues.userEmail)
                .setGender(randomValues.gender)
                .typeNumber(randomValues.userNumber)
                .setDateOfBirth(randomValues.daySelect, randomValues.monthSelect, randomValues.yearSelect)
                .setSubjects(randomValues.subjectsInput)
                .setHobbies(randomValues.hobbieInput)
                .typeAddress(randomValues.address)
                .loadPicture(randomValues.namePicture)
                .setState(randomValues.state)
                .setCity(randomValues.city)
                .submitForm();

        // Проверки
        resultTableData.checkModalContent()
                .checkModalHeader("Thanks for submitting the form")
                .checkField("Student Name", randomValues.firstName + " " + randomValues.lastName)
                .checkField("Student Email", randomValues.userEmail)
                .checkField("Gender", randomValues.gender)
                .checkField("Mobile", randomValues.userNumber)
                .checkField("Date of Birth", randomValues.daySelect + " " + randomValues.monthSelect + "," + randomValues.yearSelect)
                .checkField("Subjects", "English")
                .checkField("Hobbies", randomValues.hobbieInput)
                .checkField("Picture", namePicture)
                .checkField("Address", randomValues.address)
                .checkField("State and City", randomValues.state + " " + randomValues.city);
    }
}
