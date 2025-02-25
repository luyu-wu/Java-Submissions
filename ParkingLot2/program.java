public class program {

    public static void main(String[] args) {
        ParkingSpot[][] spots = new ParkingSpot[5][5];

        /***

        */
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                spots[i][j] = new ParkingSpot(i, j, false);
            }
        }

        ParkingLot lot = new ParkingLot(spots);

        System.out.println(lot.findFirstAvailableSpotMethod3().toString());
    }
}
