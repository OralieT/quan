package Lab4;

import java.util.Arrays;

public class Task1_2 {
	// sort by descending order
	public static void bubbleSort(int[] array) {
		// TODO
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				System.out.println("Vong lap nho: " + Arrays.toString(array));
			}
			System.out.println("bubble: " + Arrays.toString(array));
		}

	}

	public static void main(String[] args) {
		int[] array = { 11, 2, 5, 9, 20 };
		bubbleSort(array);
		System.out.println("BubbleSort: " + Arrays.toString(array));
	}
}
