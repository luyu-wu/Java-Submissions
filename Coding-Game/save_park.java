import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Road length (number of sensor inputs to read)
        if (in.hasNextLine()) {
            in.nextLine();
        }

        int veh_len = 9;
        int left_counter = 0;
        int right_counter = 0;
        System.out.println(veh_len);

        for (int i = 0; i < N; i++) {
            String sensorData = in.nextLine(); // Datas from four sensor with values 1 or 0 (e.g 1001)
            int left = Integer.parseInt(sensorData.substring(0,1));
            int right = Integer.parseInt(sensorData.substring(1,2));

            if (left == 0) {
                left_counter ++;
                if (left_counter >= veh_len) {
                    System.out.println( (i+veh_len-1) +"L");
                }
            } else {
                left_counter = 0;
            }
            
            if (right == 0) {
                right_counter ++;
                if (right_counter >= veh_len) {
                    System.out.println( (i+veh_len-1)+"R");
                }
            } else {
                right_counter = 0;
            }
        }
    }
}
