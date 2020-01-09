package Lectures;

import java.util.Scanner;

public class Rotate_and_Inverse {
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Rotate();
		Inverse();
		System.out.println("hello");
	}

	public static void Rotate() {

		int n = s.nextInt();
		int r = s.nextInt();

		// no of digits
		int temp = n;
		int nod = 0;
		while (temp != 0) {
			nod++;
			temp = temp / 10;
		}

		r = r % nod;
		if (r < 0) {
			r = r + nod;
		}

		// logic
		int divisor = (int) Math.pow(10, r);
		int multiplier = (int) Math.pow(10, nod - r);

		int rem = n % divisor;
		int quotient = n / divisor;
		int ans = rem * multiplier + quotient;

		System.out.println(ans);
	}

	public static void Inverse() {
		int n = s.nextInt();
		int place = 1;
		int ans = 0;

		while (n != 0) {
			int rem = n % 10;
			ans = ans + place * (int) Math.pow(10, rem - 1);

			// variables change for next iteration
			place++;
			n = n / 10;
		}

		System.out.println(ans);
	}
}
