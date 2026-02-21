package tests;

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





}
