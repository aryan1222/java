 package Lectures;

import java.util.ArrayList;

public class Recursion_Get {
	public static void main(String[] args) {

		 System.out.println(getss("abc"));
		// System.out.println(getSS_ASCII("ab"));
	    // System.out.println(getsKPC("145"));
		// System.out.println(getPermutation("abc"));
		// System.out.println(getBoardPath(0,10).size());
		// System.out.println(getcointoss(3));
	    // System.out.println(getmazepath(0, 0, 2, 2));
		// System.out.println(getmazepathMM(0, 0, 2, 2));
	}

	public static ArrayList<String> getss(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getss(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);

		}
		return mr;
	}

	public static ArrayList<String> getSS_ASCII(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		int ch1 = str.charAt(0);
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getSS_ASCII(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val);

			mr.add(ch + val);
			mr.add(ch1 + val);

		}
		return mr;

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

	public static ArrayList<String> getsKPC(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getsKPC(ros);

		String code = getCode(ch);
		ArrayList<String> mr = new ArrayList<>();
		for (int i = 0; i < code.length(); i++) {
			for (String val : rr) {
				mr.add(code.charAt(i) + val);

			}
		}
		return mr;

	}

	public static ArrayList<String> getPermutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getPermutation(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				String ans = val.substring(0, i) + ch + val.substring(i);
				mr.add(ans);
			}
		}
		return mr;

	}

	public static ArrayList<String> getBoardPath(int curr, int end) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		for (int dice = 1; dice <= 6 && curr <= end; dice++) {
			ArrayList<String> rr = getBoardPath(curr + dice, end);

			for (String val : rr) {
				mr.add(dice + val);

			}
		}
		return mr;

	}

	public static ArrayList<String> getcointoss(int n) {

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rr = getcointoss(n - 1);

		for (String val : rr) {
			mr.add("H" + val);
			mr.add("V" + val);
		}
		return mr;
	}

	public static ArrayList<String> getmazepath(int cc, int cr, int ec, int er) {

		if (cc == ec && cr == er) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		if (cc <= ec) {
			ArrayList<String> rrh = getmazepath(cc + 1, cr, ec, er);

			for (String val : rrh) {
				mr.add("H" + val);
			}
		}
		if (cr <= er) {
			ArrayList<String> rrv = getmazepath(cc, cr + 1, ec, er);

			for (String val : rrv) {
				mr.add("V" + val);
			}
		}
		return mr;
	}

	public static ArrayList<String> getmazepathMM(int cc, int cr, int ec, int er) {
		if (cc == ec && cr == er) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		if (cc <= ec) {
			for (int move = 1; move <= ec - cc; move++) {
				ArrayList<String> rrh = getmazepathMM(cc + move, cr, ec, er);

				for (String val : rrh) {
					mr.add("H" + move + val);
				}
			}
		}
		if (cr <= er) {
			for (int move = 1; move <= er - cr; move++) {
				ArrayList<String> rrv = getmazepathMM(cc, cr + move, ec, er);

				for (String val : rrv) {
					mr.add("V" + move + val);
				}
			}
		}
		return mr;
	}

	public static ArrayList<String> getparanthesis(int n) {

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getparanthesis(n - 1);
		for (String val : rr) {
         mr.add("("+val);
		}

		return mr;
	}
 
	
}
