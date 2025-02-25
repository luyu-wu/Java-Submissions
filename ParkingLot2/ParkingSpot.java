public class ParkingSpot {

    private int row;
    private int column;
    private boolean isOccupied;

    public ParkingSpot(int row, int column, boolean isOccupied) {
        this.row = row;
        this.column = column;
        this.isOccupied = isOccupied;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public String toString() {
        return (
            "ParkingSpot{" +
            "row=" +
            row +
            ", column=" +
            column +
            ", isOccupied=" +
            isOccupied +
            '}'
        );
    }
}
