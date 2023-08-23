package tests;

import generator.CatalogsGenerator;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MenuPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Listeners(AllureTestNg.class)
@Feature("Тестирование раздела 'Красота и спорт' сайта Zeon.by")
public class BeautyAndSportTests extends TestsBase{

    List<String> BeautyAndSportCatalogListFromSite = new ArrayList<>();
    List<String> collectedList = new ArrayList<>();
    List<String> subcatalogListFromSite = new ArrayList<>();
    String catalogName = "Красота и спорт";


    HomePage homePage = new HomePage();
    CatalogsGenerator catalogsGenerator = new CatalogsGenerator();


    @DataProvider(name="beautyAndSportList")
    public Iterator<String> beautyAndSportList1() {
        return BeautyAndSportCatalogListFromSite.iterator();
    }

    @Test(description = "Проверка раздела 'Красота и спорт' на содержание.")
    public void test1BeautyAndSportCatalog() {
        MenuPage menuPage = homePage.goToMenuPage();
        menuPage.initCatalogFromMenuPage(catalogName);
        BeautyAndSportCatalogListFromSite = menuPage.getCatalogListFromSite(catalogName);
        collectedList = catalogsGenerator.getCollectedListByName(catalogName);
        Assert.assertEquals(BeautyAndSportCatalogListFromSite, collectedList);
    }

    @Test(dataProvider = "beautyAndSportList", description = "Проверка подкаталога, входящий в раздел 'Красота и спорт' на содержание.")
    public void test2BeautyAndSportSubcatalogs(String name) {
        MenuPage menuPage = homePage.goToMenuPage();
        subcatalogListFromSite = menuPage.getSubcatalogListFromSite(name);
        collectedList = catalogsGenerator.getCollectedListByName(name);
        Assert.assertEquals(subcatalogListFromSite, collectedList);
    }
}
