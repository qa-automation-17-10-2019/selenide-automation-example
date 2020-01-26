package com.petclinic;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

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


//    $("#firstName").setValue("Selendie");
//    $("#lastName").setValue("cool");
//    $("#address").setValue("street 34");
//    $("#city").setValue("Dnipro");
//    $(By.id("telephone")).setValue("1234567890");

//        $("[type='submit']").shouldBe(Condition.enabled).click();

//        $("h2").shouldHave(Condition.text("Owners"));
}
