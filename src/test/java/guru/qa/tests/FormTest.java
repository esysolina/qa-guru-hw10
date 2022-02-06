package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class FormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Tag("properties")
    @Test
    void fillFormTest() {
        step("Открываем страницу", () ->{
            registrationPage.openPage();
        });
        step("Вводим имя", () ->{
            registrationPage.typeFirstName(testData.firstName);
        });
        step("Вводим фамилию", () ->{
            registrationPage.typeLastName(testData.lastName);
        });
        step("Вводим емаил", () ->{
            registrationPage.typeUserEmail(testData.userEmail);
        });
        step("Выбираем пол", () ->{
            registrationPage.selectGender();
        });
        step("Вводим номер", () ->{
            registrationPage.typeUserNumber(testData.userNumber);
        });
        step("Выбираем дату", () ->{
            registrationPage.selectDate("18", "April", "1990");
        });
        step("Вводим предмет", () ->{
            registrationPage.typeSubject(testData.subject)
                    .selectSubject();
        });
        step("Выбираем хобби", () ->{
            registrationPage.selectHobbies();
        });
//        step("Загружаем картинку", () ->{
//            registrationPage.choosePicture(testData.pictureName);
//        });
        step("Вводим адрес", () ->{
            registrationPage.typeCurrentAddress(testData.currentAddress);
        });
        step("Выбираем штат", () ->{
            registrationPage.selectState()
                    .chooseCity(testData.firstCity);
        });
        step("Выбираем город", () ->{
            registrationPage.selectCity()
                    .chooseCity(testData.secondCity);
        });
        step("Подтверждаем заполнение формы", () ->{
            registrationPage.clickSubmitButton();
        });
        step("Проверяем заполненные данные", () ->{
            registrationPage.checkResultsValue("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResultsValue("Student Email", testData.userEmail)
                    .checkResultsValue("Gender", "Female")
                    .checkResultsValue("Mobile", testData.userNumber)
                    .checkResultsValue("Date of Birth", "18 April,1990")
                    .checkResultsValue("Subjects", "Arts")
                    .checkResultsValue("Hobbies", "Reading")
                    // .checkResultsValue("Picture", testData.pictureName)
                    .checkResultsValue("Address", testData.currentAddress)
                    .checkResultsValue("State and City", testData.firstCity + " " + testData.secondCity);
        });
    }
}
