package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private static SelenideElement usernameLocator = $(By.name("rlogin"));
    private static SelenideElement passwordLocator = $(By.name("rpwd"));
    private static SelenideElement repeatPasswordLocator = $(By.name("rpwd"));
    private static SelenideElement mailLocator = $(By.xpath("//div[@id='dialog_reg']/form/div/div[2]/input"));
    private static SelenideElement fullNameLocator = $(By.xpath("//div[@id='dialog_reg']/form/div/div[3]/input"));
    private static SelenideElement phoneLocator = $(By.xpath("//div[@id='dialog_reg']/form/div/div[4]/input"));
    private static SelenideElement initRegistrationButton = $(By.xpath("//header[@id='header']/div[2]/div/div[4]/div[2]/button/i"));
    private static SelenideElement registrationButton = $(By.linkText("Зарегистрироваться"));
    private static SelenideElement agreeRulesButton = $(By.xpath("//div[@id='dialog_reg']/form/div/label/div"));
    private static SelenideElement submitRegistrationButton = $(By.xpath("//div[@id='dialog_reg']/form/div[2]/button"));



    public static void typeUsername(String username) {
        usernameLocator.waitUntil(Condition.visible, 5000).clear();
        usernameLocator.waitUntil(Condition.visible, 5000).sendKeys(username);
    }

    public static void typePassword(String password) {
        passwordLocator.waitUntil(Condition.visible, 5000).clear();
        passwordLocator.waitUntil(Condition.visible, 5000).sendKeys(password);
    }
    public static void typeRepeatPassword(String repeatPassword) {
        repeatPasswordLocator.waitUntil(Condition.visible, 5000).clear();
        repeatPasswordLocator.waitUntil(Condition.visible, 5000).sendKeys(repeatPassword);
    }
    public static void typeMail(String mail) {
        mailLocator.waitUntil(Condition.visible, 5000).clear();
        mailLocator.waitUntil(Condition.visible, 5000).sendKeys(mail);
    }
    public static void typeFullname(String fullname) {
        fullNameLocator.waitUntil(Condition.visible, 5000).clear();
        fullNameLocator.waitUntil(Condition.visible, 5000).sendKeys(fullname);
    }
    public static void typePhone(String phone) {
        phoneLocator.waitUntil(Condition.visible, 5000).clear();
        phoneLocator.waitUntil(Condition.visible, 5000).sendKeys(phone);
    }

    public static void initRegistration () {
        initRegistrationButton.click();
        registrationButton.click();
    }

    public static HomePage submitRegistration() {
        agreeRulesButton.click();
        submitRegistrationButton.click();
        return new HomePage();
    }

    public static HomePage registration(String username, String mail, String fullName,
                                        String phone, String password) {
        initRegistration();
        typeUsername(username);
        typeMail(mail);
        typeFullname(fullName);
        typePhone(phone);
        typePassword(password);
        return submitRegistration();
    }
}
