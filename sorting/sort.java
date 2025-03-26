public class sort {

    private int[] arr;

    public sort(int[] arr) {
        this.arr = arr;
    }

    public int[] selectionSort() {
        int[] array = arr;
        int compare_len = array.length - 1;
        int compare_in = 0;
        for (int i = 0; i < array.length; i++) {
            int lowest_val = array[compare_in];
            int lowest_ind = compare_in;
            for (int j = 1; j <= compare_len; j++) {
                if (array[compare_in + j] < lowest_val) {
                    lowest_val = array[compare_in + j];
                    lowest_ind = compare_in + j;
                }
            }
            int swap = array[compare_in];
            array[compare_in] = lowest_val;
            array[lowest_ind] = swap;
            compare_in++;
            compare_len--;
        }
        return array;
    }

    public int[] insertionSort() {
        int[] array = arr;
        for (int i = 1; i < array.length; i++) {
            int save = array[i]; // save the value to be inserted
            int j = i - 1;
            while (j >= 0 && array[j] > save) { // iterate over values more than it
                array[j + 1] = array[j]; // shift them up
                j--;
            }
            array[j + 1] = save;
        }
        return arr;
    }
}
