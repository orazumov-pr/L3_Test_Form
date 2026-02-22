package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

import java.time.Duration;


public class RegistrationPage {

    //Elements
    private SelenideElement firstNameInput =  $("#firstName");
    private SelenideElement lastNameInput =  $("#lastName");
    private SelenideElement emailInput =  $("#userEmail");
    private SelenideElement genderContainer =  $("#gender-radio-1");
//    private SelenideElement genderContainer =  $("#genterWrapper);
    private SelenideElement numberInput =  $("#userNumber");






    private SelenideElement addressInput =  $("#currentAddress");

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





    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }





}
