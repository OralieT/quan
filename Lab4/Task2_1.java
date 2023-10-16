package Lab4;

import java.util.Arrays;

public class Task2_1 {
	// sort by descending order
	public static void mergeSort(int[] array) {
		// TODO
		if(array == null) {
			return;
		}
		
		int n = array.length;
		if (n <= 1 ) {
			return;
		}
		int mid = n / 2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[n - mid];

		System.arraycopy(array, 0, leftArray, 0, mid);
		System.arraycopy(array, mid, rightArray, 0, n - mid);
		
		System.out.println("Chia mang: leftArray = " + Arrays.toString(leftArray) + ", rightArray =  " + Arrays.toString(rightArray));

		mergeSort(leftArray);
		mergeSort(rightArray);

		merge(array, leftArray, rightArray);
	}
	
	public static void merge(int[] array, int[] leftArray, int[] rightArray) {
		int i = 0, j = 0, k = 0;
		
		while(i < leftArray.length && j < rightArray.length) {
			if(leftArray[i] >= rightArray[j]) {
				array[k++] = leftArray[i++];
			} else {
				array[k++] = rightArray[j++];
			}
		}
		while (i < leftArray.length) {
			array[k++] = leftArray[i++];
			System.out.println("Xep mang:  " + Arrays.toString(array));
		}
		
		while (j < rightArray.length) {
			array[k++] = rightArray[j++];
			System.out.println("Xep mang:  " + Arrays.toString(array));
		}
	}
	
	public static void main(String[] args) {
		int[] array = {11,5,7,2,6,10,8,3};
		mergeSort(array);
		System.out.println("MergeSort: " + Arrays.toString(array));
	}
}
