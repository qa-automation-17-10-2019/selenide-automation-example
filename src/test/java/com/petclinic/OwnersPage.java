package com.petclinic;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 1/26/20
 */
public class OwnersPage {

    public OwnersPage checkPage() {
        $("h2").shouldHave(Condition.text("Owners"));
        return this;
    }
}
