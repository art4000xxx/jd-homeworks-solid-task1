import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nДобро пожаловать в наш Магазин!");
        System.out.println("Доступные команды:");
        System.out.println("1 - Показать все товары");
        System.out.println("2 - Фильтр товаров");
        System.out.println("3 - Добавить товар в корзину");
        System.out.println("4 - Показать корзину");
        System.out.println("5 - Оформить заказ");
        System.out.println("0 - Выход");
    }

    public String getCommand() {
        System.out.print("Введите команду: ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public double getDoubleInput(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine());
    }
}