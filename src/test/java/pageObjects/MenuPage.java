package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MenuPage {

    private String commonCatalogLocator = "//ul[contains(@class, 'menu-list') and contains(@class, 'nav-list')]//li[@data-name='%s']";
    private String selectedCatalogListLocator = ".category-item.mobile-modal[data-name=\"%s\"] .subcategory-item .subcategory-name";
    private String selectedSubcatalogLocator = ".subcategory-item.mobile-modal[data-name='%s'] ul.menu-list li.menu-item";



    @Step("Каталог '{catalogName}' открыт.")
    public void goToSelectCatalog(String catalogName) {
        String seletedCatalog = String.format(String.valueOf(commonCatalogLocator), catalogName);
        $(By.xpath(seletedCatalog)).click();
    }

    @Step("Инициализация каталога '{catalogName}'.")
    public void initCatalogFromMenuPage(String catalogName) {
        goToSelectCatalog(catalogName);
    }

    @Step("Получены все разделы заданного каталога.")
    public List<String> getCatalogListFromSite(String catalogName) {
        String CatalogListLocator = String.format(selectedCatalogListLocator, catalogName);
        List<String> catalogNames = $$(CatalogListLocator).texts();
        return catalogNames;
    }

    @Step("Получено содержание подкаталога '{subcatalogName}'.")
    public List<String> getSubcatalogListFromSite(String subcatalogName) {
        String subcatalogListLocator = String.format(selectedSubcatalogLocator, subcatalogName);
        List<String> namesFromCatalog = $$(subcatalogListLocator).texts();
        return namesFromCatalog;
    }
}
