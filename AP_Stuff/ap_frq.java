public class AP_Stuff {

    public static void main(String[] args) {
        ItemGrid test = new ItemGrid();
        Item mostValuableNeighbor = test.mostValuableNeighbor(1, 1); // rn it's row, column
        System.out.println(mostValuableNeighbor.getName());
    }
}
