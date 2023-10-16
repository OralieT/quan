package Lab4;

import java.util.Arrays;

public class Task1_3 {
	// sort by descending order
	public static void insertionSort(int[] array) {
		// TODO
		int n = array.length;
		for (int i = 1; i < n; i++) {
			int k = array[i];
			int j = i;
			while (j > 0 && array[j - 1] < k) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = k;
			System.out.println("insertionSort: " + Arrays.toString(array));
		}
	}

	public static void main(String[] args) {
		int[] array = {5,1,6,3,8,11,9,20};
		insertionSort(array);
	}
}
