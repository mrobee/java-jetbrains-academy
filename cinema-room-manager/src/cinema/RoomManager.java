package cinema;

public class RoomManager {
    int rows;
    int columns;
    boolean[][] chosenSeats;

    public RoomManager(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        initSeats();
    }

    private void initSeats() {
        this.chosenSeats = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.chosenSeats[i][j] = false;
            }
        }
    }

    public void addChosenSeats(int row, int column) {
        this.chosenSeats[row - 1][column - 1] = true;
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

    public void printSeats() {
        printHeader();

        for (int i = 1; i <= rows; i++) {
            StringBuilder seats = new StringBuilder();
            for (int j = 1; j <= columns; j++) {
                if (this.chosenSeats[i-1][j-1]) {
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
