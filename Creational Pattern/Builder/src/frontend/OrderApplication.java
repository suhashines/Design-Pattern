package frontend;

import backend.OrderManager;
import backend.OrderManagerImpl;
import backend.OrderOption;
import backend.shake.Ingredient;
import backend.shake.InvalidCommand;
import backend.ShakeTemplate;
import backend.shake.Shake;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderApplication {

    final Scanner scanner;
    final OrderManager manager;

    public OrderApplication() {
        this.scanner = new Scanner(System.in);
        manager = new OrderManagerImpl();
    }


    private boolean takeOrder() {
        System.out.println("-::Menu::-");
        ShakeTemplate[] shakes = manager.getAvailableShakes();
        ListIterator<ShakeTemplate> it = Arrays.asList(shakes).listIterator();
        while (it.hasNext()) {
            int index = it.nextIndex();
            ShakeTemplate shakeTemplate = it.next();
            System.out.println((index + 1) + ") " + shakeTemplate + " (" + shakeTemplate.getBasePrice() + " Tk)");
        }
        int totalNumOfShakes = shakes.length;
        int choice = -1;
        while (choice < 0 || choice > totalNumOfShakes) {
            System.out.print("Enter Q to quit or enter your choice between 1 and " + totalNumOfShakes + " to order: ");
            String cmd = scanner.nextLine();
            if (cmd.equals("Q")) {
                return false;
            }
            try {
                choice = Integer.parseInt(cmd);
            } catch (NumberFormatException e) {
                System.out.println("Unknown command");
            }
        }
        System.out.println("You have ordered " + shakes[choice - 1]);
        try {
            manager.openOrder(shakes[choice - 1]);
        } catch (InvalidCommand e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private boolean customize() {
        System.out.println("-::Customize your " + manager.getOngoingShake() + "::-");
        System.out.print("Current ingredients: ");
        Ingredient[] ingredients;
        try {
            ingredients = manager.getCurrentIngredients();
        } catch (InvalidCommand e) {
            throw new RuntimeException(e);
        }

        System.out.println(Stream.of(ingredients).map(Ingredient::getName).collect(Collectors.joining(", ")));

        try {
            System.out.println("Current cost: " + manager.getCurrentTotal() + " Tk");
        } catch (InvalidCommand e) {
            throw new RuntimeException(e);
        }
        List<OrderOption> options;
        try {
            options = manager.getAvailableCustomizeOptions();
        } catch (InvalidCommand e) {
            throw new RuntimeException(e);
        }

        ListIterator<OrderOption> it = options.listIterator();
        while (it.hasNext()) {
            System.out.println((it.nextIndex() + 1) + ") " + it.next());
        }

        int totalNumOfOptions = options.size();
        int choice = -1;
        while (choice < 0 || choice > totalNumOfOptions) {
            System.out.print("Enter C to close an order or enter your choice between 1 and " + totalNumOfOptions + " to order: ");
            String cmd = scanner.nextLine();
            if (cmd.equals("C")) {
                return false;
            }
            try {
                choice = Integer.parseInt(cmd);
            } catch (NumberFormatException e) {
                System.out.println("Unknown command");
            }
        }

        try {
            manager.manageOrder(options.get(choice - 1));
        } catch (InvalidCommand e) {
            throw new RuntimeException(e);
        }


        return true;
    }

    private void confirmOrder() {
        Shake shake;
        try {
            shake = manager.closeOrder();
        } catch (InvalidCommand e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n\n\n");
        printReceipt(shake);
    }

    private void printReceipt(Shake shake) {
        System.out.println("-::Receipt for your " + shake.getName() + "::-");
        BigDecimal price = shake.getBasePrice();
        System.out.println("Base price: " + price);
        for (Ingredient ingredient: shake.getIngredients()) {
            if (ingredient.getPrice() != null) {
                price = price.add(ingredient.getPrice());
                System.out.println(ingredient.getName() + ": " + ingredient.getPrice());
            }
        }
        System.out.println("Total price: " + price);
    }

    public void run() {
        while (true) {
            System.out.println("-::Welcome again to ShakeTastic::-");
            if (!takeOrder()) {
                break;
            }
            System.out.println("\n\n\n");
            while (true) {
                if (!customize()) {
                    break;
                }
                System.out.println("\n\n\n");
            }
            confirmOrder();
            System.out.println("\n\n\n");
        }
    }



    public static void main(String[] args) {
        OrderApplication application = new OrderApplication();
        application.run();
    }
}
