package pageObjects;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class MenuNavigationPage {

    private static String beautyAndSportCatalogLocator = ".category-item.mobile-modal.opened .menu-item[data-name]";
    private static String beautyAndSportSubcatalogLocator = ".subcategory-item.mobile-modal[data-name='%s'] ul.menu-list li.menu-item";


    @Step("Получены все подкаталоги, расположенные в разделе 'Красота и спорт'.")
    public static List<String> getBeautyAndSportCatalog() {
        List<SelenideElement> beautyAndSportCatalogList = $$(beautyAndSportCatalogLocator);
        List<String> catalogNames = beautyAndSportCatalogList.stream().map(element -> element.innerText().trim()).collect(Collectors.toList());
        return catalogNames;
    }

    @Step("Получено содержание подкаталога '{subcatalogName}'.")
    public static List<String> getbeautyAndSportSubcatalog(String subcatalogName) {
        String beautyAndSportSubcatalog = String.format(beautyAndSportSubcatalogLocator, subcatalogName);
        List<SelenideElement> catatogList = $$(beautyAndSportSubcatalog);
        List<String> catalogNames = catatogList.stream().map(element -> element.innerText().trim()).collect(Collectors.toList());
        return catalogNames;
    }
}
