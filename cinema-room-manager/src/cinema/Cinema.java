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
                    try {
                        if (buyTicket(roomManager, scanner)) {
                            break;
                        } else {
                            continue;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Wrong input!");
                        continue;
                    }
                case 3:
                    printStatistics(roomManager);
                    break;
                default:
                    System.out.println("Please choose either 1, 2, or 0.");
                    break;
            }
            chosen = printMenu(scanner);
        }

    }

    private static void printStatistics(RoomManager roomManager) {
        System.out.println();
        System.out.println("Number of purchased tickets: " + roomManager.getTotalChosenSeats());
        System.out.printf("Percentage: %.2f%%\n", roomManager.getOccupancyRate());
        System.out.println("Current income: $" + roomManager.getCurrentIncome());
        System.out.println("Total income: $" + roomManager.getTotalIncome());
    }

    public static boolean buyTicket(RoomManager roomManager, Scanner scanner) {
        System.out.println("Enter a row number:");
        int row = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter a seat number in that row:");
        int column = Integer.parseInt(scanner.nextLine());

        boolean isAvailable = roomManager.addChosenSeats(row, column);
        if (isAvailable) {
            System.out.printf("Ticket price: $%d\n\n", roomManager.getPrice(row));
        } else {
            System.out.println("That ticket has already been purchased");
        }

        return isAvailable;
    }

    public static int printMenu(Scanner scanner) {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

        return Integer.parseInt(scanner.nextLine());
    }

}