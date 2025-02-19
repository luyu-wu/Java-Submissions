import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		System.out.println(Arrays.toString(Shifter.Shift(arr)));

		String[] arr2 = {"hello", "I", "am", "here"};
		System.out.println(Arrays.toString(Shifter.Shift(arr2)));
	}
}
