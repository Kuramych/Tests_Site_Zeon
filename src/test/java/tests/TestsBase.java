package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestsBase {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        open("https://www.777555.by/");
        LoginPage.login("pp", "pp");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
