package pageObjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BeautyAndSport {

    private static String beautyAndSportCatalogLocator = ".category-item.mobile-modal.opened .menu-item[data-name]";
    private static String simulatorsAndEquipmentCatalogLocator = ".subcategory-item.mobile-modal[data-name='Тренажеры и инвентарь'] ul.menu-list li.menu-item";
    private static String beautyAndSportSubcatalogLocator = ".subcategory-item.mobile-modal[data-name='%s'] ul.menu-list li.menu-item";


    public static List<String> getBeautyAndSportCatalog() {
        List<SelenideElement> beautyAndSportCatalogList = $$(beautyAndSportCatalogLocator);
        List<String> catalogNames = beautyAndSportCatalogList.stream().map(element -> element.innerText()).collect(Collectors.toList());
        return catalogNames;
    }

    public static List<String> getbeautyAndSportSubcatalog(String subcatalogName) {
        String beautyAndSportSubcatalog = String.format(beautyAndSportSubcatalogLocator, subcatalogName);
        List<SelenideElement> catatogList = $$(beautyAndSportSubcatalog);
        List<String> catalogNames = catatogList.stream().map(element -> element.innerText()).collect(Collectors.toList());
        return catalogNames;
    }




}
