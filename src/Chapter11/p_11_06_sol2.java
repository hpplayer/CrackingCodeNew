package Chapter11;

import CtCILibrary.AssortedMethods;

public class p_11_06_sol2 {
	//iteratively search from top right
	//actually, we are not doing binary search, each time we filter a col/row until we found the element
	public static boolean findElement(int[][]matrix, int elm){
		int row = 0; 
		int col = matrix[0].length -1;
		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == elm){
				return true;
			}else if(matrix[row][col] > elm){//smaller then smallest col, need move left
				col--; 
			}else{//matrix[row][col] < elm)
				row ++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int M = 10;
		int N = 5;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}
		
		AssortedMethods.printMatrix(matrix);
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int v = 10 * i + j;
				System.out.println(v + ": " + findElement(matrix, v));
			}
		}
		
	}
}
