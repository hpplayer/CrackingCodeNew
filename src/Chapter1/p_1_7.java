package Chapter1;
import java.util.Arrays;

import CtCILibrary.AssortedMethods;


public class p_1_7 {
	
	public static void main(String[] args) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, 0, 100);		
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
	
	
	public static void solution(int[][] matrix){
		int m = matrix.length;//return total row#
		int n = matrix[0].length;//return total col#
		
		boolean [][] flagTable = new boolean[m][n];
	//	Arrays.fill(flagTable, false);//set default value
		
		for(int i = 0; i < m; i ++){
			for (int j = 0; j < n; j++){
				if (matrix[i][j] == 0){
					flagTable[i][j] = true;		
				}
			}
		}
		
		for(int i= 0; i < m; i++){
			for (int j = 0; j < n; j++){
				if (flagTable[i][j] == true){
					for(int z = 0; z< n; z++){
						matrix[i][z] = 0; 
					}
					for(int y = 0; y<m; y++){
						matrix[y][j] = 0;
					}
				}
			}
		}
		
		
		
	}
}
