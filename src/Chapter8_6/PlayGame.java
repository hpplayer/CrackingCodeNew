package Chapter8_6;
/*
 * too hard 
 * haven't finished cryyyyyyyyyyy
 */
import java.util.Random;
import java.util.ArrayList;

public class PlayGame {
	int length;
	Piece[] pieceArray;
	ArrayList<Piece> ALP;
	int shuffleTime = 2;
	CreateGame game;
	ArrayList<ArrayList<Piece>> sol;
	Piece[][] answ;

	public PlayGame() {

		game = new CreateGame();
		game.AssignPiece();
		this.length = game.getWidth() * game.getHeight();
		answ = new Piece[game.getHeight()][game.getWidth()];
		ALP = new ArrayList<Piece>();
		// pieceArray = new Piece[length];
		// int z = 0;
		for (int i = 0; i < game.getHeight(); i++) {
			for (int j = 0; j < game.getWidth(); j++) {
				ALP.add(game.getBoard()[i][j]);
				// pieceArray[z] =game.getBoard()[i][j];
				// z++;
			}
		}
	}

	public void print(ArrayList<Piece> ary) {

		for (int i = 1; i < length + 1; i++) {
			if (i % (game.getWidth()) == 0) {
				if (ary.get(i - 1).getValue() < 10) {
					System.out.print("0" + ary.get(i - 1).getValue() + " ");
					System.out.println();
				} else {
					System.out.print(ary.get(i - 1).getValue() + " ");
					System.out.println();
				}
			} else {
				if (ary.get(i - 1).getValue() < 10) {
					System.out.print("0" + ary.get(i - 1).getValue() + " ");
				} else {
					System.out.print(ary.get(i - 1).getValue() + " ");
				}
			}

		}
	}

	public void print(Piece[] ary) {
		Piece[][] temp = new Piece[game.getHeight()][game.getWidth()];
		int z = 0;
		for (int i = 0; i < game.getHeight(); i++) {
			for (int j = 0; j < game.getWidth(); j++) {
				temp[i][j] = ary[z];
				z++;
			}
		}
		printMatrix(temp);
	}

	public void printMatrix(Piece[][] board) {
		for (int i = 0; i < game.getHeight(); i++) {
			for (int j = 0; j < game.getWidth(); j++) {
				if (board[i][j].getValue() < 10) {
					System.out.print("0" + board[i][j].getValue() + " ");
				} else {
					System.out.print(board[i][j].getValue() + " ");
				}

			}
			System.out.println();
		}
	}

	public void Shuffle() {
		Random rd = new Random();
		for (int i = 0; i < shuffleTime; i++) {
			int ranIndex1 = rd.nextInt(length);
			int ranIndex2 = rd.nextInt(length);
			Piece temp = pieceArray[ranIndex1];
			pieceArray[ranIndex1] = pieceArray[ranIndex2];
			pieceArray[ranIndex2] = temp;
		}
	}

	public void Shuffle2() {
		Random rd = new Random();
		for (int i = 0; i < shuffleTime; i++) {
			int ranIndex1 = rd.nextInt(length);
			int ranIndex2 = rd.nextInt(length);
			Piece temp = ALP.get(ranIndex1);
			ALP.set(ranIndex1, ALP.get(ranIndex2));
			ALP.set(ranIndex2, temp);
		}
	}

	public boolean fitsWith(Piece A, Piece B) {
		return (A.top == B || A.bot == B || A.left == B || A.right == B);
	}

	public void play() {
		sol = new ArrayList<ArrayList<Piece>>();
		// we exclude the last index here, so every listed element has next
		int a = 0; // top
		int b = 0; // bot
		int c = 0; // left
		int d = 0; // right

		for (int i = 0; i < length; i++) {

			if (ALP.get(i).getTop() == null) {
				answ[0][a] = ALP.get(i);
				ALP.set(i, null);
				a++;
			} else if (ALP.get(i).getBot() == null) {
				answ[game.getHeight() - 1][b] = ALP.get(i);
				ALP.set(i, null);
				b++;
			} else if (ALP.get(i).getLeft() == null) {
				answ[c][0] = ALP.get(i);
				ALP.set(i, null);
				c++;
			} else if (ALP.get(i).getRight() == null) {
				answ[d][game.getWidth() - 1] = ALP.get(i);
				ALP.set(i, null);
				d++;
			}

			// now all boundary case should be removed
		}
		
		for (int i = 0; i < (game.getHeight() * 2 + game.getWidth() * 2 - 4); i++) {
			/*
			 * all pieces in sol should be related
			 */
			if (ALP.get(i) != null) {

				if (i != length - 1 && fitsWith(ALP.get(i), ALP.get(i + 1))) {
					ArrayList<Piece> temp = new ArrayList<Piece>();
					temp.add(ALP.get(i));
					temp.add(ALP.get(i + 1));
					ALP.set(i, null);
					sol.add(temp);
				} else {
					ArrayList<Piece> temp = new ArrayList<Piece>();
					temp.add(ALP.get(i));
					ALP.set(i, null);
					sol.add(temp);
				}

			}
		}

		// now ALP is empty, we get all related in pairs in sol

	}

	public static void main(String[] args) {
		PlayGame test = new PlayGame();
		test.printMatrix(test.game.getBoard());
		System.out.println();
		test.Shuffle2();
		test.print(test.ALP);
		test.play();
	}
}
