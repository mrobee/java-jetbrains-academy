package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        machine.printState();

        System.out.printf("Write action (buy, fill, take)");
        String action = scanner.nextLine();

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int coffeeType = Integer.parseInt(scanner.nextLine());
                machine.buyCoffee(coffeeType);
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                int water = Integer.parseInt(scanner.nextLine());

                System.out.println("Write how many ml of milk you want to add:");
                int milk = Integer.parseInt(scanner.nextLine());

                System.out.println("Write how many grams of coffee beans you want to add:");
                int coffeeBeans = Integer.parseInt(scanner.nextLine());

                System.out.println("Write how many disposable cups of coffee you want to add:");
                int cups = Integer.parseInt(scanner.nextLine());

                machine.fillIngredients(water, milk, coffeeBeans, cups);
                break;
            case "take":
                System.out.printf("I have you $%d\n", machine.takeMoney());
                break;
            default:
                System.out.println("Error. Unknown action.");
                break;
        }

        machine.printState();
    }
}
