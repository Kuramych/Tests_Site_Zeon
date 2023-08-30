package tests;

import generator.CatalogsGenerator;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.MenuPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Listeners(AllureTestNg.class)
@Feature("Проверка работоспособности каталогов и подкаталогов.")
public class CatalogAndSubcatalogsTests extends TestsBase{

    List<String> beautyAndSportCatalogListFromSite = new ArrayList<>();
    List<String> collectedList = new ArrayList<>();
    List<String> subcatalogListFromSite = new ArrayList<>();
    String catalogName = "Красота и спорт";


    HomePage homePage = new HomePage();
    CatalogsGenerator catalogsGenerator = new CatalogsGenerator();

    @DataProvider(name="beautyAndSportList")
    public Iterator<String> beautyAndSportList1() {
        return beautyAndSportCatalogListFromSite.iterator();
    }

    @Test(description = "Проверка раздела 'Красота и спорт' на содержание.")
    public void testCatalogFunctional() {
        SoftAssert softAssert = new SoftAssert();
        MenuPage menuPage = homePage.goToMenuPage();
        menuPage.initCatalogFromMenuPage(catalogName);
        beautyAndSportCatalogListFromSite = menuPage.getCatalogListFromSite(catalogName);
        collectedList = catalogsGenerator.getCollectedListByName(catalogName);
        softAssert.assertEquals(beautyAndSportCatalogListFromSite, collectedList, "Заготовленный список и список со страницы сайта не равны.");
        softAssert.assertAll();
    }

    @Test(dataProvider = "beautyAndSportList", description = "Проверка подкаталога, входящий в раздел 'Красота и спорт' на содержание.")
    public void testSubcatalogsFunctional(String subcatalogName) {
        SoftAssert softAssert = new SoftAssert();
        MenuPage menuPage = homePage.goToMenuPage();
        subcatalogListFromSite = menuPage.getSubcatalogListFromSite(subcatalogName);
        collectedList = catalogsGenerator.getCollectedListByName(subcatalogName);
        softAssert.assertEquals(subcatalogListFromSite, collectedList, "Заготовленный список и список со страницы сайта не равны.");
        softAssert.assertAll();
    }
}
