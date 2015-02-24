package Chapter8_8_sol2;

public class Board {
	private int blackCount = 0;
	private int whiteCount = 0;
	private Piece[][] board;
	
	public Board(int r, int c){
		board = new Piece[r][c];
	}
	
	public void initialize(){
		int middleRow = board.length /2;
		int middleColumn = board[middleRow].length /2;
		board[middleRow][middleColumn] = new Piece(Color.White);
		board[middleRow + 1][middleColumn] = new Piece(Color.Black);
		board[middleRow + 1][middleColumn +1] = new Piece(Color.White);
		board[middleRow][middleColumn +1] = new Piece(Color.Black);
		blackCount = 2;
		whiteCount =2 ;
	}
	
	private int flipSection(int row, int column, Color color, Direction direction){
		int r = 0;
		int c = 0;
		switch(direction){
		case up:
			r = -1;
			break;
		case down:
			r = 1;
			break;
		case left:
			c = -1;
			break;
		case right:
			c = 1;
			break;
		}
		
		if(row < 0 || row >= board.length || column < 0 || column >= board[row].length || board[row][column] == null){
			return -1;
		}
		
		if(board[row][column].getColor() == color){
			/*
			 * if the color is same, it will stop here
			 */
			return 0;
		}
		
		// this is super important !!!! it replaces the for loop in my method!
		int flipped = flipSection(row + r, column +c, color, direction);
		if(flipped < 0){
			return -1;
		}
		
		board[row][column].flip();
		return flipped +1;
	}
	public boolean placeColor(int row, int column, Color color){
		if(board[row][column] != null){
			return false;
		}
		
		int[] results = new int[4];
		results[0] = flipSection(row-1, column, color, Direction.up);
		results[1] = flipSection(row + 1, column, color, Direction.down);
		results[2] = flipSection(row, column +1, color, Direction.right);
		results[3] = flipSection(row, column - 1, color, Direction.left);
		
		int flipped = 0;
		for (int result: results){
			if(result > 0){
				flipped += result;
			}
		}
		
		if(flipped < 0) return false;
		
		board[row][column] = new Piece(color);
		updateScore(color, flipped+ 1);
		return true;
	}
	
	public void updateScore(Color c, int p){
		if(c == Color.Black){
			whiteCount -= p -1; // 1 is the one we just placed
			blackCount += p;
		}else{
			whiteCount += p; // 1 is the one we just placed
			blackCount -= p -1;
		}
	}
	
	public int getScoreForColor(Color c){
		return (c == Color.Black? blackCount : whiteCount);
	}
	
	public void printBoard() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if (board[r][c] == null) {
					System.out.print("_");
				} else if (board[r][c].getColor() == Color.White) {
					System.out.print("W");
				} else {
					System.out.print("B");
				}
			}
			System.out.println();
		}
	}
}
