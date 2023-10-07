package Lab3;

public class Task1_1 {
	private int[] array;

	public Task1_1(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		// TODO
		return recursiveLinearSearcha(target, 0);
	}
	
	public int recursiveLinearSearcha(int target, int index) {
		if(array[index] == target) {
			return index;
		} else if (array[index] < target) {
			return -1;
		} else {
			return recursiveLinearSearcha(target, index + 1);
		}
	}

	public static void main(String[] args) {
		int[] array = {12, 10, 9, 45, 2, 10, 10, 45};
		Task1_1 ar = new Task1_1(array);
		System.out.println(ar.iterativeLinearSearch(45));
		System.out.println(ar.recursiveLinearSearch(15));
	}
}
