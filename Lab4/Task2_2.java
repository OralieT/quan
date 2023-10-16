package Lab4;

import java.util.Arrays;
import java.util.Random;

public class Task2_2 {
	// sort by descending order
	public static void quickSort(int[] array) {
		// TODO
		if (array == null || array.length <= 1) {
			return;
		}
		quickSort(array, 0, array.length - 1);
		System.out.println("quickSort: " + Arrays.toString(array));
	}

	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			// int pivotIndex = getPivot_MedianOfThree(array, low, high);
			// int pivotIndex = getPivot_First(array, low, high);
			// int pivotIndex = getPivot_Last(array, low, high);
			int pivotIndex = getPivot_Random(array, low, high);
			pivotIndex = partition(array, low, high, pivotIndex);

			System.out.println("Mang sau khi sap xep: " + Arrays.toString(array));
			quickSort(array, low, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, high);
		}
	}

	// select pivot element based on the median of three strategy
	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
		// TODO
		int mid = (high + low) / 2;

		if (array[low] > array[mid]) {
			swap(array, low, mid);
		}
		if (array[low] > array[high]) {
			swap(array, low, high);
		}
		if (array[mid] > array[high]) {
			swap(array, mid, high);
		}
		return mid;
	}

	// select pivot element based on the first element in the array
	private static int getPivot_First(int[] array, int low, int high) {
		// TODO
		return low;
	}

	// select pivot element based on the last element in the array
	private static int getPivot_Last(int[] array, int low, int high) {
		// TODO
		return high;
	}

	// select pivot element based on the choosing a ramdomly element in the array
	private static int getPivot_Random(int[] array, int low, int high) {
		// TODO
		Random rd = new Random();
		return rd.nextInt(high - low + 1) + low;
	}

	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static int partition(int[] array, int low, int high, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, high);

		int i = low;
		for (int j = low; j < high; j++) {
			if (array[j] >= pivotValue) {
				swap(array, i, j);
				i++;
			}
		}
		swap(array, i, high);
		return i;
	}

	public static void main(String[] args) {
		int[] array = { 12, 2, 4, 9, 20, 6 };
		quickSort(array);
	}

}
