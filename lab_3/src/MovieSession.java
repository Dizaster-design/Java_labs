public class MovieSession {
    private final String movie;
    private final String time;
    private final boolean[][] seats;

    public MovieSession(String movie, String time, int rows, int seatsPerRow) {
        this.movie = movie;
        this.time = time;
        this.seats = new boolean[rows][seatsPerRow];
    }

    public String getMovie() {
        return movie;
    }

    public String getInfo() {
        return movie + " в " + time;
    }

    public boolean bookSeat(int row, int seat) {
        if (row < 0 || row >= seats.length || seat < 0 || seat >= seats[0].length || seats[row][seat]) {
            return false;
        }
        seats[row][seat] = true;
        return true;
    }

    public void printSeats() {
        System.out.println("План зала: (O - свободно, X - занято)");
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Ряд " + (i + 1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

    public boolean hasFreeSeats() {
        for (boolean[] row : seats) {
            for (boolean seat : row) {
                if (!seat) return true;
            }
        }
        return false;
    }
}
