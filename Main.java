import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        Shop shop = new Shop();
        ShopManager shopManager = new ShopManager(shop);
        Cart cart = new Cart();
        OrderService orderService = new OrderService();

        // Создаем несколько категорий
        Category electronics = new Category("Электроника", "Электронные устройства");
        Category clothing = new Category("Одежда", "Одежда и аксессуары");

        // Создаем несколько товаров и добавляем их в магазин
        shopManager.addProduct(new Product("Ноутбук", "Современный ноутбук для работы и развлечений", 1200.0, electronics));
        shopManager.addProduct(new Product("Смартфон", "Новый смартфон с отличной камерой", 800.0, electronics));
        shopManager.addProduct(new Product("Футболка", "Хлопковая футболка", 25.0, clothing));
        shopManager.addProduct(new Product("Джинсы", "Классические джинсы", 75.0, clothing));

        while (true) {
            ui.displayMenu();
            String command = ui.getCommand();

            switch (command) {
                case "1":
                    // Показать все товары
                    List<Product> allProducts = shopManager.getAllProducts();
                    if (allProducts.isEmpty()) {
                        ui.displayMessage("В магазине пока нет товаров.");
                    } else {
                        ui.displayMessage("Товары в магазине:");
                        for (int i = 0; i < allProducts.size(); i++) {
                            ui.displayMessage((i + 1) + ". " + allProducts.get(i).toString());
                        }
                    }
                    break;
                case "2":
                    // Фильтр товаров
                    ui.displayMessage("Доступные фильтры:");
                    ui.displayMessage("1 - По ключевому слову");
                    ui.displayMessage("2 - По диапазону цен");
                    String filterType = ui.getStringInput("Выберите фильтр: ");

                    List<ProductFilter> filters = new ArrayList<>();
                    switch (filterType) {
                        case "1":
                            // Фильтр по ключевому слову
                            String keyword = ui.getStringInput("Введите ключевое слово: ");
                            filters.add(new KeywordProductFilter(keyword));
                            break;
                        case "2":
                            // Фильтр по диапазону цен
                            double minPrice = ui.getDoubleInput("Введите минимальную цену: ");
                            double maxPrice = ui.getDoubleInput("Введите максимальную цену: ");
                            filters.add(new PriceRangeProductFilter(minPrice, maxPrice));
                            break;
                        default:
                            ui.displayMessage("Неверный фильтр. Попробуйте еще раз.");
                            continue; // Переходим к следующей итерации цикла
                    }

                    List<Product> filteredProducts = shopManager.filterProducts(filters);
                    if (filteredProducts.isEmpty()) {
                        ui.displayMessage("Товары не найдены.");
                    } else {
                        ui.displayMessage("Найденные товары:");
                        for (int i = 0; i < filteredProducts.size(); i++) {
                            ui.displayMessage((i + 1) + ". " + filteredProducts.get(i).toString());
                        }
                    }
                    break;
                case "3":
                    // Добавить товар в корзину
                    List<Product> allProductsForCart = shopManager.getAllProducts();
                    if (allProductsForCart.isEmpty()) {
                        ui.displayMessage("В магазине пока нет товаров.");
                    } else {
                        ui.displayMessage("Товары в магазине:");
                        for (int i = 0; i < allProductsForCart.size(); i++) {
                            ui.displayMessage((i + 1) + ". " + allProductsForCart.get(i).toString());
                        }

                        String itemNumber = ui.getStringInput("Введите номер товара, который хотите добавить в корзину: ");
                        try {
                            int index = Integer.parseInt(itemNumber) - 1;
                            if (index >= 0 && index < allProductsForCart.size()) {
                                Product selectedProduct = allProductsForCart.get(index);
                                cart.addItem(selectedProduct);
                                ui.displayMessage("Товар \"" + selectedProduct.getName() + "\" добавлен в корзину.");
                            } else {
                                ui.displayMessage("Неверный номер товара.");
                            }
                        } catch (NumberFormatException e) {
                            ui.displayMessage("Неверный формат номера товара.");
                        }
                    }
                    break;
                case "4":
                    // Показать корзину
                    List<Product> cartItems = cart.getItems();
                    if (cartItems.isEmpty()) {
                        ui.displayMessage("Ваша корзина пуста.");
                    } else {
                        ui.displayMessage("Ваша корзина:");
                        for (int i = 0; i < cartItems.size(); i++) {
                            ui.displayMessage((i + 1) + ". " + cartItems.get(i).toString());
                        }
                        ui.displayMessage("Общая стоимость: " + cart.getTotalPrice());
                    }
                    break;
                case "5":
                    // Оформить заказ
                    List<Product> itemsInCart = cart.getItems();
                    if (itemsInCart.isEmpty()) {
                        ui.displayMessage("Ваша корзина пуста. Добавьте товары перед оформлением заказа.");
                    } else {
                        String customerName = ui.getStringInput("Введите ваше имя: ");
                        String customerAddress = ui.getStringInput("Введите ваш адрес доставки: ");

                        Order order = orderService.createOrder(itemsInCart, customerName, customerAddress);
                        ui.displayMessage("Заказ оформлен. Спасибо за покупку!");
                        ui.displayMessage("Информация о заказе:\n" + order);

                        // Очищаем корзину после оформления заказа
                        cart = new Cart();
                    }
                    break;
                case "0":
                    // Выход
                    ui.displayMessage("Спасибо за посещение нашего магазина!");
                    return;
                default:
                    ui.displayMessage("Неверная команда. Попробуйте еще раз.");
            }
        }
    }
}