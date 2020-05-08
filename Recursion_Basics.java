package Lectures;

public class Recursion_Basics {
	public static void main(String[] args) {
		//PD(5);
		// PI(5);
		// PDI(3);
		//PDISkips(8);
		// System.out.println(fact(5));
		// System.out.println(power(3,2));
		System.out.println(fib(8));

		 //int arr[] = { 10,20,30,40 };
		// displayArray(arr, 0);
		// ArrayRev(arr, 3);
		// displayArrayReverse(arr, 0);

		// int arr[] = { 40,80,10,30 };
		// System.out.println(max(arr,0));

		//int arr[] = { 10, 20, 30, 5, 7, 30, 90 };
		// System.out.println(findfirstoccurenceindex(arr,0,30));
		// System.out.println(findlastoccurenceindex(arr,0,30));
		//int res[] = findalloccurenceindex(arr, 0, 30, 0);
		//for (int i = 0; i < res.length; i++) {
			//System.out.println(res[i]);

		//}
	}


	public static void PD(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);

		PD(n - 1);

	}

	public static void PI(int n) {
		if (n == 0) {
			return;
		}
		PI(n - 1);
		System.out.println(n);

	}

	public static void PDI(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);

	}

	public static void PDISkips(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 == 0)
			System.out.println(n);

		PDISkips(n - 1);

		if (n % 2 != 0)
			System.out.println(n);

	}

	public static int fact(int n) {
		if (n == 1) {
			return 1;
		}
		int fnum = fact(n - 1) * n;
		return fnum;

	}

	public static int power(int x, int n) {
		
		if (n == 0) {
			return 1;
		}
		int sp = power(x, n - 1);
		int bp = sp * x;
		return bp;
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		
		int f1 = fib(n - 1);
		int f2 = fib(n - 2);

		int fib = f1 + f2;
		return fib;
	}

	public static void displayArray(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		System.out.println(arr[vidx]);
		displayArray(arr, vidx + 1);
	}

	public static void displayArrayReverse(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		
		displayArrayReverse(arr, vidx + 1);
		System.out.println(arr[vidx]);

	}
	public static void ArrayRev(int[] arr, int i) {
		if (i == 0) {
			System.out.println(arr[i]);

			return;
		}

		System.out.println(arr[i]);
		ArrayRev(arr, i - 1);

	}


	public static int max(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}
		int sp = max(arr, vidx + 1);

		if (arr[vidx] > sp) {
			return arr[vidx];

		}
		return sp;
	}

	public static int findfirstoccurenceindex(int arr[], int vidx, int item) {
		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == item) {
			return vidx;
		}
		int recRes = findfirstoccurenceindex(arr, vidx + 1, item);
		return recRes;
		
	}

	public static int findlastoccurenceindex(int arr[], int vidx, int item) {
		if (vidx == arr.length) {
			return -1;
		}
		int recRes = findlastoccurenceindex(arr, vidx + 1, item);

		if (arr[vidx] == item && recRes == -1) {
			return vidx;

		}
		return recRes;
	}

	public static int[] findalloccurenceindex(int arr[], int vidx, int item, int count) {
		if (vidx == arr.length) {
			int br[] = new int[count];
			return br;
		}
		
		if (arr[vidx] == item) {
			int recRes[] = findalloccurenceindex(arr, vidx + 1, item, count + 1);
			recRes[count] = vidx;
			return recRes;
		} 
		else {
			int recRes[] = findalloccurenceindex(arr, vidx + 1, item, count);
			return recRes;
		}

	}

}
