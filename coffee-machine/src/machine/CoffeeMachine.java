package machine;

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
        return this.money;
    }
}
