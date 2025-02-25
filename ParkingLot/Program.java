public class Program {

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3, 4);

        car myCar0 = new car("ABC123");
        car myCar1 = new car("XYZ789");
        car myCar2 = new car("DEF456");

        lot.parkCar(0, 0, myCar0);
        lot.parkCar(1, 1, myCar1);
        lot.parkCar(2, 3, myCar2);

        lot.displayParkingLot();

        lot.removeCar(1, 1);
        System.out.println("\nRemove car\n");
        lot.displayParkingLot();
    }
}
