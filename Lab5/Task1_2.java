
package Lab5;

public class Task1_2 {
	public static int[][] subtract(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			return null;
		}

		int row = a.length;
		int col = b[0].length;
		int[][] result = new int[row][col];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = a[i][j] - b[i][j];
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
		int[][] a = { { 7, 2 }, { 5, 3 } };
		int[][] b = { { 2, 1 }, { 3, 1 } };
		printMatrix(subtract(a, b));
	}
}
