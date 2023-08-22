package tests;

import generator.CatalogsGenerator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pageObjects.BeautyAndSport;
import pageObjects.HomePage;

import java.util.ArrayList;
import java.util.List;



public class BeautyAndSportTests extends TestsBase{

    List<String> listBeautyAndSportFromSite = new ArrayList<>();
    List<String> collectedList = new ArrayList<>();
    List<String> subcatalogListFromSite = new ArrayList<>();


    @Test
    public void testBeautyAndSportCatalog() {
        HomePage.initBeautyAndSport();
        listBeautyAndSportFromSite = BeautyAndSport.getBeautyAndSportCatalog();
        collectedList = CatalogsGenerator.getCollectedBeautyAndSportList();
        for (int i = 0; i < listBeautyAndSportFromSite.size(); i++) {
            Assertions.assertThat(listBeautyAndSportFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testSimulatorsAndEquipmentSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Тренажеры и инвентарь");
        collectedList = CatalogsGenerator.getCollectedSimulatorsAndEquipmentList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testBicyclesAndScootersSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Велосипеды и самокаты");
        collectedList = CatalogsGenerator.getCollectedBicyclesAndScootersList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testGyroscootersSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Гироскутеры");
        collectedList = CatalogsGenerator.getCollectedGyroscootersList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testHealthSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Здоровье");
        collectedList = CatalogsGenerator.getCollectedHealthList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testWinterSportsSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Зимние виды спорта");
        collectedList = CatalogsGenerator.getCollectedWinterSportsList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testCosmeticsSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Косметика");
        collectedList = CatalogsGenerator.getCollectedCosmeticsList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testSummerSportsSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Летние виды спорта");
        collectedList = CatalogsGenerator.getCollectedSummerSportsList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testClothesShoesAccessoriesSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Одежда, обувь, аксессуары");
        collectedList = CatalogsGenerator.getCollectedClothesShoesAccessoriesList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testFishingSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Рыбалка");
        collectedList = CatalogsGenerator.getCollectedFishingList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testTourismAndActiveRecreationSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Туризм и активный отдых");
        collectedList = CatalogsGenerator.getCollectedTourismAndActiveRecreationList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testHobbySubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Хобби");
        collectedList = CatalogsGenerator.getCollectedHobbyList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }

    @Test
    public void testHygieneAndCareSubcatalog() {
        subcatalogListFromSite = BeautyAndSport.getbeautyAndSportSubcatalog("Гигиена и уход");
        collectedList = CatalogsGenerator.getCollectedHygieneAndCareList();
        for (int i = 0; i < subcatalogListFromSite.size(); i++) {
            Assertions.assertThat(subcatalogListFromSite.get(i)).isEqualToIgnoringWhitespace(collectedList.get(i));
        }
    }








}
