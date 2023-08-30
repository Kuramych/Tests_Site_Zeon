package pageObjects;

import io.qameta.allure.Step;
import model.ItemModel;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import property.PropertiesHelper;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {

    PropertiesHelper propertiesHelper = PropertiesHelper.getInstance();

    private String itemsNamesLocator = ".cart-item-product-title a";
    private String paymentMethod = "//span[text()='Наличными (у меня уже есть Клубная Карта)']";
    private String commentToOrder = "//div[@class='line-field']/textarea[@name='text']";
    private String deliveryMethod = "//span[text()='Самовывоз - бесплатно']";
    private String checkoutButton = ".btn.block.big.cart-submit";
    String finalPriceLocator = "div.cart-total-summ span.summary";
    String totalPriceFromBasketPageLocator = ".total-clubcard-price.summa_car1";



    @Step("Проверка, что выбранные товары попали в Корзину.")
    public void checkItemsNamesFromBasket(List<ItemModel> itemsFromItemsPage) {
        SoftAssert softAssert = new SoftAssert();
        List<String> itemsNamesFromItemsPage = new ArrayList<String>();
        for (ItemModel item :itemsFromItemsPage) {
            itemsNamesFromItemsPage.add(item.getName());
        }
        List<String> itemsNamesFromBasketPage = $$(itemsNamesLocator).texts();
        boolean containsAllItems = itemsNamesFromBasketPage.containsAll(itemsNamesFromItemsPage);
        softAssert.assertTrue(containsAllItems, "Проверка на соответствие элементов в корзине не прошла.");
        softAssert.assertAll();
    }

    @Step("Проверка общей стоимости в 'Корзине'.")
    public void checkTotalPrice(double totalPriceFromItemsPage) {
        SoftAssert softAssert = new SoftAssert();
        double modifyTotalPriceFromBasketPage = getModifyPriceFromBasketPage(totalPriceFromBasketPageLocator);
        softAssert.assertEquals(totalPriceFromItemsPage, modifyTotalPriceFromBasketPage,
                "Проверка на соответствие общей цены в корзине не прошла.");
        softAssert.assertAll();
    }

    @Step("Проверка финальной стоимости в 'Корзине'.")
    public void checkFinalPrice(double totalPriceFromItemsPage) {
        SoftAssert softAssert = new SoftAssert();
        double modifyFinalPriceFromBasketPage = getModifyPriceFromBasketPage(finalPriceLocator);
        softAssert.assertEquals(totalPriceFromItemsPage, modifyFinalPriceFromBasketPage,
                "Проверка на соответствие итоговой цены в корзине не прошла.");
        softAssert.assertAll();
    }

    private double getModifyPriceFromBasketPage(String totalPriceFromBasketPageLocator) {
        String totalPriceFromBasketPage = $(totalPriceFromBasketPageLocator).text();
        String[] parts = totalPriceFromBasketPage.split(" ");
        String rubles = parts[0];
        String pennies = parts[2];
        double modifyPriceFromBasketPage = Double.parseDouble(rubles + "." + pennies);
        return modifyPriceFromBasketPage;
    }

    @Step("Заказ оформлен.")
    public void fillDataAfterOrder() {
        $(By.xpath(paymentMethod)).click();
        $(By.name("nama")).clear();
        $(By.name("nama")).sendKeys(propertiesHelper.getProperty("personName"));
        $(By.name("email")).clear();
        $(By.name("email")).sendKeys(propertiesHelper.getProperty("personEmail"));
        $(By.name("city")).clear();
        $(By.name("city")).sendKeys(propertiesHelper.getProperty("personCity"));
        $(By.xpath(commentToOrder)).clear();
        $(By.xpath(commentToOrder)).sendKeys(propertiesHelper.getProperty("personComment"));
        $(By.xpath(deliveryMethod)).click();
        //$(By.xpath(checkoutButton)).click();
    }
}
