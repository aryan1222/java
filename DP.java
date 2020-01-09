package Lectures;

import java.util.Scanner;

public class DP {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int n = scn.nextInt();

		// System.out.println(fibTD(n,new int[n+1]));
		// System.out.println(fibBU(n));
		// System.out.println(fibBUSE(n));

		// System.out.println(BoardPath(0, 10, new int[n+1]));

		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
		// 19, 20, 21, 22, 23 };
		// System.out.println(MCM(arr, 0, arr.length-1));

		// System.out.println(MCM_TD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));

		// System.out.println(MCM_BU(arr));
		int[] ar = { 2, 3, 5, 8, 9, 4, 1, 4 };

		// System.out.println(WineProblem(ar, 0, ar.length - 1, 1));

//		System.out.println(WineProblemTD(ar, 0, ar.length - 1, new int[ar.length][ar.length]));

//		System.out.println(WineProblemBU(ar));

		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };

		// System.out.println(Knapsack(wt, price, 7, 0));

		// System.out.println(KnapsackTD(wt, price, 7, 0, new int[wt.length][]));

//		System.out.println(KnapsackBU(wt, price, 7));

		int arr[] = { 40, 60, 20 };
		System.out.println(Harry(arr, 0, arr.length - 1));
		System.out.println(HarryMixturesBU(arr));
	}

	public static int fibTD(int n, int[] strg) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (strg[n] != 0) {
			return strg[n];
		}

		int fib1 = fibTD(n - 1, strg);
		int fib2 = fibTD(n - 2, strg);

		int fib = fib1 + fib2;
		strg[n] = fib;
		return fib;

	}

	public static int fibBU(int n) {
		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];

		}
		return strg[n];

	}

	public static int fibBUSE(int n) {
		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;

		for (int slide = 1; slide <= n - 1; slide++) {
			int sum = strg[0] + strg[1];

			strg[0] = strg[1];
			strg[1] = sum;

		}
		return strg[1];

	}

	public static int MCM(int[] arr, int si, int ei) {
		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k < ei; k++) {

			int fh = MCM(arr, si, k);
			int sh = MCM(arr, k, ei);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fh + sh + sw;

			if (total < min) {
				min = total;
			}

		}
		return min;
	}

	public static int MCM_TD(int[] arr, int si, int ei, int strg[][]) {
		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		for (int k = si + 1; k < ei; k++) {

			int fh = MCM_TD(arr, si, k, strg);
			int sh = MCM_TD(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fh + sh + sw;

			if (total < min) {
				min = total;
			}

		}
		strg[si][ei] = min;

		return strg[si][ei];
	}

	public static int MCM_BU(int[] arr) {

		int strg[][] = new int[arr.length][arr.length];
		int n = arr.length;

		for (int slide = 1; slide <= n - 2; slide++) {
			for (int si = 0; si <= n - slide - 2; si++) {

				int ei = si + slide + 1;

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k < ei; k++) {

					int fh = strg[si][k];
					int sh = strg[k][ei];

					int sw = arr[si] * arr[k] * arr[ei];

					int total = fh + sh + sw;

					if (total < min) {
						min = total;
					}

				}
				strg[si][ei] = min;

			}
		}
		return strg[0][n - 1];

	}

	public static int WineProblem(int[] arr, int si, int ei, int yr) {
		if (si == ei) {
			return arr[si] * yr;

		}

		int start = WineProblem(arr, si + 1, ei, yr + 1) + arr[si] * yr;

		int end = WineProblem(arr, si, ei - 1, yr + 1) + arr[ei] * yr;

		int ans = Math.max(start, end);

		return ans;

	}

	public static int WineProblemTD(int[] arr, int si, int ei, int[][] strg) {
		int yr = arr.length - (ei - si + 1) + 1;

		if (si == ei) {
			return arr[si] * yr;

		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];

		}
		int start = WineProblemTD(arr, si + 1, ei, strg) + arr[si] * yr;

		int end = WineProblemTD(arr, si, ei - 1, strg) + arr[ei] * yr;

		int ans = Math.max(start, end);

		strg[si][ei] = ans;
		return ans;

	}

	public static int WineProblemBU(int[] arr) {

		int n = arr.length;
		int strg[][] = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				int yr = arr.length - (ei - si + 1) + 1;

				if (si == ei) {
					strg[si][ei] = arr[si] * yr;

				} else {

					int start = strg[si + 1][ei] + arr[si] * yr;

					int end = strg[si][ei - 1] + arr[ei] * yr;

					int ans = Math.max(start, end);

					strg[si][ei] = ans;
				}

			}
		}
		return strg[0][n - 1];

	}

	public static int Knapsack(int[] wt, int[] price, int cap, int vidx) {

		if (vidx == wt.length) {
			return 0;

		}
		int include = 0;
		if (wt[vidx] <= cap) {
			include = Knapsack(wt, price, cap - wt[vidx], vidx + 1) + price[vidx];
		}
		int exclude = Knapsack(wt, price, cap, vidx + 1);

		int ans = Math.max(include, exclude);
		return ans;
	}

	public static int KnapsackTD(int[] wt, int[] price, int cap, int vidx, int[][] strg) {

		if (vidx == wt.length) {
			return 0;
		}
		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}
		int include = 0;
		if (wt[vidx] <= cap) {
			include = Knapsack(wt, price, cap - wt[vidx], vidx + 1) + price[vidx];
		}
		int exclude = Knapsack(wt, price, cap, vidx + 1);

		int ans = Math.max(include, exclude);

		strg[vidx][cap] = ans;
		return ans;
	}

	public static int KnapsackBU(int[] wt, int[] price, int cap) {

		int nr = wt.length + 1;
		int nc = cap + 1;

		int[][] strg = new int[nr][nc];

		for (int row = 1; row <= wt.length; row++) {
			for (int col = 1; col < strg[0].length; col++) {

				int include = 0;

				if (col >= wt[row - 1]) {
					include = price[row - 1] + strg[row - 1][col - wt[row - 1]];
				}

				int exclude = strg[row - 1][col];

				strg[row][col] = Math.max(include, exclude);

			}

		}

		return strg[nr - 1][nc - 1];

	}

	public static void Display(int[][] strg) {
		for (int[] val : strg) {
			for (int item : val) {
				System.out.println(item + " ");
			}
			System.out.println();
		}

	}

	public static int Harry(int[] arr, int si, int ei) {
		if (si == ei) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fh = Harry(arr, si, k);
			int sh = Harry(arr, k + 1, ei);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);

			int total = fh + sh + sw;

			if (min > total) {
				min = total;
			}

		}
		return min;
	}

	public static int color(int[] arr, int si, int ei) {

		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += arr[i];

		}
		return sum % 100;
	}

	public static int HarryMixturesBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = slide + si;
				int min = Integer.MAX_VALUE;
				for (int k = si; k <= ei - 1; k++) {
					int fh = strg[si][k];
					int sh = strg[k + 1][ei];

					int sw = color(arr, si, k) * color(arr, k + 1, ei);

					int total = fh + sh + sw;

					if (min > total) {
						min = total;
					}

				}
				strg[si][ei] = min;
				return min;

			}
		}
		return strg[0][n - 1];
	}
}
