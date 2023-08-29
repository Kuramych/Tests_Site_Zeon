package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ItemsPage;
import pageObjects.HomePage;
import pageObjects.MenuPage;

import java.util.List;


@Feature("Функциональности кнопки 'В наличии' и выбора бренда.")
public class AvailabilityAndBrandTests extends TestsBase{

    String catalogName = "Электроника";
    String subcatalogName = "Кабели, адаптеры, разветвители";
    String brandName = "BASEUS";
    HomePage homePage = new HomePage();


    @Test(description = "Проверка работоспособности кнопки 'В наличии' и выбора бренда.")
    public void testAvailabilityAndBrandFunctional() {
        MenuPage menuPage = homePage.goToMenuPage();
        menuPage.initCatalogFromMenuPage(catalogName);
        ItemsPage itemsPage = menuPage.goToSubcatalog(subcatalogName);

        itemsPage.installAvailabilityFilter();
        itemsPage.selectBrandByName(brandName);
        List<SelenideElement> itemsList = itemsPage.getCatalogItemsList();

        itemsPage.checkAvailabilityAndBrandName(itemsList, brandName);
    }
}
