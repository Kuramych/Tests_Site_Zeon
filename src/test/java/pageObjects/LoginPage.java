package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static SelenideElement usernameLocator = $(By.name("login"));
    private static SelenideElement passwordLocator = $(By.name("pwd"));
    private static SelenideElement initSignInButton = $(By.xpath("//header[@id='header']/div[2]/div/div[4]/div[2]/button/i"));
    private static SelenideElement signInButton = $(By.linkText("Войти"));
    private static SelenideElement submitLoginButton = $(By.xpath("//div[@id='dialog_login']/form/div[2]/button"));


    public static void typeUsername(String username) {
        $(usernameLocator).waitUntil(Condition.visible, 5000).clear();
        $(usernameLocator).waitUntil(Condition.visible, 5000).sendKeys(username);
    }

    public static void typePassword(String password) {
        $(passwordLocator).waitUntil(Condition.visible, 5000).clear();
        $(passwordLocator).waitUntil(Condition.visible, 5000).sendKeys(password);
    }

    public static void initLoginPage() {
        initSignInButton.click();
        signInButton.click();
    }

    public static HomePage submitLogin() {
        submitLoginButton.click();
        return new HomePage();
    }

    public static HomePage login(String username, String password) {
        initLoginPage();
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

}
