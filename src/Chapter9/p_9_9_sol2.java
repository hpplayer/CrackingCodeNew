package Chapter9;

import java.util.ArrayList;

public class p_9_9_sol2 {
	 static int GRID_SIZE = 8;
	 
	 // row based
	public static boolean CheckValid(Integer[] columns, int row1, int column1){
		for(int row2 = 0; row2 < row1; row2++){
			int column2 = columns[row2];
			if(column1 == column2){
				return false;
			}
			int columnDistance = Math.abs(column2-column1);
			int rowDistance = row1 - row2;
			if(columnDistance == rowDistance){
				return false;
			}
		}
		return true;
	}
	public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
		if(row == GRID_SIZE){//found valid placement
			results.add(columns.clone());
		}else{
			for(int col = 0; col < GRID_SIZE; col++){
				if(CheckValid(columns, row, col)){
					columns[row] = col; //place queen
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}
	
	public static void clear(Integer[] columns) {
		for (int i = 0; i < GRID_SIZE; i++) {
			columns[i] = -1;
		}
	}
	
	public static void printBoard(Integer[] columns) {
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
			System.out.print("|");
			for (int j = 0; j < GRID_SIZE; j++){
			    if (columns[i] == j) {
			    	System.out.print("Q|");
			    } else {
			    	System.out.print(" |");
			    }
			}
            System.out.print("\n");
            drawLine();
		}
		System.out.println("");
	}

    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }


	
	public static void printBoards(ArrayList<Integer[]> boards) {
		for (int i = 0; i < boards.size(); i++) {
			Integer[] board = boards.get(i);
			printBoard(board);
		}
	}
	   
	public static void main(String[] args) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[GRID_SIZE];
		clear(columns);
		placeQueens(0, columns, results);
		printBoards(results);
		System.out.println(results.size());
	}
}
