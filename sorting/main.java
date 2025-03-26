public class main {

    public static void main(String[] args) {
        int[] array = { 12, 10, 16, 11, 9, 7 };
        sort sortObj = new sort(array);

        System.out.println("Selection Sort:");
        int[] sorted = sortObj.selectionSort();
        for (int i : sorted) {
            System.out.println(i);
        }

        System.out.println("Insertion Sort:");
        int[] sorted2 = sortObj.insertionSort();
        for (int i : sorted2) {
            System.out.println(i);
        }
    }
}
