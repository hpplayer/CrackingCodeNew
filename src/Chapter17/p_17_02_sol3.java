package Chapter17;

import CtCILibrary.AssortedMethods;

public class p_17_02_sol3 {
	enum Piece {
		Empty, Red, Blue
	};

	public enum Check {
		Row, Column, Diagonal, ReverseDiagonal
	}

	public static Piece hasWon1(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] != Piece.Empty && board[i][0] == board[i][1]
					&& board[i][0] == board[i][2])
				return board[i][0]; // check columns
			if (board[0][i] != Piece.Empty && board[0][i] == board[1][i]
					&& board[0][i] == board[2][i]) {
				return board[0][i];// check row
			}
		}
		if (board[0][0] != Piece.Empty && board[0][0] == board[1][1]
				&& board[0][0] == board[2][2]) {
			return board[0][0];
		}// check diagnoal
		if (board[2][0] != Piece.Empty && board[2][0] == board[1][1]
				&& board[2][0] == board[0][2]) {
			return board[2][0];
		}// check reverse diagnoal

		return Piece.Empty;
	}

	/*
	 * focus on code reuse
	 */
	public static Piece hasWon2(Piece[][] board) {
		int N = board.length;
		Piece winner = Piece.Empty;

		for (int i = 0; i < N; i++) {
			winner = getWinner(board, i, Check.Row);// check row
			if (winner != Piece.Empty) {
				return winner;
			}

			// if cant find winner in rows, check columns
			winner = getWinner(board, i, Check.Column);// check row
			if (winner != Piece.Empty) {
				return winner;
			}
		}

		/*
		 * for diagonal and reverseDiagonal, we only use var, not fixed index,
		 * so we can, set fixed index to -1
		 */
		// if cant find winner in rows and columns, check diagonal

		winner = getWinner(board, -1, Check.Diagonal);// check row
		if (winner != Piece.Empty) {
			return winner;
		}

		// if cant find winner in rows and columns and check diagonal, check
		// reverse diagonal
		winner = getWinner(board, -1, Check.ReverseDiagonal);// check row
		if (winner != Piece.Empty) {
			return winner;
		}

		// cant find non-empty piece

		return Piece.Empty;

	}

	public static Piece getWinner(Piece[][] board, int fixed_index, Check check) {
		Piece color = getIthColor(board, fixed_index, 0, check);
		if (color == Piece.Empty) {
			return Piece.Empty;
		}
		for (int var = 1; var < board.length; var++) {
			if (color != getIthColor(board, fixed_index, var, check)) {// check
																		// fixed
																		// direction
				return Piece.Empty;
			}
		}
		return color;
	}

	public static Piece getIthColor(Piece[][] board, int index, int var,
			Check check) {
		int N = board.length;
		if (check == Check.Row) {
			return board[index][var];// index fixed, var varys
		} else if (check == Check.Column) {
			return board[var][index];
		} else if (check == Check.Diagonal) {
			return board[var][var];
		} else if (check == Check.ReverseDiagonal) {
			return board[N - 1 - var][var];
		}
		return Piece.Empty;
	}

	public static Piece hasWon3(Piece[][] board) {
		int N = board.length;
		int row = 0;
		int col = 0;

		// check row
		for (row = 0; row < N; row++) {
			if (board[row][0] != Piece.Empty) {
				for (col = 1; col < N; col++) {
					if (board[row][col] != board[row][col - 1]) {
						break;
					}
				}
				if (col == N) {
					return board[row][0];
				}
			}
		}

		// check col
		for (col = 0; col < N; col++) {
			if (board[0][col] != Piece.Empty) {
				for (row = 1; row < N; row++) {
					if (board[row][col] != board[row - 1][col]) {
						break;
					}
				}
				if (row == N) {
					return board[0][col];
				}
			}
		}
		// use row to replace col and row
		// check reverseDiagonal
		if (board[N - 1][0] != Piece.Empty) {
			for (row = 1; row < N; row++) {
				if (board[N - 1 - row][row] != board[N - row][row - 1]) {// compare one with its bot left one, so col -- row =+
					break;
				}
			}
			if (row == N) {
				return board[N - 1][0];
			}
		}

		// check Diagonal
		if (board[0][0] != Piece.Empty) {
			for (row = 1; row < N; row++) {
				if (board[row][row] != board[row - 1][row - 1]) {// compare one
																	// with its
																	// top left
																	// one
					break;
				}
			}
			if (row == N) {
				return board[0][0];
			}
		}

		return Piece.Empty;

	}

	public static Piece hasWon4(Piece[][] board) {
		int N = board.length;
		int i, j;

		Piece[] pieces = {Piece.Red, Piece.Blue };

		for (Piece color : pieces) {
			for (i = 0; i < N; i++) {
				boolean maybe_column = true;
				boolean maybe_row = true;
				for (j = 0; j < N; j++) {
					if (board[i][j] != color) {
						maybe_row = false;// check row, one row a time
					}
					if (board[j][i] != color) {
						maybe_column = false;// check col, one col a time
					}
				}

				if (maybe_column || maybe_row) {
					return color;
				}
			}
				
				boolean maybe_diag1 = true;
				boolean maybe_diag2 = true;
				for(i = 0; i < N; i++){
					if(board[i][i] != color){
						maybe_diag1 = false;
					}
					if(board[N-i-1][i] != color){
						maybe_diag2 = false;
					}
				}
				if (maybe_diag1 || maybe_diag2) {
					return color;
				}
					
		}
		return Piece.Empty;
	}
	
	public static Piece convertIntToPiece(int i) {
		if (i == 1) {
			return Piece.Blue;
		} else if (i == 2) {
			return Piece.Red;
		} else {
			return Piece.Empty;
		}
	}
	
	public static void main(String[] args) {
		for (int k = 0; k < 100; k++) {
			int N = 3;
			int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
			Piece[][] board = new Piece[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = convertIntToPiece(board_t[i][j]);
				}
			}
			//AssortedMethods.printMatrix(board_t);
			Piece p1 = hasWon1(board);
			Piece p2 = hasWon2(board);
			Piece p3 = hasWon3(board);
			Piece p4 = hasWon4(board);
			//System.out.println(p + " " + p2);
			if (p1 != p2 || p2 != p3 || p3 != p4) {
				System.out.println(p1 + " " + p2 + " " + p3 + " " + p4);
				AssortedMethods.printMatrix(board_t);
			}
		}
	}

}
