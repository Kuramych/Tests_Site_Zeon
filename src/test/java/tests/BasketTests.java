package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import pageObjects.BasketPage;
import pageObjects.CablesAdaptersSplittersPage;
import pageObjects.HomePage;
import pageObjects.MenuPage;

import java.util.List;

public class BasketTests extends TestsBase {

    HomePage homePage = new HomePage();
    String catalogName = "Электроника";
    String subcatalogName = "Кабели, адаптеры, разветвители";
    String brandName = "BASEUS";

    @Test
    private void testBasket() {
        MenuPage menuPage = homePage.goToMenuPage();
        menuPage.initCatalogFromMenuPage(catalogName);
        CablesAdaptersSplittersPage cablesAdaptersSplittersPage = menuPage.goToCablesAdaptersSplittersSubcatalog(subcatalogName);
        cablesAdaptersSplittersPage.selectAvailabilitySubjects();
        cablesAdaptersSplittersPage.selectBrandByName(brandName);
        List<SelenideElement> itemsListFromCablesAdaptersSplittersPage = cablesAdaptersSplittersPage.getCatalogItemsList();
        List<String> itemsNamesFromCablesAdaptersSplittersPage = cablesAdaptersSplittersPage.putItemsToBasketPriceWithoutDiscountCard(itemsListFromCablesAdaptersSplittersPage);
        BasketPage basketPage = cablesAdaptersSplittersPage.goToBasketPage();
        basketPage.checkItemsNamesFromBasket(itemsNamesFromCablesAdaptersSplittersPage);
        double totalPriceFromCablesAdaptersSplittersPage = cablesAdaptersSplittersPage.getTotalPrice(itemsListFromCablesAdaptersSplittersPage);
        basketPage.checkTotalPriceFromBasket(totalPriceFromCablesAdaptersSplittersPage);
        System.out.println("111");
    }
}
