package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import property.PropertiesHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static SelenideElement usernameLocator = $(By.name("login"));
    private static SelenideElement passwordLocator = $(By.name("pwd"));
    private static SelenideElement initSignInButton = $(By.xpath("//header[@id='header']/div[2]/div/div[4]/div[2]/button/i"));
    private static SelenideElement signInButton = $(By.linkText("Войти"));
    private static SelenideElement submitLoginButton = $(By.xpath("//div[@id='dialog_login']/form/div[2]/button"));

    @Step("Ввод username: {username}")
    public static void typeUsername(String username) {
        $(usernameLocator).waitUntil(Condition.visible, 5000).clear();
        $(usernameLocator).waitUntil(Condition.visible, 5000).sendKeys(username);
    }

    @Step("Ввод password: {password}")
    public static void typePassword(String password) {
        $(passwordLocator).waitUntil(Condition.visible, 5000).clear();
        $(passwordLocator).waitUntil(Condition.visible, 5000).sendKeys(password);
    }

    @Step("Открыта страницы для входа")
    public static void initLoginPage() {
        initSignInButton.click();
        signInButton.click();
    }

    @Step("Вход подтвержден, выполняется переход на главную страницу.")
    public static HomePage submitLogin() {
        submitLoginButton.click();
        return new HomePage();
    }

    @Step("Выполнен вход с данными username: {username} и password: {password}")
    public static HomePage login(String username, String password) {
        initLoginPage();
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

}
