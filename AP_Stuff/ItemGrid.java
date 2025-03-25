public class ItemGrid {

    private Item[][] grid = {
        { new Item("acorn", 0), new Item("egg", 5), new Item("island", 7) },
        { new Item("book", 10), new Item("flag", 8), new Item("jacket", 19) },
        { new Item("carrot", 8), new Item("globe", 8), new Item("kale", 8) },
        { new Item("desk", 9), new Item("harp", 9), new Item("lunch", 16) },
    };

    public boolean isValid(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    public Item mostValuableNeighbor(int c, int r) {
        Item maxNeighbor = grid[r][c];
        int maxVal = maxNeighbor.getValue();

        for (int i = -1; i <= 1; i += 2) {
            int newRow = r + i;
            if (isValid(newRow, c)) {
                Item neighbor = grid[newRow][c];
                if (neighbor.getValue() > maxVal) {
                    maxVal = neighbor.getValue();
                    maxNeighbor = neighbor;
                }
            }
        }
        return maxNeighbor;
    }

    public double findAverage() {
        double sum = 0;
        int count = 0;

        for (Item[] row : grid) {
            for (Item item : row) {
                sum += item.getValue();
                count++;
            }
        }

        return sum / count;
    }
}
