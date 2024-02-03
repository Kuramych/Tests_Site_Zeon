package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pageObjects.ItemsPage;
import pageObjects.HomePage;
import pageObjects.MenuPage;

import java.util.List;

import static java.lang.Thread.sleep;


@Feature("Функциональности кнопки 'В наличии' и выбора бренда.")
public class AvailabilityAndBrandTests extends TestsBase{

    String catalogName = "Электроника";
    String subcatalogName = "Кабели, адаптеры, разветвители";
    String brandName = "BASEUS";
    String brandNameInItemName = "Baseus";
    String availability = "Есть в наличии";
    HomePage homePage = new HomePage();


    @Test(description = "Проверка работоспособности кнопки 'В наличии' и выбора бренда.")
    public void testAvailabilityAndBrandFunctional() throws InterruptedException {
        MenuPage menuPage = homePage.goToMenuPage();
        menuPage.initCatalogFromMenuPage(catalogName);
        ItemsPage itemsPage = menuPage.goToSubcatalog(subcatalogName);

        itemsPage.setAvailabilityFilter();
        itemsPage.setBrandByName(brandName);
        sleep(1000);
        List<SelenideElement> itemsList = itemsPage.getCatalogItemsList();

        itemsPage.checkAvailabilityAndBrandName(itemsList, brandNameInItemName, availability);
    }
}
