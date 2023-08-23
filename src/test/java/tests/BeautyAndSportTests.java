package tests;

import generator.CatalogsGenerator;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Listeners(AllureTestNg.class)
@Feature("Тестирование сайта Zeon.by")
public class BeautyAndSportTests extends TestsBase{

    List<String> BeautyAndSportCatalogListFromSite = new ArrayList<>();
    List<String> collectedList = new ArrayList<>();
    List<String> subcatalogListFromSite = new ArrayList<>();


    @DataProvider(name="beautyAndSportList")
    public Iterator<String> beautyAndSportList1() {
        return BeautyAndSportCatalogListFromSite.iterator();
    }

    @Test(description = "Проверка раздела 'Красота и спорт' на содержание.")
    public void testBeautyAndSportCatalog() {
        String catalogName = "Красота и спорт";
        HomePage.initCatalogFromNavigationPage(catalogName);
        BeautyAndSportCatalogListFromSite = HomePage.getCatalogListFromSite();
        collectedList = CatalogsGenerator.getCollectedListByName(catalogName);
        Assert.assertEquals(BeautyAndSportCatalogListFromSite, collectedList);
    }

    @Test(dataProvider = "beautyAndSportList", description = "Проверка подкаталога, входящий в раздел 'Красота и спорт' на содержание.")
    public void testBeautyAndSportSubcatalogs(String name) {
        subcatalogListFromSite = HomePage.getSubcatalogListFromSite(name);
        collectedList = CatalogsGenerator.getCollectedListByName(name);
        Assert.assertEquals(subcatalogListFromSite, collectedList);
    }
}
