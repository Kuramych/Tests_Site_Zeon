package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import model.ItemModel;
import org.testng.annotations.Test;
import pageObjects.BasketPage;
import pageObjects.ItemsPage;
import pageObjects.HomePage;
import pageObjects.MenuPage;

import java.util.List;

@Feature("Тестирование функциональности 'Корзины' сайта Zeon.by")
public class BasketTests extends TestsBase {

    HomePage homePage = new HomePage();
    String catalogName = "Электроника";
    String subcatalogName = "Кабели, адаптеры, разветвители";
    String brandName = "BASEUS";

    @Test(description = "Тестирование 'Корзины'.")
    private void testBasket() {
        MenuPage menuPage = homePage.goToMenuPage();
        menuPage.initCatalogFromMenuPage(catalogName);
        ItemsPage itemsPage = menuPage.goToSubcatalog(subcatalogName);
        itemsPage.selectAvailabilityItems();
        itemsPage.selectBrandByName(brandName);
        List<SelenideElement> itemsListFromCablesAdaptersSplittersPage = itemsPage.getCatalogItemsList();
        List<ItemModel> itemsNamesFromCablesAdaptersSplittersPage = itemsPage.putItemsToBasketPriceWithoutDiscountCard(itemsListFromCablesAdaptersSplittersPage);
        double totalPriceFromCablesAdaptersSplittersPage = itemsPage.getTotalPrice(itemsNamesFromCablesAdaptersSplittersPage);
        BasketPage basketPage = itemsPage.goToBasketPage();
        basketPage.checkItemsNamesFromBasket(itemsNamesFromCablesAdaptersSplittersPage);
        basketPage.checkTotalPriceFromBasket(totalPriceFromCablesAdaptersSplittersPage);
        basketPage.dataAfterOrder();
    }
}
