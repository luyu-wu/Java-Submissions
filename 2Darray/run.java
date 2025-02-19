import java.util.Arrays;

public class run {

    public static void main(String[] args) {
        // 2d array
        int[][] arr = new int[2][3];
        // 2d array with values
        // int[][] = {{1,2,3},{4,5,6}};
        //
        // print the 2d array arr
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        double[][] gradebook = new double[6][4];
        System.out.println(Arrays.toString(gradebook));

        int[][] gradebook2 = {
            { 99, 99, 95, 69 },
            { 23, 44, 56, 54 },
            { 20, 59, 69, 99 },
            { 40, 45, 44, 46 },
            { 98, 76, 66, 55 },
            { 99, 99, 95, 69 },
        };
        System.out.println(Arrays.toString(gradebook2));
    }
}
