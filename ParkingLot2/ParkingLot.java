public class ParkingLot {

    private ParkingSpot[][] spots;

    public ParkingLot(ParkingSpot[][] spots) {
        this.spots = spots;
    }

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
}
