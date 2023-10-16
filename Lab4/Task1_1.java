package Lab4;

import java.util.Arrays;

public class Task1_1 {
	// soft by descending order
	public static void selectionSort(int[] array) {
		// TODO
		for (int i = 0; i < array.length - 1; i++) {
			int max = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[max] < array[j]) {
					max = j;
				}
			}
			int temp = array[i];
			array[i] = array[max];
			array[max] = temp;
			System.out.println("selectionSort: " + Arrays.toString(array));
		}
	
	}

	public static void main(String[] args) {
		int[] array = { 2, 4, 6, 1, 8, 9 };
		selectionSort(array);
	}
}
