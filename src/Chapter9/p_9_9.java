package Chapter9;

import java.util.ArrayList;

public class p_9_9 {
	// 1: occupied
	// 0: unoccupied
	// failed...cryyyyyyyyyyyyyy
	public static int GRID_SIZE = 4;
	
	public static void setPoint(int x, int y, int[][] chess){
		for (int i = 1; i < chess.length - x; i++) {
			if (y - i > 0)
				chess[y - i][x + i] = 1;
			if (x + i < chess.length) {
				chess[y][x + i] = 1;
				if (y + i < chess.length) {
					chess[y + i][x + i] = 1;
				}
			}
		}
		/*
		for (int j = 1; j <= x; j++) {
			if (x - j > 0) {
				chess[y][x - j] = 1;
				if (y - j > 0)
					chess[y - j][x - j] = 1;
				if (y + j < chess.length)
					chess[y + j][x - j] = 1;
			}

		}
		*/
		for (int l = y - 1; l >= 0; l--) {
			chess[l][x] = 1;
		}
		for (int z = y + 1; z < chess.length; z++) {
			chess[z][x] = 1;
		}
	}


	public static void clearPoint(int x, int y, int[][] chess){

	for (int i = 1; i < chess.length - x; i++) {
		if (y - i > 0){
			chess[y - i][x + i] = 0;
		}
		if (x + i < chess.length) {
			chess[y][x + i] = 0;
			if (y + i < chess.length) {
				chess[y + i][x + i] = 0;
			}
		}
	}

	/*
	for (int j = 1; j <= x; j++) {
		if (x - j > 0) {
			chess[y][x - j] = 1;
			if (y - j > 0)
				chess[y - j][x - j] = 0;
			if (y + j < chess.length)
				chess[y + j][x - j] = 0;
		}

	}
	*/
	if( x >= 0){
		for (int l = y - 1; l >= 0; l--) {
			chess[l][x] = 0;
		}
		for (int z = y + 1; z < chess.length; z++) {
			chess[z][x] = 0;
		}
	}

}
	
	public static boolean checkCol(int x, int[][] chess){
		for(int i = 0; i < chess.length; i++){
			if(chess[i][x] == 0){
				return true;
			}
		}
		return false;
	}

	// public boolean test(int x, int y, int[][]chess, ArrayList<Point> queens){
	public static boolean test(int x, int y, int[][] chess) {
		if (x > chess[0].length - 1 || x < 0 || y < 0 || y > chess.length - 1)
			return false;
		if(x == chess.length){ //found size
			return true;
		}
		for (int i = 0; i < chess.length; i++) {
			if(!checkCol(x, chess)){
				//System.out.println(y + " " + (x-1));
				//chess[y][x-1] = 0;
				//clearPoint(x-1, y, chess);
				return false;
				//continue;
			}
			if (chess[i][x] == 0) {
				chess[i][x] = 8;
				setPoint(x, i, chess);
				if(!test(x+1, i, chess)){
					clearPoint(x, i, chess);
					continue;
					//return true;
				}
				test(x+1, i, chess);
			}
		}
		
	
		// return false;

		// queens.add(new Point(x, y));

		/*
		 * test(x+1, y+1, chess, queens); test(x+1, y-1, chess, queens);
		 * test(x-1, y+1, chess, queens); test(x-1, y-1, chess, queens); test(x,
		 * y+1, chess, queens); test(x, y-1, chess, queens); test(x+1, y, chess,
		 * queens); test(x-1, y, chess, queens);
		 */

		/*
		 * test(x + 1, y + 1, chess); test(x + 1, y - 1, chess); test(x - 1, y +
		 * 1, chess); test(x - 1, y - 1, chess); test(x, y + 1, chess); test(x,
		 * y - 1, chess); test(x + 1, y, chess); test(x - 1, y, chess);
		 */

		return true;
	}

	private static void drawLine() {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < GRID_SIZE * 2 + 1; i++)
			line.append('-');
		System.out.println(line.toString());
	}

	public static void printBorads(int[][] columns) {
		for (int i = 0; i < columns.length; i++) {
			for (int j = 0; j < columns.length; j++) {
				System.out.print(columns[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		int[][] columns = new int[GRID_SIZE][GRID_SIZE];
		test(0, 0, columns);
		printBorads(columns);

	}
}
