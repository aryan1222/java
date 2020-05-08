package Lectures;

public class Recursion_Sortings {
	public static void main(String[] args) {
		int[]one= {2,5,10,15,20};
		int[]two= {3,17,18,25};
		int []arr=MergeTwoSortedArrays(one, two);

		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		// int[] arr = { 50, 40, 80, 90, 70, 10, 30, 60, 120 };
		// Quicksort(arr, 0, arr.length - 1);

//		int[] arr = { 5, 3, 7, 89, 5, 3, 2 };
//		int[] br = MergeSort(arr, 0, arr.length - 1);
//
//		for (int i = 0; i < br.length; i++) {
//			System.out.println(br[i] + " ");
//		}

	}

	public static int[] MergeTwoSortedArrays(int[] one, int[] two) {
		int i = 0;
		int j = 0;
		int k = 0;

		int[] arr = new int[one.length + two.length];

		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				arr[k] = one[i];
				i++;
				k++;

			} else {
				arr[k] = two[j];

				j++;
				k++;
			}
		}

		if (i == one.length) {
			while (j < two.length) {
				arr[k] = two[j];
				k++;
				j++;
			}
		}

		if (j == two.length) {
			while (i < one.length) {
				arr[k] = one[i];
				k++;
				i++;
			}
		}
		return arr;
	}

	public static int[] MergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;
		int[] firsthalf = MergeSort(arr, lo, mid);
		int[] secondhalf = MergeSort(arr, mid + 1, hi);

		int[] sorted = MergeTwoSortedArrays(firsthalf, secondhalf);

		return sorted;

	}

	public static void Quicksort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];
		int left = lo;
		int right = hi;

		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {

				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;

			}
		}
		Quicksort(arr, lo, right);

		Quicksort(arr, left, hi);
	}

}
