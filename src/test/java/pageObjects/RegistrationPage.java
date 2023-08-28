package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private static SelenideElement usernameLocator = $(By.name("rlogin"));
    private static SelenideElement passwordLocator = $(By.name("rpwd"));
    private static SelenideElement repeatPasswordLocator = $(By.name("rpwd"));
    private static SelenideElement mailLocator = $(By.name("email"));
    private static SelenideElement fullNameLocator = $(By.name("nama"));
    private static SelenideElement phoneLocator = $(By.name("phone"));
    private static SelenideElement initRegistrationButton = $(By.xpath("//span[text()='Войти']"));
    private static SelenideElement registrationButton = $(By.linkText("Зарегистрироваться"));
    private static SelenideElement agreeRulesButton = $(By.xpath(".chek.usual"));
    private static SelenideElement submitRegistrationButton = $(By.xpath("//button[text()='Зарегистрироваться']"));



    public static void typeUsername(String username) {
        usernameLocator.waitUntil(Condition.visible, 5000).clear();
        usernameLocator.sendKeys(username);
    }

    public static void typePassword(String password) {
        passwordLocator.waitUntil(Condition.visible, 5000).clear();
        passwordLocator.sendKeys(password);
    }
    public static void typeRepeatPassword(String repeatPassword) {
        repeatPasswordLocator.waitUntil(Condition.visible, 5000).clear();
        repeatPasswordLocator.sendKeys(repeatPassword);
    }
    public static void typeMail(String mail) {
        mailLocator.waitUntil(Condition.visible, 5000).clear();
        mailLocator.sendKeys(mail);
    }
    public static void typeFullname(String fullname) {
        fullNameLocator.waitUntil(Condition.visible, 5000).clear();
        fullNameLocator.sendKeys(fullname);
    }
    public static void typePhone(String phone) {
        phoneLocator.waitUntil(Condition.visible, 5000).clear();
        phoneLocator.sendKeys(phone);
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
