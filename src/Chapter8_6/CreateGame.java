package Chapter8_6;

public class CreateGame {
	private int width = 10;
	private int height = 10;
	private static Piece[][] board;
	public CreateGame(){
		board = new Piece[width][height];	
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				board[i][j] = new Piece();
				board[i][j].setAxisX(j);
				board[i][j].setAxisY(i);
				board[i][j].setValue(Integer.valueOf(Integer.toString(i) + Integer.toString(j)));
			}
		}
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Piece[][] getBoard() {
		return board;
	}

	public static void setBoard(Piece[][] board) {
		CreateGame.board = board;
	}

	public void AssignPiece(){
		if(width > 1 && height >1){
			/*
			 * we firstly assign pieces that are not in the boundary
			 */
			for(int i = 1; i < height-1; i++){
				for(int j = 1; j < width-1; j++){
					Piece temp = board[i][j];
					temp.setTop(board[i-1][j]);
					temp.setBot(board[i+1][j]);
					temp.setLeft(board[i][j-1]);
					temp.setRight(board[i][j+1]);
				}
			}
			
			//then we assign 4 boundary piece
			/*
			 * top left
			 */
			board[0][0].setBot(board[1][0]);
			board[0][0].setRight(board[0][1]);
			
			/*
			 * top right
			 */
			board[0][width-1].setBot(board[1][width-1]);
			board[0][width-1].setLeft(board[0][width-2]);
			/*
			 * bot left
			 */
			board[height-1][0].setTop(board[height-2][0]);
			board[height-1][0].setRight(board[height-1][1]);
			/*
			 * bot right
			 */
			board[height-1][width-1].setTop(board[height-2][width-1]);
			board[height-1][width-1].setLeft(board[height-1][width-2]);
			
			//finally, we assign boundary
			//top
			for(int i = 1; i< width-1; i++ ){
				board[0][i].setLeft(board[0][i-1]);
				board[0][i].setRight(board[0][i+1]);
				board[0][i].setBot(board[1][i]);
			}
			//bot
			for(int i = 1; i< width-1; i++ ){
				board[height-1][i].setLeft(board[height-1][i-1]);
				board[height-1][i].setRight(board[height-1][i+1]);
				board[height-1][i].setTop(board[height-2][i]);
			}
			//left
			for(int i = 1; i< height-1; i++ ){
				board[i][0].setBot(board[i+1][0]);
				board[i][0].setRight(board[i][1]);
				board[i][0].setTop(board[i-1][0]);
			}
			//right
			for(int i = 1; i< height-1; i++ ){
				board[i][width-1].setBot(board[i+1][width-1]);
				board[i][width-1].setLeft(board[i][width-2]);
				board[i][width-1].setTop(board[i-1][width-1]);
			}
			
		}else{
			/*
			 * some codes here if we have only one row or only one column
			 */
		}
		//System.out.println("Successful");
	}
	
/*
	public static void main(String[] args){
		CreateGame test = new CreateGame();
		test.AssignPiece();
		
		System.out.println(test.board[0][0].getBot().getAxisX());
		System.out.println(test.board[0][0].getBot().getAxisY());
		System.out.println(test.board[1][0].getAxisX());
		System.out.println(test.board[1][0].getAxisY());
		System.out.println(test.board[1][0].getValue());
	}
*/	
}
