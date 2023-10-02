package lab2;

public class Task1_3 {
	// This method is used to display a Pascal triangle based
	// on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int row) {
		for (int i = 1; i <= row; i++) {
			int[] currentRow = getPascalTriangle(i);
			for (int num : currentRow) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if (n <= 0) {
			return null;
		}
		int[] curRow = { 1 };
		if (n == 1) {
			return curRow;
		}
		curRow = generateNextRow(getPascalTriangle(n - 1));
		return curRow;
	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int n = prevRow.length + 1;
		int[] result = new int[prevRow.length + 1];
		result[0] = 1;
		result[n - 1] = 1;
		for (int i = 1; i < prevRow.length; i++) {
			result[i] = prevRow[i - 1] + prevRow[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int result = 6;
		printPascalTriangle(result);
	}
}
