package Lectures;

public class Recursion_Print {
	static int count = 0;

	public static void main(String[] args) {
		// printSS("abc","");
		// printSSAscii("ab", "");
		// KPC("145", "");
		// Permutation("abcd", "");
		// Cointosses(3,"");
		// validParanthesis(5, "", 0, 0);
		// BoardPath(0, 10, "");
	System.out.print(MazePath(0, 2, 0, 2, ""));
	lexicoCounting(0, 1000);
		//coinTossNoConsecutiveHead(3, "");
	}

	public static void printSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans);
		printSS(roq, ans + ch);

	}

	public static void printSSAscii(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		int ch1 = ques.charAt(0);
		String roq = ques.substring(1);

		printSSAscii(roq, ans);
		printSSAscii(roq, ans + ch);
		printSSAscii(roq, ans + ch1);

	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";

		else if (ch == '2')
			return "def";

		else if (ch == '3')
			return "ghi";

		else if (ch == '4')
			return "jk";

		else if (ch == '5')
			return "lmno";

		else if (ch == '6')
			return "pqr";

		else if (ch == '7')
			return "stu";

		else if (ch == '8')
			return "vwx";

		else if (ch == '9')
			return "yz";

		else if (ch == '0')
			return "@#";

		else
			return "";
	}

	public static void KPC(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			KPC(ros, ans + code.charAt(i));
		}
	}

	public static void Permutation(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(0);

			String ros = ques.substring(0, i) + ques.substring(i + 1);

			Permutation(ros, ans + ch);

		}

	}

	public static void Cointosses(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}

		Cointosses(n - 1, ans + "H");
		Cointosses(n - 1, ans + "V");

	}

	public static void validParanthesis(int n, String ans, int open, int close) {
		if ((open == n) && (close == n)) {
			System.out.println(ans);
			return;
		}
		if (open > n || close > n || close > open) {
			return;
		}

		validParanthesis(n, ans + "(", open + 1, close);
		validParanthesis(n, ans + ")", open, close + 1);
	}

	public static void BoardPath(int curr, int end, String ans) {

		if (curr == end) {
			count++;
			System.out.println(count + ". " + ans);

			return;
		}
		if (curr > end) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			BoardPath(curr + dice, end, ans + dice);
		}

	}

	public static int MazePath(int cr, int er, int cc, int ec, String ans) {
		if (cc == ec && cr == er) {
			System.out.println(ans);
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}

		int ch = MazePath(cr, er, cc + 1, ec, ans + "H");

		int cv = MazePath(cr + 1, er, cc, ec, ans + "V");

		return cv + ch;

	}

	public static void lexicoCounting(int curr, int end) {
		if (curr > end) {

			return;
		}
		System.out.println(curr);

		int i = 0;

		if (curr == 0) {
			i = 1;
		}

		for (; i < 10; i++) {
			lexicoCounting(curr *10 + i, end);

		}
	}

	public static void coinTossNoConsecutiveHead(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		if (ans.length() == 0 || ans.charAt(ans.length() - 1) != 'H')
			coinTossNoConsecutiveHead(n - 1, ans + "H");
		
		coinTossNoConsecutiveHead(n - 1, ans + "V");

	}
}
