package Lectures;

public class Patterns {
	public static void main(String[] args) {
		PatternExtra();
	}

	public static void Pattern01() {
		int n = 5;
		int nst = n;
		for (int row = 0; row < n; row++) {
			for (int cst = 0; cst < n; cst++) {
				System.out.print("*" + "\t");

			}
			System.out.println();
		}

	}

	public static void Pattern02() {
		int n = 5;
		int nst = n;

		for (int row = 1; row <= n; row++) {
			for (int cst = 1; cst <= row; cst++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}

	}

	public static void Pattern03() {
		int n = 5;
		int nst = n;

		for (int row = 1; row <= n; row++) {
			for (int cst = n; cst >= row; cst--) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}

	public static void Pattern04() {
		int n = 5;
		int nst = 1;

		int nsp = n - 1;

		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");

			}
			nsp--;
			nst++;

			System.out.println();
		}
	}

	public static void Pattern05() {
		int n = 5;
		int nsp = 1;

		int nst = n;

		for (int row = 1; row <= n; row++) {

			for (int csp = 1; csp < nsp; csp++) {
				System.out.print(" ");
			}
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}
			nsp++;
			nst--;
			System.out.println();
		}

	}

	public static void Pattern06() {
		int n = 5;
		int nsp = 0;

		int nst = n;

		for (int row = 1; row <= n; row++) {
			for (int csp = 0; csp < nsp; csp++) {
				System.out.print(" ");
			}
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}
			System.out.println();
			nsp += 2;
			nst--;
		}
	}

	public static void Pattern07() {
		int n = 5;
		int nst = 5;

		for (int row = 1; row <= nst; row++) {

			for (int cst = 1; cst <= nst; cst++) {
				if (cst == 1 || cst == nst || row == 1 || row == n) {
					System.out.print("*" + " ");
				} else
					System.out.print(" " + " ");
			}
			System.out.println();
		}
	}

	public static void Pattern08() {
		int n = 5;
		int nst = 5;
		for (int row = 1; row <= n; row++) {
			for (int cst = 1; cst <= nst; cst++) {
				if (cst == row || cst == nst - row + 1) {
					System.out.print("*" + " ");
				} else
					System.out.print(" " + " ");
			}
			System.out.println();
		}
	}

	public static void Pattern09() {
		int n = 5;
		int nst = 1;

		int nsp = n - 1;

		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");

			}
			nsp--;
			nst += 2;

			System.out.println();
		}

	}

	public static void Pattern10() {
		int n = 5;
		int nsp = 1;

		int nst = 2 * n - 1;

		for (int row = 1; row <= n; row++) {

			for (int csp = 1; csp < nsp; csp++) {
				System.out.print(" ");
			}
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}
			nsp++;
			nst -= 2;
			System.out.println();
		}

	}

	public static void Pattern11() {
		int n = 5;
		int nst = 1;

		int nsp = n - 1;

		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			for (int cst = 1; cst <= nst; cst++) {
				if (cst % 2 != 0) {
					System.out.print("*");
				} else
					System.out.print(" ");

			}
			nsp--;
			nst += 2;

			System.out.println();
		}

	}

	public static void Pattern12() {
		int n = 5;
		int nst = 1;

		int nsp = n - 1;

		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			for (int cst = 1; cst <= nst; cst++) {
				if (cst % 2 != 0) {
					System.out.print("*");
				} else
					System.out.print("!");

			}
			nsp--;
			nst += 2;

			System.out.println();
		}
	}

	public static void Pattern13() {
		int n = 5;
		int nst = 1;
		for (int row = 1; row <= 2 * n - 1; row++) {
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*" + " ");
			}
			System.out.println();
			if (row < n) {
				nst++;
			} else
				nst--;

		}
	}

	public static void Pattern14() {
		int n = 5;
		int nst = 1;
		int nsp = n - 1;
		for (int row = 1; row <= 2 * n - 1; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" " + " ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*" + " ");
			}

			System.out.println();
			if (row < n) {
				nsp--;
				nst++;
			} else {
				nsp++;
				nst--;
			}

		}

	}

	public static void PatternExtra() {

		int n = 5;
		int nsp = n;
		int nst = 1;
		int val = n;//****

		for (int row = 1; row <= n + 1; row++) {
			// work for spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			nsp--;

			// work for stars
			int x=val;

			for (int cst = 0; cst < nst; cst++) {
				if (cst == nst / 2) {
					System.out.print("0");
				} else {
					System.out.print(x);
					if(cst<nst/2-1)//****
						x++;
					else if(cst>nst/2)
						x--;
				}

			}
			if(row>1) {
			val--;//****
			}
			nst += 2;
			System.out.println();
		}

	}
	
	
	
	
}
