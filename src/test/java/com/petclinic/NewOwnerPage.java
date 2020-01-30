package com.petclinic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 1/26/20
 */
public class NewOwnerPage {


    public NewOwnerPage setFirstName(String name) {
        $("#firstName").setValue(name);
        return this;
    }

    public NewOwnerPage setLastName(String name) {
        $("#lastName").setValue(name);
        return this;
    }

    public NewOwnerPage setAddress(String address) {
        $("#address").setValue(address);
        return this;
    }

    public NewOwnerPage setCity(String city) {
        $("#city").setValue(city);
        return this;
    }

    public NewOwnerPage setTelephone(String telephone) {
        $(By.id("telephone")).setValue(telephone);
        return this;
    }

    public OwnersPage clickAddNewOwnerBtn() {
        $("[type='submit']").shouldBe(Condition.enabled).click();
        return new OwnersPage();
    }

    public OwnersPage addButtonShouldBe(Condition condition) {
        $("[type='submit']").shouldBe(condition);
        return new OwnersPage();
    }

    public NewOwnerPage setAddButtonEnabled() {
        SelenideElement addBtn = $("[type='submit']");
        Selenide.executeJavaScript("arguments[0].disabled=false;", addBtn);
//        Selenide.executeJavaScript("arguments[0].click();", addBtn);
//        JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
//        jse.executeScript("document.getElementById('gbqfb').click();");
        return this;
    }

    public String getTextByJs() {
        SelenideElement addBtn = $("[type='submit']");
        String text = Selenide.executeJavaScript("return arguments[0].innerText;", addBtn);
//        Selenide.executeJavaScript("arguments[0].click();", addBtn);
//        JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
//        jse.executeScript("document.getElementById('gbqfb').click();");
        return text;
    }

}
