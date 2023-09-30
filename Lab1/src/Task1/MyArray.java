package Task1;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int[] mirror() {
		int n = array.length;
		int[] result = new int[2 * n];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i];
			result[result.length - i - 1] = array[i];
		}
		return result;

	}

	public int[] removeDuplicates() {
		int[] result = new int[array.length];
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			boolean found = false;
			for (int j = 0; j < count; j++) {
				if (array[i] == result[j]) {
					found = true;
					break;
				}
			}
			if (!found) {
				result[count++] = array[i];
			}
		}
		return result;
	}

	// Input: 10 11 12 13 14 16 17 19 20
	// Output: 15 18
	public int[] getMissingValues() {
		int min = array[0];
		int max = array[array.length - 1];
		int missCount = 0;
		for (int i = min; i < max; i++) {
			boolean found = false;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i) {
					found = true;
					break;
				}
			}
			if (!found) {
				missCount++;
			}
		}
		int[] result = new int[missCount];
		int index = 0;
		for (int i = min; i < max; i++) {
			boolean found = false;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i) {
					found = true;
					break;
				}
			}
			if (!found) {
				result[index] = i;
				index++;
			}
		}
		return result;
	}

	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	public int[] fillMissingValues(int k) {
		// TODO
		return null;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };
		MyArray re = new MyArray(array);
		int[] ra = re.mirror();
		System.out.println(Arrays.toString(ra));

		int[] array1 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		MyArray a = new MyArray(array1);
		int[] b = a.removeDuplicates();
		int[] c = new int[6];
		System.arraycopy(b, 0, c, 0, 6);
		System.out.println(Arrays.toString(c));

		int[] arr = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		MyArray ar = new MyArray(arr);
		System.out.println(Arrays.toString(ar.getMissingValues()));

	}

}
