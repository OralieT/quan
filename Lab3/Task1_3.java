package Lab3;

public class Task1_3 {
	private int[] array;

	public Task1_3(int[] array) {
		this.array = array;
	}

	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearcha(target, 0, array.length - 1);
	}

	public int recursiveBinarySearcha(int target, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				return recursiveBinarySearcha(target, low + 1, high);
			} else {
				return recursiveBinarySearcha(target, low, high - 1);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 6, 5, 5, 3, 1, 1 };
		Task1_3 ar = new Task1_3(array);
		System.out.println("iterativeBinarySearch: " + ar.iterativeBinarySearch(1));
		System.out.println("recursiveBinarySearch: " + ar.recursiveBinarySearch(5));
	}
}
