package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CablesAdaptersSplittersPage {


    String selectBrand = "//span[contains(text(), '%s')]";
    String availabilityLocator = "//label[contains(text(), 'В наличии')]";
    String selectedCatalogListLocator = ".category-item.mobile-modal[data-name=\"%s\"] .subcategory-item .subcategory-name";
    String selectedCatalogItemsListLocator = "catalog-item";

    public void selectBrandByName(String brandName) {
        String selectBrandLocator = String.format(selectBrand, brandName);
        $(By.xpath(selectBrandLocator)).click();
    }

    public void selectAvailabilitySubjects() {
        $(By.xpath(availabilityLocator)).click();
    }

    public List<SelenideElement> getCatalogItemsList() {
        return $$(By.className(selectedCatalogItemsListLocator));
    }

    public void checkAvailabilityAndBrandName(List<SelenideElement> itemList) {
        for (SelenideElement item : itemList) {
            String itemName = item.$("div.catalog-item-title a").text();
            String itemCheckAvailability = item.$("span.catalog-item-stock.instock_yes").text();
            if (! itemName.contains("Baseus") || (! itemCheckAvailability.contains("Есть в наличии"))) {
                System.out.println("Элемент " + itemName + " не прошел проверку.");
            }
        }
    }

    public List<String> putItemsToBasketPriceWithoutDiscountCard(List<SelenideElement> itemList) {
        List<String> itemsForBasket = new ArrayList<String>();
        int itemsCount = 0;
        for (SelenideElement item : itemList) {
            String itemName = item.$("div.catalog-item-title a").text();
            String itemPrice = item.$("div.catalog-item-price").text();
            double price = Double.parseDouble(itemPrice.replaceAll("[^0-9,]", "").replace(",", "."));
            if (price <= 15 && itemsCount < 2){
                itemsForBasket.add(itemName);
                item.$("div.catalog-item-store a").click();
                itemsCount++;
            }
        }
        return itemsForBasket;
    }
    public double getTotalPrice(List<SelenideElement> itemList) {
        double totalPrice = 0;
        for (SelenideElement item : itemList) {
            String itemPrice = item.$("div.catalog-item-price").text();
            double price = Double.parseDouble(itemPrice.replaceAll("[^0-9,]", "").replace(",", "."));
            totalPrice += price;
        }
        return totalPrice;
    }

    public BasketPage goToBasketPage() {
        $(new By.ById("basketCnt")).click();
        return new BasketPage();
    }
}
