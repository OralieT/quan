package Lab3;

import java.util.Arrays;

public class Task1_2 {
	private int[] array;

	public Task1_2(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns-1.

	public int iterativeBinarySearch(int target) {
		// TODO
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// To find the index of the target in the sorted array. If the
	// target is not

	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		// TODO
		return recursiveBinarySearcha(target, 0, array.length - 1);
	}

	public int recursiveBinarySearcha(int target, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				return recursiveBinarySearcha(target, low, high - 1);
			} else {
				return recursiveBinarySearcha(target, low + 1, high);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {12, 10, 9, 45, 2, 10, 10, 45};
		Task1_2 ar = new Task1_2(array);
		Arrays.sort(array);
		System.out.println("Sap xep mang: " + Arrays.toString(array));
		System.out.println("iterativeBinarySearch: " + ar.iterativeBinarySearch(45));
		System.out.println("recursiveBinarySearch: " + ar.recursiveBinarySearch(10));
	}
}
