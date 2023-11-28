package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.ItemModel;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class ItemsPage {


    String selectBrand = "//span[contains(text(), '%s')]";
    String  availabilityLocator = "span.catalog-item-stock.instock_yes";
    String addToBasketLocator = "div.catalog-item-store a";
    String itemPriceLocator = "div.catalog-item-price";
    String itemNameLocator = "div.catalog-item-title a";




    @Step("Выбран бренд '{brandName}'.")
    public void setBrandByName(String brandName) {
        String selectBrandLocator = String.format(selectBrand, brandName);
        $(By.xpath(selectBrandLocator)).click();
    }

    @Step("Выбраны предметы, которые 'В наличии' на данный момент.")
    public void setAvailabilityFilter() {
        $(By.name("inorder")).click();
        //$(By.name("inorder")).waitUntil(attribute("checked", "true"), 10000);
        $(By.name("inorder")).shouldBe(attribute("checked", "true"));
    }

    @Step("Получен актуальный список товаров.")
    public List<SelenideElement> getCatalogItemsList() {
        return $$(By.className("catalog-item"));
    }

    @Step("Проверка, что все выведенные товары имеют плашку '{availability}' и текст '{brandName}'")
    public void checkAvailabilityAndBrandName(List<SelenideElement> itemsList, String brandName, String availability) {
        SoftAssert softAssert = new SoftAssert();
        for (SelenideElement item : itemsList) {
            String itemName = item.$(itemNameLocator).text();
            String itemCheckAvailability = item.$(availabilityLocator).text();
            softAssert.assertTrue(itemName.contains(brandName), "Товар " + itemName + " не содержит бренд " + brandName + ".");
            softAssert.assertTrue(itemCheckAvailability.contains(availability),  "Товар " + itemName + " не содержит текст " + availability + ".");
            softAssert.assertAll();
        }
    }

    @Step("Добавлены {itemsNumber} предмета в 'Корзину', у которых цена меньше {checkPrice} рублей без учеба дисконтной карты.")
    public List<ItemModel> putItemsToBasket(List<SelenideElement> itemsList, double checkPrice, int itemsNumber)
    {
        List<ItemModel> itemsToBasket = new ArrayList<ItemModel>();
        int itemsToBasketCount = 0;
        for (SelenideElement item : itemsList) {
            String itemName = item.$(itemNameLocator).text();
            String itemPrice = item.$(itemPriceLocator).text();
            double modifyItemPrice = Double.parseDouble(itemPrice.replaceAll("[^0-9,]", "").replace(",", "."));
            if (modifyItemPrice <= checkPrice && itemsToBasketCount < itemsNumber){
                ItemModel itemForBasket =  new ItemModel();
                itemsToBasket.add(itemForBasket.withName(itemName).withPrice(modifyItemPrice));
                item.$(addToBasketLocator).click();
                itemsToBasketCount++;
            }
        }
        Assert.assertEquals(itemsNumber, itemsToBasket.size(), "Недостаточно предметов для 'Корзины'.");
        return itemsToBasket;
    }

    @Step("Получена общая цена выбранных предметов из страницы подкаталога.")
    public double getTotalPrice(List<ItemModel> itemList) {
        double totalItemsPrice = 0;
        for (ItemModel item : itemList) {
            double itemPrice = item.getPrice();
            totalItemsPrice += itemPrice;
        }
        return Math.round(totalItemsPrice * 10) / 10.0;
    }

    @Step("Выполнен переход в 'Корзину'.")
    public BasketPage goToBasketPage() {
        $(By.id("basketCnt")).click();
        return new BasketPage();
    }
}
