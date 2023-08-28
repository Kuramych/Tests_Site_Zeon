package generator;


import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class CatalogsGenerator {


    public List<String> getCollectedBeautyAndSportList() {
        return List.of("Велосипеды и самокаты", "Гироскутеры", "Здоровье", "Зимние виды спорта", "Косметика", "Летние виды спорта",
                "Одежда, обувь, аксессуары", "Рыбалка", "Тренажеры и инвентарь", "Туризм и активный отдых", "Хобби", "Гигиена и уход");
    }

    public List<String> getCollectedSimulatorsAndEquipmentList() {
        return List.of("Беговые дорожки", "Велотренажеры", "Гантели, гири, штанги", "Силовые тренажеры", "Степперы", "Эллиптические тренажеры",
                "Товары для йоги, фитнеса, аэробики", "Обручи", "Перчатки для единоборств", "Груши, мешки, манекены для бокса и единоборств",
                "Коврики для йоги и фитнеса", "Спортинвентарь", "Аксессуары", "Гребные тренажеры");
    }

    public List<String> getCollectedBicyclesAndScootersList() {
        return List.of("Аксессуары", "Беговелы", "Велосипеды", "Детские велосипеды", "Электросамокаты", "Велозапчасти",
                "Велосипедные насосы, манометры, шланги", "Электровелосипеды", "Велосипедные фонари", "Велоинструменты",
                "Велопокрышки, велокамеры", "Велозамки");
    }

    public List<String> getCollectedGyroscootersList() {
        return List.of("Гироциклы");
    }

    public List<String> getCollectedHealthList() {
        return List.of("Гидромассажные ванночки для ног", "Грелки", "Ингаляторы", "Ортопедические подушки", "Термометры", "Тонометры",
                "Маски для сна", "Таблетницы и контейнеры для линз", "Дезинфицирующие средства", "Медицинские маски, респираторы, защитные очки",
                "Метеостанции, гигрометры и термогигрометры", "Массажные щетки и мочалки", "Рециркуляторы, бактерицидные светильники", "Прочее",
                "Приборы для физиотерапии");
    }

    public List<String> getCollectedWinterSportsList() {
        return List.of("Коньки", "Лыжи", "Санки", "Аксессуары для горнолыжного спорта");
    }

    public List<String> getCollectedCosmeticsList() {
        return List.of("Аксессуары и принадлежности для макияжа", "Ламинирование, окрашивание и наращивание бровей и ресниц",
                "Средства для бороды и усов", "Средства для укладки волос", "Средства для депиляции",
                "Декоративная и уходовая косметика для ногтей", "Средства для загара, автозагар", "Декоративная косметика для губ",
                "Декоративная косметика для лица", "Косметички и органайзеры для косметики", "Декоративная косметика для глаз",
                "Косметика по уходу за телом", "Косметика по уходу за лицом", "Косметика по уходу за волосами");
    }

    public List<String> getCollectedSummerSportsList() {
        return List.of("Скейтборды, лонгборды", "Теннисные столы", "Сапборды", "Очки, шапочки, ласты, круги и прочие товары для плавания",
                "Ракетки для большого тенниса", "Аксессуары для большого тенниса", "Ракетки, мячи и аксессуары для настольного тенниса",
                "Игры");
    }

    public List<String> getCollectedClothesShoesAccessoriesList() {
        return List.of("Наручные часы", "Ремни", "Рюкзаки","Бижутерия и аксессуары для красоты", "Зонты, дождевики", "Солнцезащитные очки и аксессуары",
                "Аксессуары для очков", "Хранение одежды и обуви", "Тапочки", "Бижутерия", "Женские и мужские сумки",
                "Товары для ухода за обувью и одеждой", "Шкатулки для украшений и часов", "Кошельки");
    }

    public List<String> getCollectedFishingList() {
        return List.of("Ледобуры для рыбалки", "Лодочные моторы", "Эхолоты", "Крючки", "Прикормки, наживки и ароматизаторы",
                "Удилища", "Рыболовные ящики, сумки, чехлы", "Аксессуары", "Одежда для охоты, рыбалки", "Оснастка",
                "Приманки", "Рыболовные катушки");
    }

    public List<String> getCollectedTourismAndActiveRecreationList() {
        return List.of("Бинокли и подзорные трубы", "Кемпинговая мебель", "Надувные лодки", "Палатки", "Раскладная Мебель",
                "Спальные мешки", "Туристические горелки и плиты", "Туристические коврики","Туристические навигаторы", "Туристические ножи",
                "Фонари", "Замки для чемоданов", "Подушки для путешествий", "Металлоискатели",
                "Аксессуары для туризма", "Дорожные и спортивные сумки", "Чемоданы, сумки-тележки", "Бутылки для воды",
                "Туристическая посуда", "Термосумки", "Палки для скандинавской ходьбы");
    }

    public List<String> getCollectedHobbyList () {
        return List.of( "Радиоуправляемые авиамодели", "Телескопы", "Картины по номерам, алмазная мозаика",
                "Спицы, крючки, пряжа, аксессуары и наборы для вязания", "Товары для вышивания",
                "Радиоуправляемые судомодели", "Радиоуправляемые автомодели" );
    }

    public List<String> getCollectedHygieneAndCareList () {
        return List.of( "Зубные щетки и аксессуары", "Гигиенические прокладки, тампоны и менструальные чаши",
                "Туалетная бумага, бумажные полотенца и салфетки", "Антисептики для кожи", "Влажные салфетки",
                "Дезодоранты и антиперспиранты", "Средства для ухода за полостью рта", "Средства для бритья",
                "Щетки, расчески, брашинги и бигуди", "Инструменты для маникюра и педикюра",
                "Парикмахерские инструменты и принадлежности", "Аппараты для маникюра и педикюра", "Бритвенные станки",
                "Массажеры", "Зубные щетки и ирригаторы", "Средства для окрашивания волос",
                "Аксессуары к товарам для красоты и здоровья", "Парфюмерия", "Приборы для ухода за кожей",
                "Прокладки для груди", "Ватные диски, палочки", "Подгузники для взрослых, трусики" );
    }

    @Step("Создан заготовленный список раздела '{catalogName}'.")
    public List<String> getCollectedListByName (String catalogName){
        return switch (catalogName) {
            case "Красота и спорт" -> getCollectedBeautyAndSportList();
            case "Тренажеры и инвентарь" -> getCollectedSimulatorsAndEquipmentList();
            case "Велосипеды и самокаты" -> getCollectedBicyclesAndScootersList();
            case "Гироскутеры" -> getCollectedGyroscootersList();
            case "Здоровье" -> getCollectedHealthList();
            case "Зимние виды спорта" -> getCollectedWinterSportsList();
            case "Косметика" -> getCollectedCosmeticsList();
            case "Летние виды спорта" -> getCollectedSummerSportsList();
            case "Одежда, обувь, аксессуары" -> getCollectedClothesShoesAccessoriesList();
            case "Рыбалка" -> getCollectedFishingList();
            case "Туризм и активный отдых" -> getCollectedTourismAndActiveRecreationList();
            case "Хобби" -> getCollectedHobbyList();
            case "Гигиена и уход" -> getCollectedHygieneAndCareList();
            default -> new ArrayList<>();
        };
    }
}





















/*
    @Step("Создан заготовленный список раздела '{name}'.")
    public List<String> getCollectedListByName(String name) {
        switch (name) {
            case "Красота и спорт":
                return getCollectedBeautyAndSportList();
            case "Велосипеды и самокаты":
                return getCollectedBicyclesAndScootersList();
            case "Гироскутеры":
                return getCollectedGyroscootersList();
            case "Здоровье":
                return getCollectedHealthList();
            case "Зимние виды спорта":
                return getCollectedWinterSportsList();
            case "Косметика":
                return getCollectedCosmeticsList();
            case "Летние виды спорта":
                return getCollectedSummerSportsList();
            case "Одежда, обувь, аксессуары":
                return getCollectedClothesShoesAccessoriesList();
            case "Рыбалка":
                return getCollectedFishingList();
            case "Тренажеры и инвентарь":
                return getCollectedSimulatorsAndEquipmentList();
            case "Туризм и активный отдых":
                return getCollectedTourismAndActiveRecreationList();
            case "Хобби":
                return getCollectedHobbyList();
            case "Гигиена и уход":
                return getCollectedHygieneAndCareList();
            default:
                return new ArrayList<>();
        }
    }

 */


