package Chapter1;
import CtCILibrary.AssortedMethods;


public class p_1_7_sol3 {
	
	public static void main(String[] args) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, 0, 100);	
		matrix1[0][1] = 0;
		int[][] matrix2 = cloneMatrix(matrix1);


		

		solution(matrix2);
		AssortedMethods.printMatrix(matrix1);
		System.out.println();
		AssortedMethods.printMatrix(matrix2);
		
	}
	
	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] c = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				c[i][j] = matrix[i][j];
			}
		}
		return c;
	}
	
	public static void nullifyrow(int[][]matrix, int row){
		for (int i = 0; i < matrix[0].length; i ++){
				matrix[row][i] = 0;
		}
	}
	
	public static void nullifycol(int[][]matrix, int col){
		for (int i = 0; i < matrix.length; i ++){
				matrix[i][col] = 0;
		}
	}
	public static void solution(int[][]matrix){
		boolean[] row = new boolean[matrix[0].length];
		boolean[] col = new boolean[matrix.length];
		
		for(int i = 0; i < row.length; i++){
			for (int j = 0; j<col.length; j++){
				if(matrix[j][i] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for(int i = 0; i<row.length; i++){
			if(row[i])
			nullifycol(matrix,i);
		}
		
		for(int i = 0; i<col.length; i++){
			if(col[i])
			nullifyrow(matrix,i);
		}
		
		
	}
}
