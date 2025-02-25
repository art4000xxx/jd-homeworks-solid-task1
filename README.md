# Описание применения принципов SOLID в проекте

## Single Responsibility Principle (SRP)

Класс `Main` был разделен на несколько классов, каждый из которых отвечает за свою задачу:

*   `ConsoleUI`: Отвечает за взаимодействие с пользователем через консоль.
    *   Пример: [ConsoleUI.java](https://github.com/art4000xxx/jd-homeworks-solid-task1/blob/main/src/ConsoleUI.java)
*   `ShopManager`: Отвечает за управление товарами в магазине.
    *   Пример: [ShopManager.java](https://github.com/art4000xxx/jd-homeworks-solid-task1/blob/main/src/ShopManager.java)
*   `OrderService`: Отвечает за оформление заказа.
    *   Пример: [OrderService.java](https://github.com/art4000xxx/jd-homeworks-solid-task1/blob/main/src/OrderService.java)

Это позволяет сделать код более модульным, легким для понимания и поддерживаемым.

## Open/Closed Principle (OCP)

Реализована гибкая система фильтрации товаров, которую можно расширять, не изменяя существующий код. Для добавления нового способа фильтрации необходимо создать новый класс, реализующий интерфейс `ProductFilter`.

*   Интерфейс `ProductFilter`: [ProductFilter.java](https://github.com/art4000xxx/jd-homeworks-solid-task1/blob/main/src/ProductFilter.java)
*   Пример реализации фильтра по ключевому слову: [KeywordProductFilter.java](https://github.com/art4000xxx/jd-homeworks-solid-task1/blob/main/src/KeywordProductFilter.java)

## Dependency Inversion Principle (DIP)

Класс `ShopManager` зависит от абстракции `ShopInterface`, а не от конкретной реализации класса `Shop`.

*   Интерфейс `ShopInterface`: [ShopInterface.java](https://github.com/art4000xxx/jd-homeworks-solid-task1/blob/main/src/ShopInterface.java)
*   Класс `ShopManager`: [ShopManager.java](https://github.com/art4000xxx/jd-homeworks-solid-task1/blob/main/src/ShopManager.java)

