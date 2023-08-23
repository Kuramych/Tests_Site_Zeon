package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;




import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement allCatalogsLocator = $(By.xpath("//div[contains(@class, 'catalog hidden-xs hidden-sm')]"));


    @Step("Меню навигации открыто.")
    public MenuPage goToMenuPage() {
        SelenideElement flag = $(By.xpath("//div[contains(@class, 'catalog hidden-xs hidden-sm opened')]"));
        if (!flag.exists()) {
            allCatalogsLocator.click();
        }
        return new MenuPage();
    }



}
