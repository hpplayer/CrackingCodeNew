package Chapter1;
import CtCILibrary.AssortedMethods;


public class p_1_7_sol2 {
	
	
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
	
	
	
	public static void solution(int[][] matrix){
		boolean col = false;
		boolean row = false;
		
		for (int i = 0; i < matrix[0].length; i++){
			if (matrix[0][i] == 0) {
				col = true;
				break;//remember use break to save time
			}
			
		}
		
		
		for (int j = 0; j < matrix.length; j++){
			if(matrix[j][0] == 0){
				row = true;
				break;
			}
		}
		
		
		//why use 1 instead of 0? because in later check first row part, we will know if the first row itself contains zero and will set 
		//related column. so is the column. Thats why we set i = 1 and j=1 not i = 0; j = 0;
		
		
		for (int i = 1; i < matrix.length; i++){ 
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for (int i = 1; i < matrix.length; i++){
			if(matrix[i][0] == 0){
				nullifyrow(matrix, i);
			}
		
		}
		
		for (int j = 0; j < matrix[0].length; j++){
			if(matrix[0][j] == 0){
				nullifycol(matrix, j);
			}
		
		}
		
		if(col){
			nullifyrow(matrix, 0);
		}
		
		if(row){
			nullifycol(matrix, 0);
		}
	}
}
