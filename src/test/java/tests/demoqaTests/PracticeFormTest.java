package tests.demoqaTests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.io.File;
import java.util.Locale;


public class PracticeFormTest extends DemoqaBaseTest {
    PracticeFormPage practiceFormTestPage = new PracticeFormPage();
    Faker faker = new Faker(new Locale("ru"));
    String firstName;
    String lastName;
    String currentAdress;
    String mobileNumber;
    String email;
    //String gender;

    @BeforeEach
    void generateTestData(){
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        currentAdress = faker.address().streetAddress();
        mobileNumber = faker.phoneNumber().subscriberNumber(10);
        email = faker.internet().emailAddress("en");
       // gender = faker.options().option("Male","Female","Other");
    }

    @Test
    void fillPracticeFormTest() {

        File image = new File("src/test/resources/files/testImage.jpeg");

        practiceFormTestPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .chooseGender()
                .setMobileNumber(mobileNumber)
                .choseDateOfBirth().setSubject("Eng")
                .chooseHobbie("Sports").chooseHobbie("Music")
                .uploadPicture(image)
                .setCurrentAdress(currentAdress)
                .selectStateAndCity()
                .clickSubmitButton();
                // .checkThanksForSubmittingModalIsOpen();
    }

}


