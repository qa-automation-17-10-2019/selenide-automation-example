package com.petclinic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alpa on 1/26/20
 */
public class OwnerTest {

    static {
        Configuration.baseUrl = "http://139.59.149.247:8000/petclinic";
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
//        Configuration.timeout = 7000;
//        Configuration.browser = "firefox";
    }

    //    @Test
    public void addNewOwnerTest() {
        open("/owners/add");

        $("h2").shouldHave(Condition.text("New Owner"));
        $("[type='submit']").shouldBe(Condition.disabled);

        $("#firstName").setValue("Selendie");
        $("#lastName").setValue("cool");
        $("#address").setValue("street 34");
        $("#city").setValue("Dnipro");
        $(By.id("telephone")).setValue("1234567890");

        $("[type='submit']").shouldBe(Condition.enabled).click();

        $("h2").shouldHave(Condition.text("Owners"));

    }

    @Test
    public void addNewOwnerPageObjectTest() {
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();

        newOwnerPage
                .setFirstName("Selendie")
                .setLastName("cool")
                .setAddress("street 34")
                .setCity("Dnipro")
                .setTelephone("1234567890")
                .clickAddNewOwnerBtn()
                .checkPage();

    }

    @Test
    public void addButtonShouldBeTest() {
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();

        newOwnerPage
                .setAddButtonEnabled()
                .addButtonShouldBe(Condition.enabled);

    }

    @Test
    public void getTextByJsText() {
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();

        String textByJs = newOwnerPage.getTextByJs();
        System.out.println("textByJs: " + textByJs);

    }

}
