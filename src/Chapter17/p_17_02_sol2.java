package Chapter17;

public class p_17_02_sol2 {
	public static int convertBoardToInt(char[][] board){
		int factor = 1; // 3^factor(factor: unique to each space)
		int sum = 0; //unique id for each choice of board;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				int v = 0;//choice of this space
				if(board[i][j] == 'x'){
					v = 1;
				}else if(board[i][j] == 'o'){
					v = 2;
				}
				
				sum += v* factor;
				factor *= 3;//unique to each space, choice of 3 make it impossible to mass with v: 0,1,2
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		char[][] board = { 
				{'x', 'x', 'o'},
				{' ', 'x', ' '},
				{' ', ' ', 'x'}};
		char[][] board2 = { 
				{'x', 'x', 'o'},
				{' ', 'x', ' '},
				{'o', 'o', 'x'}};
		char[][] board3 = { 
				{'x', 'x', 'o'},
				{'x', 'x', ' '},
				{' ', ' ', 'x'}};
		char[][] board4 = { 
				{'x', 'x', 'o'},
				{' ', 'x', ' '},
				{'o', ' ', 'x'}};
		
		int v = convertBoardToInt(board);
		int v2 = convertBoardToInt(board2);
		int v3 = convertBoardToInt(board3);
		int v4 = convertBoardToInt(board4);
		
		System.out.println(v);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
	}
}
