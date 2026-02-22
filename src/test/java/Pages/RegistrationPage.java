package Pages;

import Pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

import java.time.Duration;


public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();

    //Elements
    private SelenideElement firstNameInput =  $("#firstName");
    private SelenideElement lastNameInput =  $("#lastName");
    private SelenideElement emailInput =  $("#userEmail");
    private SelenideElement genderContainer =  $("#gender-radio-1");
//    private SelenideElement genderContainer =  $("#genterWrapper);
    private SelenideElement numberInput =  $("#userNumber");
    private SelenideElement subjectContainer =  $("#subjectsInput");
    private SelenideElement hobbiesContainer =  $("#hobbiesWrapper");
    private SelenideElement pictureUpload =  $("#uploadPicture");
    private SelenideElement addressInput =  $("#currentAddress");
    private SelenideElement stateCityContainer =  $("#stateCity-wrapper");
    private SelenideElement setState =  $("#state");
    private SelenideElement setCity =  $("#city");
    private SelenideElement submitButton =  $("#submit");












    //Actions
    public RegistrationPage openPage() {
            SelenideElement formsElement = $(byText("Forms"));
            formsElement.shouldBe(visible, Duration.ofSeconds(10));
            executeJavaScript("arguments[0].click();", formsElement);
            $$(".router-link").findBy(text("Practice Form")).click();

            return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderContainer.parent().click();

        return this;
    }

//        public RegistrationPage setGender(String value) {
//        genderContainer.$byText(value).click();
//
//        return this;
//    }

   public RegistrationPage typeNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();

        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectContainer.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage loadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        setState.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        setCity.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();

        return this;
    }



}
