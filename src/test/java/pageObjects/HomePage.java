package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    private static SelenideElement allCatalogsLocator = $(By.xpath("//header[@id='header']/div[2]/div/div[2]/button"));
    private static SelenideElement beautyAndSportButton= $(By.xpath("//section[@id='catalog']/div/nav/ul/li[8]/button"));
    private static String commonCatalogLocator = ("//li[contains(@class, 'menu-item') and @data-name='%s']");
    private static String selectedCatalogListLocator = ".category-item.mobile-modal.opened .menu-item[data-name]";
    private static String selectedSubcatalogLocator = ".subcategory-item.mobile-modal[data-name='%s'] ul.menu-list li.menu-item";


    @Step("Меню навигации открыто.")
    private static void goToNavigationMenu() {
        allCatalogsLocator.click();
    }

    @Step("Каталог '{catalogName}' открыт.")
    public static void goToSelectCatalog(String catalogName) {
        String seletedCatalog =  String.format(commonCatalogLocator, catalogName);
        $(By.xpath(seletedCatalog)).click();
    }

    @Step("Инициализация каталога '{catalogName}'.")
    public static void initCatalogFromNavigationPage(String catalogName) {
        goToNavigationMenu();
        goToSelectCatalog(catalogName);
    }

    @Step("Получены все разделы заданного каталога.")
    public static List<String> getCatalogListFromSite() {
        List<SelenideElement> beautyAndSportCatalogList = $$(selectedCatalogListLocator);
        List<String> catalogNames = beautyAndSportCatalogList.stream().map(element -> element.innerText().trim()).collect(Collectors.toList());
        return catalogNames;
    }

    @Step("Получено содержание подкаталога '{subcatalogName}'.")
    public static List<String> getSubcatalogListFromSite(String subcatalogName) {
        String beautyAndSportSubcatalog = String.format(selectedSubcatalogLocator, subcatalogName);
        List<SelenideElement> catatogList = $$(beautyAndSportSubcatalog);
        List<String> catalogNames = catatogList.stream().map(element -> element.innerText().trim()).collect(Collectors.toList());
        return catalogNames;
    }


}
