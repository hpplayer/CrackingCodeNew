package Chapter17;

public class p_17_02 {
	public static boolean test(int[][] board, int player, int N) {
		int count = 0;
		// diagonal
		for (int i = 0; i < N - 1; i++) {
			if (board[i][i] == player) {
				count++;
			}
		}

		if (count == N - 1)
			return true;

		count = 0;
		for (int i = 0; i < N - 1; i++) {
			if (board[i][N - 1 - i] == player) {
				count++;
			}
		}

		if (count == N - 1)
			return true;
		// done diagnoal

		// check horizonal
		count = 0;
		for (int i = 0; i < N - 1; i++) {
			if (board[i][0] == player) {
				for (int j = 1; j < N - 1; j++) {
					if (board[i][j] == player) {
						count++;
					}
				}
			}
			count = 0;
		}
		if (count == N - 1)
			return true;
		// check vertical
		count = 0;
		for (int i = 0; i < N - 1; i++) {
			if (board[0][i] == player) {
				for (int j = 1; j < N - 1; j++) {
					if (board[j][i] == player) {
						count++;
					}
				}
			}
			count = 0;
		}
		if (count == N - 1)
			return true;

		return false;
	}

	public static void main(String[] args) {
		int[][] board = { { 1, 1, 0,0 }, { 0, 1, 0,0 }, { 0, 0, 1,0 },{1,1,1,0} };

		char[][] board2 = { { 'x', 'x', 'o' }, { ' ', 'x', ' ' },
				{ ' ', ' ', 'x' } };
		System.out.println(test(board, 1, 4));

	}
}
