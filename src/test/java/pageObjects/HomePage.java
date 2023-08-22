package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static SelenideElement allCatalogsLocator = $(By.xpath("//header[@id='header']/div[2]/div/div[2]/button"));
    private static SelenideElement beautyAndSportButton= $(By.xpath("//section[@id='catalog']/div/nav/ul/li[8]/button"));

    @Step("Каталог 'Красота и спорт' открыт.")
    public static MenuNavigationPage initBeautyAndSport() {
        allCatalogsLocator.click();
        beautyAndSportButton.click();
        return new MenuNavigationPage();
    }
}
