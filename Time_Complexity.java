package Lectures;

import java.util.Arrays;

public class Time_Complexity {
	public static void main(String[] args) {
		// System.out.println(polynomial(7, 5, 7));

		System.out.println(countpalindrome("nitin"));
		// System.out.println(Power(2, 8));
		SDE(25);
	}

	public static int polynomial(int x, int n, int mult) {

		if (n == 1) {
			return mult;
		}

		return polynomial(x, n - 1, mult * x) + n * mult;
	}

	public static int Power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int sp = Power(x, n / 2);

		if (sp % 2 == 0) {
			return sp * sp;
		} else
			return sp * sp * x;

	}

	public static int countpalindrome(String str) {

		int count = 0;
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else
					break;
			}
		}
		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else
					break;
			}
		}

		return count;
	}

	public static void SDE(int n) {
		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int table = 2; table * table <= n; table++) {
			if (primes[table] == false) {
				continue;
			}
			for (int multiplier = 2; table * multiplier <= n; multiplier++) {
				primes[table * multiplier] = false;
			}

		}
		for (int i = 0; i < primes.length; i++) {
			if (primes[i] == true) {
				System.out.println(i);
			}
		}
	}

}
