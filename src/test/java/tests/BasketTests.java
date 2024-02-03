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

import static java.lang.Thread.sleep;

@Feature("Проверка работоспособности 'Корзины'.")
public class BasketTests extends TestsBase {

    HomePage homePage = new HomePage();
    String catalogName = "Электроника";
    String subcatalogName = "Кабели, адаптеры, разветвители";
    String brandName = "BASEUS";
    double checkPrice = 20.0;
    int itemsNumber = 2;



    @Test(description = "Тестирование добавления предметов в 'Корзину' и подсчета финальной суммы.")
    public void testBasket() throws InterruptedException {
        MenuPage menuPage = homePage.goToMenuPage();
        menuPage.initCatalogFromMenuPage(catalogName);
        ItemsPage itemsPage = menuPage.goToSubcatalog(subcatalogName);

        itemsPage.setAvailabilityFilter();
        itemsPage.setBrandByName(brandName);

        List<SelenideElement> itemsList = itemsPage.getCatalogItemsList();
        sleep(1000);
        List<ItemModel> basketItems = itemsPage.putItemsToBasket(itemsList, checkPrice, itemsNumber);

        double totalPriceFromItemsPage = itemsPage.getTotalPrice(basketItems);
        BasketPage basketPage = itemsPage.goToBasketPage();

        basketPage.checkItemsNamesFromBasket(basketItems);
        basketPage.checkTotalPrice(totalPriceFromItemsPage);
        basketPage.checkFinalPrice(totalPriceFromItemsPage);
        basketPage.fillDataAfterOrder();
    }
}
