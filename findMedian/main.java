import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindMedian {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        System.out.println("Enter the first integer: ");
        int i_0 = s1.nextInt();

        System.out.println("Enter the second integer: ");
        int i_1 = s1.nextInt();

        System.out.println("Enter the third integer: ");
        int i_2 = s1.nextInt();

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(i_0);
        numbers.add(i_1);
        numbers.add(i_2);

        Collections.sort(numbers);

        System.out.println("The median is: " + numbers.get(1));
    }
}
