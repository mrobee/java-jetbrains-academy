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

        int chosen = printMenu(scanner);
        while (chosen != 0) {
            switch (chosen) {
                case 1:
                    roomManager.printSeats();
                    break;
                case 2:
                    buyTicket(roomManager, scanner);
                    break;
                default:
                    System.out.printf("Please choose either 1, 2, or 0.");
                    break;
            }
            chosen = printMenu(scanner);
        }

    }

    public static void buyTicket(RoomManager roomManager, Scanner scanner) {
        System.out.println("Enter a row number:");
        int row = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter a seat number in that row:");
        int column = Integer.parseInt(scanner.nextLine());

        System.out.printf("Ticket price: $%d\n\n", roomManager.getPrice(row));
        roomManager.addChosenSeats(row, column);
    }

    public static int printMenu(Scanner scanner) {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");

        return Integer.parseInt(scanner.nextLine());
    }

}