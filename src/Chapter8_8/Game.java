package Chapter8_8;

public class Game {
	private Piece[][] board = new Piece[8][8];
	private Player A;// color black
	private Player B;// color whtite
	private static Game instance;

	public Piece getPiece(int x, int y) {
		return board[x][y];
	}

	/*
	 * [0]: top [1]: bot [2]: left [3]:right
	 */
	public boolean[] checkSurrounding(Piece p) {
		boolean[] result = new boolean[4];
		int x = p.getX();// height
		int y = p.getY();// width
		Color c = p.getColor();
		if (x - 1 >= 0) {
			if (getPiece(x - 1, y).getColor() != c) {
				result[0] = true;
			}
		}
		if (x + 1 <= 7) {
			if (getPiece(x + 1, y).getColor() != c) {
				result[1] = true;
			}
		}
		if (y - 1 >= 0) {
			if (getPiece(x, y - 1).getColor() != c) {
				result[2] = true;
			}
		}
		if (y + 1 <= 7) {
			if (getPiece(x, y + 1).getColor() != c) {
				result[3] = true;
			}
		}
		return result;

	}

	public static Game getInstance() {
		if (instance == null)
			instance = new Game();
		return instance;
	}

	public boolean locateNewPiece(Piece p) {
		int x = p.getX();
		int y = p.getY();
		if (board[x][y] != null)
			return false;
		board[x][y] = p;
		return true;
	}

	public int detectLength(int direction, Piece p) {
		int length = 0;
		switch (direction) {
		case 0:
			for (int i = (p.getX() - 1) - 0; i >= 0; i--) {
				if (getPiece(i, p.getY()).getColor() == p.getColor())
					length++;
			}
			break;
		case 1:
			for (int i = (p.getX() + 1); i < 8; i++) {
				if (getPiece(i, p.getY()).getColor() == p.getColor())
					length++;
			}
			break;
		case 2:
			for (int i = (p.getY() - 1) - 0; i >= 0; i--) {
				if (getPiece(p.getX(), i).getColor() == p.getColor())
					length++;
			}
			break;
		case 3:
			for (int i = (p.getY() - 1); i < 8; i++) {
				if (getPiece(p.getX(), i).getColor() == p.getColor())
					length++;
			}
			break;
		default:
			break;
		}
		return length;
	}
	
	public boolean checkClearance(int direction, int length, Piece p){
		switch (direction) {
		case 0:
	
			if(p.getX()-length - 1 >= 0 && getPiece(p.getX()-length -1, p.getY()) != null){
				for (int i = (p.getX() - 1) - 0; i >= 0; i--){
					getPiece(i, p.getY()).setColor(p.getColor());
				}
				return true;
			}
			return false;
		
		case 1:
			if(p.getX()+length + 1 <= 7 && getPiece(p.getX()+length +1, p.getY()) != null){
				for (int i = (p.getX() + 1); i < 8; i++) {
					getPiece(i, p.getY()).setColor(p.getColor());
				}
				return true;
			}
		return false;
		
		case 2:
			if(p.getY()-length - 1 >= 0 && getPiece(p.getX(), p.getY() -length -1) != null){
				for (int i = (p.getY() - 1) - 0; i >= 0; i--) {
				getPiece(p.getX(), i).setColor(p.getColor());
				}
				return true;
			}
	
			return false;
			
		case 3:
			if(p.getY()+length+1 <= 7 && getPiece(p.getX(), p.getY() +length +1) != null){
				for (int i = (p.getY() - 1); i < 8; i++) {
				getPiece(p.getX(), i).setColor(p.getColor());
				}
				return true;
			}
			return false;
		default:
			return false;
		}
	}
	public boolean HandleNewMove(Piece p) {
		int x = p.getX();
		int y = p.getY();
		boolean[] temp = checkSurrounding(p);
		for (int i = 0; i < 3; i++) {
			if (temp[i]) {
				int length = detectLength(i, p);
				return (checkClearance(i, length, p));
			}
		}
		
		if(CheckFull()){
			WhosWinner();
			return true;
		}
		return false;
	}

	public boolean CheckFull(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j] == null) return false;
			}
		}
		return true;
	}
	
	public Player WhosWinner(){
		int countA = 0;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j].getColor() == Color.black) countA++;
			}
		}
		if (countA >= 64/2){
			return A;
		}else{
			return B;
		}
	
	}
	public void assignPlayer(Player p) {
		if (A == null) {
			A = new Player();
			A.setColor(Color.black);
			A.setName(p.getName());
			p = A;
		} else {
			B = new Player();
			B.setColor(Color.white);
			B.setName(p.getName());
			p = B;
		}
	}
	

}
