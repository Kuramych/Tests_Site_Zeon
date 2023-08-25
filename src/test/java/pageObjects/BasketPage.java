package pageObjects;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {

    private String itemsNamesLocator = ".cart-item-product-title a";
    private String totalPriceLocator = ".total-clubcard-price.summa_car1";


    public void checkItemsNamesFromBasket(List<String> itemsNames) {
        List<String> itemsBasketList = $$(itemsNamesLocator).texts();
        boolean containsAllItems = itemsBasketList.containsAll(itemsNames);
        if (! containsAllItems){
            System.out.println("Проверка на соответствие элементов в корзине не прошла.");
        }
        System.out.println("11");
    }

    public void checkTotalPriceFromBasket(double totalPriceFromCablesAdaptersSplittersPage) {
        String totalPriceChar = $(totalPriceLocator).text();
        double totalPriceFromBasketPage = Double.parseDouble(totalPriceChar.replaceAll("[^0-9]", "").replace("\\.(?=.*\\.)", "."));
        if (totalPriceFromCablesAdaptersSplittersPage != totalPriceFromBasketPage){
            System.out.println("Проверка на соответствие общей цены в корзине не прошла.");
        }
    }
}
