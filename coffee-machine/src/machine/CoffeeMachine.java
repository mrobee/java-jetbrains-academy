package machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public void printState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", this.water);
        System.out.printf("%d ml of milk\n", this.milk);
        System.out.printf("%d g of coffee beans\n", this.coffeeBeans);
        System.out.printf("%d disposable cups\n", this.cups);
        System.out.printf("$%d of money\n", this.money);
    }

    public boolean canMakeCoffee(int coffeeType) {
        switch (coffeeType) {
            case 1:
                return checkIngredients(250, 0, 16);
            case 2:
                return checkIngredients(350, 75, 20);
            case 3:
                return checkIngredients(200, 100, 12);
        }
        return false;
    }

    private boolean checkIngredients(int water, int milk, int coffeeBeans) {
        return this.water - water > 0 && this.milk - milk > 0 && this.coffeeBeans - coffeeBeans > 0 && this.cups - 1 > 0;
    }

    public void buyCoffee(int coffeeType) {
        switch (coffeeType) {
            case 1:
                makeCoffee(250, 0, 16, 4);
                break;
            case 2:
                makeCoffee(350, 75, 20, 7);
                break;
            case 3:
                makeCoffee(200, 100, 12, 6);
                break;
        }
    }

    private void makeCoffee(int water, int milk, int coffeeBeans, int money) {
        this.water -= water;
        this.milk -= milk;
        this.coffeeBeans -= coffeeBeans;
        this.cups--;
        this.money += money;
    }


    public void fillIngredients(int water, int milk, int coffeeBeans, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += coffeeBeans;
        this.cups += cups;
    }

    public int takeMoney() {
        int money = this.money;
        this.money = 0;
        return money;
    }

    public String getShortage(int coffeeType) {
        String str = null;
        switch (coffeeType) {
            case 1:
                str = shortage(250, 0, 16);
                break;
            case 2:
                str = shortage(350, 75, 20);
                break;
            case 3:
                str = shortage(200, 100, 12);
                break;
        }
        return str;
    }

    private String shortage(int water, int milk, int coffeeBeans) {
        List<String> ingredients = new ArrayList<>();
        if (this.water - water < 0) {
            ingredients.add("water");
        }
        if (this.milk - milk < 0) {
            ingredients.add("milk");
        }
        if (this.coffeeBeans - coffeeBeans < 0) {
            ingredients.add("coffee beans");
        }
        if (this.cups - 1 < 0) {
            ingredients.add("cups");
        }

        return String.join(", ", ingredients);
    }
}
