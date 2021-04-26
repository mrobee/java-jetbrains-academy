package io.github.mrobee.academy.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        if (list.size() != 3) {
            exit();
        }

        isNumeric(list.get(0));
        isNumeric(list.get(2));

        int base = Integer.parseInt(list.get(0));
        radixInRange(base);

        int dest = Integer.parseInt(list.get(2));
        radixInRange(dest);

        String number = list.get(1);

        Converter converter = new Converter(base, number, dest);
        String destNumber = converter.convertNumber();
        System.out.println(destNumber);
    }

    public static void isNumeric(String str) {
        if (! str.matches("-?\\d+(\\.\\d+)?") ) {
            exit();
        }
    }

    public static void radixInRange(int radix) {
        if (radix < 1 || radix > 36) {
            exit();
        }
    }

    public static void exit() {
        System.out.println("error");
        System.exit(1);
    }
}
