package pages.components;

import com.codeborne.selenide.SelenideElement;
import tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.*;

public class ResultTableData {

    private SelenideElement modalContent = $(".modal-content");
    private SelenideElement modalHeader = $(".modal-header");
    private SelenideElement tableResponsive = $(".table-responsive");

    public ResultTableData checkModalContent() {
        modalContent.shouldBe(visible);
        return this;
    }

    public ResultTableData checkModalHeader(String expectedHeader) {
        modalHeader.shouldHave(text(expectedHeader));
        return this;
    }

    public ResultTableData checkField(String fieldName, String expectedValue) {
        tableResponsive.shouldHave(text(fieldName + " " + expectedValue));
        return this;
    }

    public ResultTableData checkAllFields() {
        checkModalContent();
        checkModalHeader("Thanks for submitting the form");

        checkField("Student Name", firstName + " " + lastName);
        checkField("Student Email", userEmail);
        checkField("Gender", gender);
        checkField("Mobile", userNumber);
        checkField("Date of Birth", daySelect + " " + monthSelect + "," + yearSelect);
        checkField("Subjects", "English");
        checkField("Hobbies", hobbieInput);
        checkField("Picture", namePicture);
        checkField("Address", address);
        checkField("State and City", state + " " + city);

        return this;
    }
}