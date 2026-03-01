package tests.utils;

import com.github.javafaker.Faker;
import java.util.Locale;


public class RandomValues {
    Faker faker = new Faker(new Locale("en"));
    public String firstName = faker.name().firstName(),
            lastName = faker.name().firstName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female","Other"),
            subjectsInput = faker.options().option("English", "Chemistry", "Computer Science",
                    "Commerce", "Economics", "Civics"),

    userNumber = faker.phoneNumber().subscriberNumber(10),
            yearSelect = String.format("%s",faker.number().numberBetween(1900,2100)),
            monthSelect = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            daySelect = String.format("%s",faker.number().numberBetween(10, 28)),
            namePicture = faker.options().option("my_abstract_scr.jpg", "nature-1295225.jpg"),
            hobbieInput = faker.options().option("Sports", "Reading", "Music"),
            address = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Haryana", "Rajasthan"),
            city = selectCity(state);

    public String pictureName = "my_abstract_scr.jpg";

    public String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

}


