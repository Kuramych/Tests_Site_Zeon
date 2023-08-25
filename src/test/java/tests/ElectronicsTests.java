package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import generator.CatalogsGenerator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CablesAdaptersSplittersPage;
import pageObjects.HomePage;
import pageObjects.MenuPage;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsTests extends TestsBase{


    String catalogName = "Электроника";
    String subcatalogName = "Кабели, адаптеры, разветвители";
    String brandName = "BASEUS";
    HomePage homePage = new HomePage();


    @Test(description = "Проверка раздела 'Красота и спорт' на содержание.")
    public void test1CablesAdaptersSplittersPage() {
        MenuPage menuPage = homePage.goToMenuPage();
        menuPage.initCatalogFromMenuPage(catalogName);
        CablesAdaptersSplittersPage cablesAdaptersSplittersPage = menuPage.goToCablesAdaptersSplittersSubcatalog(subcatalogName);
        cablesAdaptersSplittersPage.selectAvailabilitySubjects();
        cablesAdaptersSplittersPage.selectBrandByName(brandName);
        List<SelenideElement> itemsList = cablesAdaptersSplittersPage.getCatalogItemsList();
        cablesAdaptersSplittersPage.checkAvailabilityAndBrandName(itemsList);
        System.out.println("11");
        //Assert.assertEquals(itemsList, collectedList);
    }

}
