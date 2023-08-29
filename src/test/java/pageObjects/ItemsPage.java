package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.ItemModel;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class ItemsPage {


    String selectBrand = "//span[contains(text(), '%s')]";
    String  availabilityLocator = "span.catalog-item-stock.instock_yes";
    String addToBasketLocator = "div.catalog-item-store a";
    String itemPriceLocator = "div.catalog-item-price";
    String itemNameLocator = "div.catalog-item-title a";



    @Step("Выбран бренд '{brandName}'.")
    public void selectBrandByName(String brandName) {
        String selectBrandLocator = String.format(selectBrand, brandName);
        $(By.xpath(selectBrandLocator)).click();
    }

    @Step("Выбраны предметы, которые 'В наличии' на данный момент.")
    public void installAvailabilityFilter() {
        $(By.name("inorder")).click();
        $(By.name("inorder")).waitUntil(attribute("checked", "true"), 10000);
    }

    @Step("Получен актуальный список товаров.")
    public List<SelenideElement> getCatalogItemsList() {
        return $$(By.className("catalog-item"));
    }

    @Step("Проверка, что все выведенные товары имеют плашку 'Есть в наличии' и текст '{brandName}'")
    public void checkAvailabilityAndBrandName(List<SelenideElement> itemsList, String brandName) {
        boolean flag = false;
        for (SelenideElement item : itemsList) {
            String itemName = item.$(itemNameLocator).text();
            String itemCheckAvailability = item.$(availabilityLocator).text();
            if (! itemName.contains(brandName) || (! itemCheckAvailability.contains("Есть в наличии")))  {
                flag = false;
            }
            flag = true;
        }
        Assert.assertTrue(flag, "Проверка кнопки 'В наличии' и выбора бренда не прошла.");
    }
/*
    @Step("Добавлены два предмета в 'Корзину', у которых цена меньше 15 рублей без учеба дисконтной карты.")
    public List<ItemModel> putItemsToBasketPriceWithoutDiscountCard(List<SelenideElement> itemsList) {
        List<ItemModel> itemsToBasket = new ArrayList<ItemModel>();
        int itemsToBasketCount = 0;
        for (SelenideElement item : itemsList) {
            String itemName = item.$(itemNameLocator).text();
            String itemPrice = item.$(itemPriceLocator).text();
            double modifyItemPrice = Double.parseDouble(itemPrice.replaceAll("[^0-9,]", "").replace(",", "."));
            if (modifyItemPrice <= 15 && itemsToBasketCount < 2){
                ItemModel itemForBasket =  new ItemModel();
                itemsToBasket.add(itemForBasket.withName(itemName).withPrice(modifyItemPrice));
                item.$(addToBasketLocator).click();
                itemsToBasketCount++;
            }
        }
        return itemsToBasket;
    }

 */

    @Step("Добавлены {itemsNumber} предмета в 'Корзину', у которых цена меньше {checkPrice} рублей без учеба дисконтной карты.")
    public List<ItemModel> putItemsToBasketPriceWithoutDiscountCard(List<SelenideElement> itemsList, double checkPrice, int itemsNumber)
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
        return totalItemsPrice;
    }

    @Step("Выполнен переход в 'Корзину'.")
    public BasketPage goToBasketPage() {
        $(new By.ById("basketCnt")).click();
        return new BasketPage();
    }
}
