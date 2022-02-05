package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            genderSelector = $(byText("Female")),
            subjectInput = $("#subjectsInput"),
            subjectClicker = $("#react-select-2-option-2"),
            hobbiesSelector = $(byText("Reading")),
            pictureUploader = $("#uploadPicture"),
            stateSelector = $("#state"),
            cityWrapper = $("#stateCity-wrapper"),
            citySelector = $("#city"),
            buttonSubmit = $("#submit"),
            buttonClose = $("#closeLargeModal"),
            resultsTable = $(".table");

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text("Student Registration Form"));

        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage typeUserEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public RegistrationPage typeUserNumber(String number) {
        userNumberInput.setValue(number);

        return this;
    }

    public RegistrationPage selectDate(String day,String  month,String  year) {
        new CalendarComponent().setDate(day, month, year);

        return this;
    }

    public RegistrationPage typeCurrentAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public RegistrationPage selectGender() {
        genderSelector.click();

        return this;
    }

    public RegistrationPage typeSubject(String subject) {
        subjectInput.setValue(subject);

        return this;
    }

    public RegistrationPage selectSubject() {
        subjectClicker.click();

        return this;
    }

    public RegistrationPage selectHobbies() {
        hobbiesSelector.click();

        return this;
    }

    public RegistrationPage choosePicture(String fileName) {
        pictureUploader.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage selectState() {
        stateSelector.click();

        return this;
    }

    public RegistrationPage chooseCity(String city) {
        cityWrapper.$(byText(city)).click();

        return this;
    }

    public RegistrationPage selectCity() {
        citySelector.click();

        return this;
    }

    public RegistrationPage clickSubmitButton() {
        buttonSubmit.click();

        return this;
    }

    public RegistrationPage clickCloseButton() {
        buttonClose.click();

        return this;
    }

    public RegistrationPage checkResultsValue(String  key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
