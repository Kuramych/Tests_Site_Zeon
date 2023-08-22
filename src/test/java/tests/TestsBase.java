package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.LoginPage;
import property.PropertiesHelper;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestsBase {

    PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        open(propertiesHelper.getProperty("zeonUrl"));
        LoginPage.login(propertiesHelper.getProperty("username"), propertiesHelper.getProperty("password"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
