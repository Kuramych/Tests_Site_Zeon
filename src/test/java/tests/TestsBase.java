package tests;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.LoginPage;
import property.PropertiesHelper;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class TestsBase {

    PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();
    LoginPage loginPage = new LoginPage();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        Configuration.startMaximized=true;
        open(propertiesHelper.getProperty("zeonUrl"));
        loginPage.login(propertiesHelper.getProperty("username"), propertiesHelper.getProperty("password"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        close();
    }
}
