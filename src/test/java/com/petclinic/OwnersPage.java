package com.petclinic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by alpa on 1/26/20
 */
public class OwnersPage {

    public OwnersPage checkPage() {
        $("h2").shouldHave(Condition.text("Owners"));
        return this;
    }

    public OwnersPage checkOwnersSize(int size) {
        SelenideElement element = $("");
        ElementsCollection selenideElements = $$("");

        return this;
    }
}
