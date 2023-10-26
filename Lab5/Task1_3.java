
package Lab5;

public class Task1_3 {
	public static int[][] multiply(int[][] a, int[][] b) {
		if (a[0].length != b.length) {
			return null;
		}

		int row = a.length;
		int col = b[0].length;
		int[][] result = new int[row][col];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return result;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 2, 1, 5, 6 } };
		int[][] b = { { 1, 2, 3 }, { 2, 1, 5 }, { 1, 1, 1 }, { 2, 2, 2 } };
		printMatrix(multiply(a, b));
	}
}
