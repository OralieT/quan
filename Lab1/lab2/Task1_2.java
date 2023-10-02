package lab2;

public class Task1_2 {
	public class Fibonacci {
		// get the nth value of the Fibonacci series
		public static int getFibonacci(int n) {
			if (n <= 0) {
				return n;
			} else {
				int a = 0;
				int b = 1;
				int result = 0;

				for (int i = 2; i <= n; i++) {
					result = a + b;
					a = b;
					b = result;
				}

				return result;
			}
		}

		// This method is used to display a Fibonaccci series based on
		// the parameter n.Ex.n=10==>0 1 1 2 3 5 8 13 21 34
		public static void printFibonacci(int n) {
			int a = 0;
			int b = 1;
			for (int i = 0; i < n; i++) {
				System.out.print(a + " ");
				int temp = a + b;
				a = b;
				b = temp;
			}
			System.out.println();
		}

		public static void main(String[] args) {
			System.out.println(getFibonacci(10));
			printFibonacci(10);
		}
	}
}
