public class ParkingLot {

    private car[][] lot;

    /**
    @param Takes the uh row and column
    @return Returns if it was successful

    construct uh the parking lot uh
    */
    public ParkingLot(int rows, int columns) {
        lot = new car[rows][columns];
        /*
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < columns; j++) {
                lot[i][j] = new car
            }
        }
        */
    }

    /**
    @param Takes the uh row and column thing
    @return Returns if it was successful

    basically just uh adds a uh car from uh a spot
    */
    public boolean parkCar(int row, int column, car YourCar) {
        if (lot[row][column] == null) {
            lot[row][column] = YourCar;
            return true;
        } else {
            return false;
        }
    }

    /**
    @param Takes the uh row and column thing
    @return Returns if it was successful

    basically just uh removes a uh car from uh a spot
    */
    public boolean removeCar(int row, int column) {
        if (lot[row][column] == null) {
            return false;
        } else {
            lot[row][column] = null;
            return true;
        }
    }

    /**
    prints out the lot rotated by 90 deg
    */
    public void displayParkingLot() {
        for (int i = 0; i < lot.length; i++) {
            for (int j = 0; j < lot[0].length; j++) {
                if (lot[i][j] == null) {
                    System.out.print("[null]");
                } else {
                    System.out.print("[" + lot[i][j].getLicensePlate() + "]");
                }
            }
            System.out.println("");
        }
    }
}
