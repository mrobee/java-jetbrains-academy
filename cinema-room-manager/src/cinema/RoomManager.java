package cinema;

public class RoomManager {
    int rows;
    int columns;
    boolean[][] chosenSeats;

    public RoomManager(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.chosenSeats = new boolean[rows][columns];
    }

    public boolean addChosenSeats(int row, int column) {
        if (this.chosenSeats[row - 1][column - 1]) {
            return false;
        }
        this.chosenSeats[row - 1][column - 1] = true;
        return true;
    }

    public int getTotalChosenSeats() {
        int total = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.chosenSeats[i][j]) {
                    total++;
                }
            }
        }
        return total;
    }

    public double getOccupancyRate() {
        int chosenSeats = getTotalChosenSeats();
        return (double) chosenSeats / (this.rows * this.columns) * 100.0;
    }

    public int getCurrentIncome() {
        int total = 0;
        for (int i = 1; i <= this.rows; i++) {
            for (int j = 1; j <= this.columns; j++) {
                if (this.chosenSeats[i - 1][j - 1]) {
                    total += getPrice(i);
                }
            }
        }
        return total;
    }

    public int getTotalIncome() {
        int total = 0;
        for (int i = 0; i < this.rows ; i++) {
            total += getPrice(i + 1) * this.columns;
        }
        return total;
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
        System.out.print(" ");
        for (int i = 1; i <= columns; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();
    }

}
