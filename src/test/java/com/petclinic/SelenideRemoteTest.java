package com.petclinic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URI;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by alpa on 1/30/20
 */
public class SelenideRemoteTest {

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = "http://139.59.149.247:8000/petclinic";
        Configuration.remote = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
    }


    @Test
    public void addButtonShouldBeTest() {
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();

        newOwnerPage
                .setAddButtonEnabled()
                .addButtonShouldBe(Condition.enabled);

    }
}
