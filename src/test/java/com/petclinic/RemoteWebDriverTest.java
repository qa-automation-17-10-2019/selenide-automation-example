package com.petclinic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alpa on 1/30/20
 */
public class RemoteWebDriverTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
//        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("78.0");
        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", false);

        driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addNewOwnerTest() throws InterruptedException {
        driver.get("http://139.59.149.247:8000/petclinic/owners/add");
        sleep(10_000);

        WebElement h2 = driver.findElement(By.cssSelector("h2"));
        String text = h2.getText();
        assertThat(text).isEqualTo("New Owner");
        sleep(10_000);
    }

}
