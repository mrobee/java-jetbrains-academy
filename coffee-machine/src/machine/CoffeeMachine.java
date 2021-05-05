package machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;

    public CoffeeMachine(int water, int milk, int coffeeBeans) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
    }

    public int calculateCups() {
        List<Integer> cups = new ArrayList<>();
        cups.add(this.water / 200);
        cups.add(this.milk / 50);
        cups.add(this.coffeeBeans / 15);

        return Collections.min(cups);
    }
}
