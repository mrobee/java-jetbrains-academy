package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many cups of coffee you will need:");
        int cupsRequested = Integer.parseInt(scanner.nextLine());

        CoffeeMachine machine = new CoffeeMachine(water, milk, coffeeBeans);
        int cupsAvailable = machine.calculateCups();

        if (cupsAvailable < cupsRequested) {
            System.out.printf("No, I can make  only %d cup(s) of coffee\n",  cupsAvailable);
        } else if (cupsAvailable > cupsRequested) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", cupsAvailable - cupsRequested);
        } else {
            System.out.println("Yes, I can make that amount of coffee");
        }
    }
}
