package Lab5;

public class Task1_1 {
	public static int[][] add(int[][] a, int[][] b) {
		int row = a.length;
		int col = b[0].length;

		if (a.length != b.length || a[0].length != b[0].length) {
			throw new IllegalArgumentException("Hai mang khong co cung kich thuoc ");
		}

		int[][] result = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[i][j] = a[i][j] + b[i][j];
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
		int[][] arr = add(a, b);
		printMatrix(arr);

	}
}
