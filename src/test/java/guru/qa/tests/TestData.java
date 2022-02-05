package guru.qa.tests;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String currentAddress = faker.address().fullAddress();
    String subject = "a";
    String pictureName = "file.txt";
    String firstCity = "NCR";
    String secondCity = "Delhi";
}
