package cinema;

public class RoomManager {
    int rows;
    int columns;

    public RoomManager(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getPrice(int row) {
        int price;
        int seats = rows * columns;
        if (seats <= 60) {
            price = 10;
        } else {
            int firstHalf = rows / 2;
            if (row <= firstHalf) {
                price = 10;
            } else {
                price = 8;
            }
        }

        return price;
    }

    public void printSeats(int row, int column) {
        printHeader();

        for (int i = 1; i <= rows; i++) {
            StringBuilder seats = new StringBuilder();
            for (int j = 1; j <= columns; j++) {
                if (i == row && j == column) {
                    seats.append(" B");
                } else {
                    seats.append(" S");
                }
            }

            System.out.printf("%d%s", i, seats);
            System.out.println();
        }
    }

    private void printHeader() {
        System.out.println("Cinema:");
        System.out.printf(" ");
        for (int i = 1; i <= columns; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();
    }

}
