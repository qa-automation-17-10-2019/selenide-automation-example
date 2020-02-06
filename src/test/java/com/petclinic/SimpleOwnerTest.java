package com.petclinic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by alpa on 1/30/20
 */
public class SimpleOwnerTest {

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = "http://139.59.149.247:8000/petclinic";
    }


    @Test
    public void addButtonShouldBeTest() {
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();

        newOwnerPage.addButtonShouldBe(Condition.disabled);
    }
}
