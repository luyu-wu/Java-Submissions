public class ParkingLot {

    private ParkingSpot[][] spots;

    public ParkingLot(ParkingSpot[][] spots) {
        this.spots = spots;
    }

    /**
     * Finds the first available spot by iterating through the lot.
     * Time complexity: O(n*m), where n is the number of rows and m is the number of columns.
     * @return The first available spot or null if none is available.
     */
    public ParkingSpot findFirstAvailableSpotMethod1() {
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                if (spots[i][j].isAvailable()) {
                    return spots[i][j];
                }
            }
        }
        return null;
    }

    /**
     * Finds the first available spot using a single loop.
     * Time complexity is the same as the first one?
     * @return The first available spot or null if none is available.
     */
    public ParkingSpot findFirstAvailableSpotMethod2() {
        int total = spots.length * spots[0].length;

        for (int i = 0; i < total; i++) {
            int row = i / spots[0].length;
            int col = i % spots[0].length;

            if (spots[row][col].isAvailable()) {
                return spots[row][col];
            }
        }
        return null;
    }

    /**
     * Finds the first available spot assuming all occupied spots are grouped together.
     * Has complexity of O(n + m) where n is the number of rows and m is the number of columns.
     * @return The first available spot or null if none is available.
     */
    public ParkingSpot findFirstAvailableSpotMethod3() {
        int first_col = -1;
        for (int i = 0; i < spots.length; i++) {
            if (spots[i][0].isAvailable()) {
                first_col = i;
                break;
            }
            first_col++;
        }
        if (first_col >= 0) {
            for (int i = 0; i < spots[first_col].length; i++) {
                if (spots[first_col][i].isAvailable()) {
                    return spots[first_col][i];
                }
            }
        }
        return null;
    }
}
