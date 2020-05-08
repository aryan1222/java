package Lectures;

public class BackTracking {
	static int count = 0;

	public static void main(String[] args) {
		// QueenPermutations(new boolean[4], 2, 0, "");
		// QueenCombination(new boolean[4], 2, 0, "", -1);
//           int[] arr= {2,3,5,6};
//		CoinChange(arr,10,"",0);
		// int[] denom = { 2, 3, 5, 6 };
		// CoinChange(denom, 10, "", 0);

		// QueenCombinationBox(new boolean[4], 0, 0, 2, "");
//		QueenCombinationBox2D2by4(new boolean[2][4], 0, 0, 0, 1, "");
		//QueenCombinationBox2D4by4(new boolean[4][4], 0, 0, 0, 4, "");

		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		blockedMaze(maze, 0, 0, "", visited);

	}

	public static void QueenPermutations(boolean[] board, int tq, int qpsf, String ans) {
		if (qpsf == tq) {
			count++;
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i] == false) {
				board[i] = true;
				QueenPermutations(board, tq, qpsf + 1, ans + "q" + (qpsf + 1) + "b" + i + " ");
				board[i] = false;
			}
		}
	}

	public static void QueenCombination(boolean[] board, int tq, int qpsf, String ans, int lastcellused) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		for (int i = lastcellused + 1; i < board.length; i++) {
			// if (board[i] == false) {
			board[i] = true;
			QueenCombination(board, tq, qpsf + 1, ans + "q" + (qpsf + 1) + "b" + i + " ", i);
			board[i] = false;
			// }
		}
	}

	public static void CoinChange(int[] denom, int amount, String ans, int j) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		if (amount < 0) {
			return;
		}

		for (int coin = j; coin < denom.length; coin++) {
			// if(amount>=denom[coin])
			CoinChange(denom, amount - denom[coin], ans + denom[coin], coin);
		}

	}

	public static void QueenCombinationBox(boolean[] board, int idx, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		if (idx == board.length) {
			return;
		}
        //no
		QueenCombinationBox(board, idx + 1, qpsf, tq, ans);

		// yes
		board[idx] = true;
		QueenCombinationBox(board, idx + 1, qpsf + 1, tq, ans + "b" + idx);
		board[idx] = false;

	}

	public static void QueenCombinationBox2D2by4(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}
		if (col == board[0].length) {
			row = row + 1;
			col = 0;
		}
		if (row == board.length) {
			return;
		}
		// yes
		board[row][col] = true;
		QueenCombinationBox2D2by4(board, row, col + 1, qpsf + 1, tq, ans + "[" + row + ":" + col + "]");
		board[row][col] = false;
		QueenCombinationBox2D2by4(board, row, col + 1, qpsf, tq, ans);

	}

	public static void QueenCombinationBox2D4by4(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		if (col == board[0].length) {
			row = row + 1;
			col = 0;
		}

		if (row == board.length) {
			return;
		}

		// yes
		if (isItSafe(board, row, col)) {
			board[row][col] = true;
			QueenCombinationBox2D4by4(board, row, col + 1, qpsf + 1, tq, ans + "[" + row + "-" + col + "]");
			board[row][col] = false;
		}

		QueenCombinationBox2D4by4(board, row, col + 1, qpsf, tq, ans);

	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {

		// vertically up
		int r = row - 1;
		int c = col;

		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c++;
		}

		// row
		r = row;
		c = col - 1;

		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}

			c--;

		}

		return true;

	}

	public static void blockedMaze(int[][] maze, int cr, int cc, String ans, boolean[][] visited) {

		System.out.println("["+cr+":"+cc+"]");
		System.out.println(ans);
if (cr == maze.length - 1 && cc == maze[0].length - 1) {
			System.out.println("***********"+ans+"****************");
			return;
		}

		if (cr == maze.length || cc == maze[0].length || cr == -1 || cc == -1 || visited[cr][cc] || maze[cr][cc] == 1) {
			return;
		}
		visited[cr][cc] = true;

		blockedMaze(maze, cr - 1, cc, ans + "T", visited); // Top
		blockedMaze(maze, cr, cc - 1, ans + "L", visited); // Left

		blockedMaze(maze, cr + 1, cc, ans + "B", visited); // Bottom
		blockedMaze(maze, cr, cc + 1, ans + "R", visited); // right

		visited[cr][cc] = false;

	}
	
	
	public static void nKnights(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			count++;
			System.out.print(ans+" ");
			return;
		}

		if (col == board[0].length) {
			row = row + 1;
			col = 0;
		}

		if (row == board.length) {
			return;
		}

		// yes
		if (isItSafe(board, row, col)) {
			board[row][col] = true;
			nKnights(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "} ");
			board[row][col] = false;
		}

		nKnights(board, row, col + 1, qpsf, tq, ans);

	}

	private static boolean isItSafe1(boolean[][] board, int row, int col) {

		int row1[]= {-1,-2,-2,-1};
		int col1[]= {-2,-1,+1,+2};
		
		for(int i=0;i<row1.length;i++) {
			int nr=row+row1[i];
			int nc=col+col1[i];
			
			if(nr>=0&&nc>=0&&nr<board.length&&nc<board[0].length&&board[nr][nc]) {
				return false;
			}
			
			
		}
		
		return true;
	}

	
	

}
