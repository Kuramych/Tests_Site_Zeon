package tests;

import generator.CatalogsGenerator;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.MenuNavigationPage;
import pageObjects.HomePage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Listeners(AllureTestNg.class)
@Feature("Тестирование сайта Zeon.by1")
public class BeautyAndSportTests extends TestsBase{

    List<String> listBeautyAndSportFromSite = new ArrayList<>();
    List<String> collectedList = new ArrayList<>();
    List<String> subcatalogListFromSite = new ArrayList<>();


    @DataProvider(name="beautyAndSportList")
    public Iterator<String> beautyAndSportList1() {
        return listBeautyAndSportFromSite.iterator();
    }


    @Test(description = "Проверка раздела 'Красота и спорт' на содержание.")
    public void testBeautyAndSportCatalog() {
        HomePage.initBeautyAndSport();
        listBeautyAndSportFromSite = MenuNavigationPage.getBeautyAndSportCatalog();
        collectedList = CatalogsGenerator.getCollectedBeautyAndSportList();
        Assert.assertEquals(listBeautyAndSportFromSite, collectedList);
    }

    @Test(dataProvider = "beautyAndSportList", description = "Проверка подкаталога, входящий в раздел 'Красота и спорт' на содержание.")
    public void testBeautyAndSportSubcatalogs(String name) {
        subcatalogListFromSite = MenuNavigationPage.getbeautyAndSportSubcatalog(name.trim());
        collectedList = CatalogsGenerator.getCollectedListByName(name);
        Assert.assertEquals(subcatalogListFromSite, collectedList);
    }

}
