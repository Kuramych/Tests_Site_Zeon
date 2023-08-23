package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static SelenideElement usernameLocator = $(By.name("login"));
    private static SelenideElement passwordLocator = $(By.name("pwd"));
    private static SelenideElement initSignInButton = $(By.xpath("//i[contains(@class, 'icon-person--bold')]"));
    private static SelenideElement signInButton = $(By.linkText("Войти"));
    private static SelenideElement submitLoginButton = $(By.xpath("//button[contains(text(),'Войти в личный кабинет')]"));


    @Step("Ввод username: {username}")
    private void typeUsername(String username) {
        usernameLocator.waitUntil(Condition.visible, 5000).clear();
        usernameLocator.sendKeys(username);
    }

    @Step("Ввод password: {password}")
    private void typePassword(String password) {
        passwordLocator.waitUntil(Condition.visible, 5000).clear();
        passwordLocator.sendKeys(password);
    }

    @Step("Открыта страницы для входа")
    private void initLoginPage() {
        initSignInButton.click();
        signInButton.click();
    }

    @Step("Вход подтвержден, выполняется переход на главную страницу.")
    private HomePage submitLogin() {
        submitLoginButton.click();
        return new HomePage();
    }

    @Step("Выполнен вход с данными username: {username} и password: {password}")
    public HomePage login(String username, String password) {
        initLoginPage();
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

}
