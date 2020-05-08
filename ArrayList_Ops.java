package Lectures;

import java.util.ArrayList;

public class ArrayList_Ops {
	public static void main(String[] args) {

//		int[] one = { 10, 10, 20, 20, 30, 35, 35 };
//		int[] two = { 10, 10, 10, 10, 20, 35, 35 };
//		System.out.println(intersection(one, two));

		int[] a1 = { 9, 9, 7, 9 };
		int[] a2 = { 8, 8 };
		System.out.println(Sum(a1, a2));

	}

	public static ArrayList<Integer> intersection(int[] one, int two[]) {
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0, j = 0; i < one.length && j < two.length;) {

			if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			} else {
				ans.add(one[i]);
				i++;
				j++;
			}
		}
		return ans;

	}

	public static ArrayList<Integer> Sum(int[] a1, int a2[]) {
		ArrayList<Integer> ans = new ArrayList<>();
		int carry = 0;

		for (int i = a1.length - 1, j = a2.length - 1; i >= 0 || j >= 0; i--, j--) {
			int sum = carry;

			if (i >= 0) {
				sum += a1[i];

			}
			if (j >= 0) {
				sum += a2[j];
			}
			int rem = sum % 10;
			ans.add(0, rem);
			carry = sum / 10;

		}
		if (carry != 0) {
			ans.add(0, carry);
		}

		return ans;
	}

}
