package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the number of seats in each row:");
        int columns = Integer.parseInt(scanner.nextLine());

        RoomManager roomManager = new RoomManager(rows, columns);
        roomManager.printSeats(0, 0);

        System.out.println("Enter a row number:");
        int row = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter a seat number in that row:");
        int column = Integer.parseInt(scanner.nextLine());

        System.out.printf("Ticket price: $%d\n\n", roomManager.getPrice(row));
        roomManager.printSeats(row, column);
    }
    
}