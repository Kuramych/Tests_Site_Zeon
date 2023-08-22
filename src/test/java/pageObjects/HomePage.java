package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static SelenideElement initBeautyAndSportCatalogLocator = $(By.xpath("//header[@id='header']/div[2]/div/div[2]/button"));
    private static SelenideElement beautyAndSportButton= $(By.xpath("//section[@id='catalog']/div/nav/ul/li[8]/button"));


    public static BeautyAndSport initBeautyAndSport() {
        initBeautyAndSportCatalogLocator.click();
        beautyAndSportButton.click();
        return new BeautyAndSport();
    }
}
