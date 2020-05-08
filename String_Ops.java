package Lectures;

import java.util.Scanner;

public class String_Ops {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		// printChars(str);
		// substrings(str);
		// System.out.print(ispalandrome(str));
		// palandromicsubstrings(str);
		// reverse(str);
		// System.out.println(evenOdd(str));
		System.out.println(evenOdd2(str));
	}

	public static void printChars(String str) {
		for (int i = 0; i <= str.length() - 1; i++) {
			System.out.print(str.charAt(i));
		}
	}

	public static void substrings(String str) {
		for (int i = 0; i <= str.length() - 1; i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j) + " ");
			}
			System.out.println();
		}
	}

	public static boolean ispalandrome(String str) {
		int l = 0;
		int r = str.length() - 1;
		for (; l < r; l++, r--) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
		}
		return true;

	}

	public static void palandromicsubstrings(String str) {
		for (int i = 0; i <= str.length() - 1; i++) {
			for (int j = i + 1; j <= str.length(); j++) {

				String pal = str.substring(i, j);

				if (ispalandrome(pal)) {
					System.out.println(pal);
				}
			}
			System.out.println();
		}

	}

	public static void reverse(String str) {
		String subans = "";
		String ans = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (ch == '*' || ch == '+' || ch == '-' || ch == '/') {
				ans = ans + subans + ch;
				subans = "";
			} else
				subans = ch + subans;
		}
		ans = ans + subans;

		System.out.println(ans);

	}

	public static String evenOdd(String str) {

		StringBuilder sb = new StringBuilder(str);
		String app = "";

		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 0) {
				sb.setCharAt(i, (char) (sb.charAt(i) + 1));
			} else {
				sb.setCharAt(i, (char) (sb.charAt(i) - 1));
			}
		}
		return sb.toString();
	}

	// OR
	public static String evenOdd2(String str) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 0) {
				sb.append((char) (str.charAt(i) + 1));
			} else {
				sb.append((char) (str.charAt(i) - 1));

			}
		}
		return sb.toString();
	}

}
