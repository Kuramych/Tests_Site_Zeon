# Tests_Site_Zeon(тестирование некоторого функционала сайта https://www.777555.by)

### Пакет tests:
+ Класс AvailabilityAndBrandTests:проверка функциональности кнопки 'В наличии' и выбора бренда.
+ Класс BasketTests: проверка работоспособности 'Корзины': добавления предметов, подсчет финальной и итоговой суммы.
+ Класс CatalogAndSubcatalogsTests: проверка работы каталогов и подкаталогов на их содержание.
+ Класс TestsBase: инициализация браузера и его закрытие, выполнение логина.

### Пакет property:
+ Класс PropertiesHelper: установка свойств, которые подгружаются в других классах из файла local.properties.

### Пакет pageObjects:
+ Класс BasketPage: проверка, что выбранные товары попали в Корзину, проверка общей стоимости товаров, проверка финальной стоимости, оформление заказа.
+ Класс HomePage: инициализация меню навигации (класс MenuPage).
+ Класс MenuPage: инициализация выбранного каталога, получение наполнения выбранного каталога и подкаталога.
+ Класс ItemsPage: выбор бренда, установка плашки "Есть в наличии", получения списка товара, проверка что все выведенные товары имеют плашку "Есть в наличии" и заданный бренд, добавление товара в "Корзину", получение общей цены товара, переход в "Корзину".
+ Класс LoginPage: описания логики входа на сайт.
+ Класс RegistrationPage: описания логики регистрации.

### Пакет model: 
+ Класс ItemModel: создание модели товара.

### Пакет generator:
+ Класс CatalogsGenerator: создание заготовленных списков каталогов и подкаталогов. 