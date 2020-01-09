package Lectures;

import java.util.Scanner;

public class Number_System {

	public static void main(String[] args) {
		AnybaseToDecimal();
		BinaryToDecimal();
		DecimalToAnybase();
		OctalToBinary();

	}

	public static void AnybaseToDecimal() {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int base = scn.nextInt();
		int rem;
		int multiplier = 1;
		int ans = 0;
		while (N != 0) {
			rem = N % 10;
			N = N / 10;

			ans = ans + (rem * multiplier);
			multiplier = multiplier * base;
		}
		System.out.print(ans);

	}

	public static void BinaryToDecimal() {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int rem;
		int multiplier = 1;
		int ans = 0;
		while (N != 0) {
			rem = N % 10;
			N = N / 10;

			ans = ans + (rem * multiplier);
			multiplier = multiplier * 2;
		}
		System.out.print(ans);

	}

	public static void DecimalToAnybase() {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();

		int rem;
		int multiplier = 1;
		int ans = 0;
		while (N != 0) {
			rem = N % 8;
			N = N / 8;

			ans = ans + (rem * multiplier);
			multiplier = multiplier * 10;
		}
		System.out.print(ans);

	}

	public static void OctalToBinary() {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int rem;
		int multiplier = 1;
		int ansd = 0;
		while (N != 0) {
			rem = N % 10;
			N = N / 10;

			ansd = ansd + (rem * multiplier);
			multiplier = multiplier * 8;
		}

		int y = ansd;
		int remb;
		int multiplierb = 1;
		int ansb = 0;
		while (y != 0) {
			remb = y % 2;
			y = y / 2;

			ansb = ansb + (remb * multiplierb);
			multiplierb = multiplierb * 10;
		}
		System.out.print(ansb);

	}

}
