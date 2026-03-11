package tests.parametrized;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

@Tag("SMOKE")
public class PracticeFormBirthdayTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void openPracticeForm() {
        open("");
        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        SelenideElement formsElement = $(byText("Forms"));
        formsElement.shouldBe(visible, Duration.ofSeconds(10));
        formsElement.click();
        $$(".router-link").findBy(text("Practice Form")).click();
    }

    @DisplayName("Подставляем разные даты в календаре")
    @ParameterizedTest
    @CsvFileSource(resources = "/date_value_csv.txt", numLinesToSkip = 1)
    void testDifferentBirthDates(String day, String month, String year, String expectedDisplay) {
        // Заполняем обязательные поля
        $("#firstName").setValue("Test");
        $("#lastName").setValue("User");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("9997776655");

        // Выбор даты рождения из параметров
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);

        // Кликаем по нужному дню (обрабатываем дни с ведущим нулем)
        String daySelector = day.startsWith("0") ? day.substring(1) : day;
        $(".react-datepicker__day--0" + daySelector +
                ":not(.react-datepicker__day--outside-month)").shouldBe(visible).click();

        // Отправляем форму
        $("#submit").click();

        // Проверяем, что дата отображается правильно
        $(".modal-content").shouldBe(visible);
        $(".table-responsive").$(byText("Date of Birth")).parent()
                .shouldHave(text(expectedDisplay));
    }
}