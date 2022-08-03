package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
    }

        @Test
        void fillFormTest () {
            open("/automation-practice-form");
            executeJavaScript("$('footer').remove()");
            $("#firstName").setValue("Olga");
            $("#lastName").setValue("Alexandrova");
            $("#userEmail").setValue("Olga@ya.ru");
            $(byText("Female")).click();
            $("#userNumber").setValue("8916111111");
            $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
            $("#dateOfBirthInput").sendKeys("01 January 2000" + Keys.ENTER);
            $("#subjectsInput").setValue("History").pressEnter();
            $(byText("Sports")).click();
            $(byText("Reading")).click();
            $(byText("Music")).click();
            $("#uploadPicture").uploadFile(new File("src/test/resources/file.txt"));
            $("#currentAddress").setValue("Moscow");
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#react-select-4-input").setValue("Delhi").pressEnter();
            $("#submit").scrollTo().pressEnter();
            $("[class=table-responsive]").shouldHave(text("Olga Alexandrova"), text("Olga@ya.ru"),
                    text("Female"), text("8916111111"), text("01 January,2000"), text("History"),
                    text("Sports, Reading, Music"), text("file.txt"), text("Moscow"), text("NCR Delhi"));
        }
}
