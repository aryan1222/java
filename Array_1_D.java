package Lectures;

import java.util.Scanner;


public class Array_1_D {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
//		int array[] = TakeInput();
//		System.out.println(max(array));
		int[]arr= {1,2,3,4,5};
		System.out.println(		BinarySearch2(arr, 2));
	}

	public static int[] TakeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}
	

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
	

	public static int max(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	
	public static int search(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == item) {
				return i;
			}
		}
		return -1;
	}
	
	public static int BinarySearch(int arr[], int item) {
		int lo = 0;
		int hi = arr.length - 1;
		int mid = (lo + hi) / 2;


		for (int i = lo; i <= hi; i++) {

			if (arr[mid] == item) {
				return mid;

			} else if (item > arr[mid]) {
				lo = mid + 1;

			} else
				hi = mid - 1;

		}
		return -1;
	}
	
	
	public static int BinarySearch2(int arr[],int item) {
		int lo=0;
		int hi=arr.length-1;
		
		while(lo<=hi) {
			int mid=(lo+hi)/2;
			
			if(arr[mid]<item) {
				lo=mid+1;
			}else if(arr[mid]>item) {
				hi=mid-1;
			}else
				return mid;
		}
		return -1;
	}

	public static void Bubblesort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int i = 0; i < arr.length - 1 - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}

	}

	public static void Selectionsort(int[] arr) {

		for (int counter = 0; counter < arr.length; counter++) {
			int min = counter;

			for (int j = counter + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}

			int temp = arr[counter];
			arr[counter] = arr[min];
			arr[min] = temp;

		}
	}

	public static void insertionsort() {
		
	}

}
