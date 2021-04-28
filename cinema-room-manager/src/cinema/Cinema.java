package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the number of seats in each row:");
        int columns = Integer.parseInt(scanner.nextLine());

        int price;
        int seats = rows * columns;
        if (seats <= 60) {
            price = 10 * seats;
        } else {
            int firstHalf = rows / 2;
            price = firstHalf * columns * 10;
            price += (rows - firstHalf) * columns * 8;
        }

        System.out.println("Total income:");
        System.out.println("$" + price);
    }
}