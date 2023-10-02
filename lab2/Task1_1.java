package lab2;

public class Task1_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		} else {
			return (int) (getSn1(n - 1) + Math.pow((-1), n + 1) * n);
		}
	}

	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		} else {
			int factorial = 1;
			for (int i = 1; i <= n; i++) {
				factorial *= i;
			}
			return factorial + getSn2(n - 1);
		}
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		} else {
			return ((int) (getSn3(n - 1) + Math.pow(n, 2)));
		}
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		} else {
			int factorial = 1;
			for (int i = 1; i <= n; i++) {
				factorial *= (2 * i);
			}
			return Math.pow(factorial, (-1)) + getSn4(n-1);
		}
	}

	public static void main(String[] args) {
		System.out.println(getSn1(5));
		System.out.println(getSn2(5));
		System.out.println(getSn3(5));
		System.out.println(getSn4(5));
	}
}
