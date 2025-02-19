public class Shifter  {

	public static int[] Shift(int[] arr) {
		int[] new_arr = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			new_arr[(i+1)%arr.length] = arr[i];
		}
		return new_arr;
	}


	
	public static String[] Shift(String[] arr) {
		String[] new_arr = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			new_arr[(i+1)%arr.length ] = arr[i];
		}
		return new_arr;+
	}
	
}
