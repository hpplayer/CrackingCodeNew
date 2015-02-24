package Chapter1;
import CtCILibrary.*;
public class p_1_6 {
	public void solution(int[][] matrix, int n){
		int[][] temp = new int[n][n];//use to store temp role
		//top to right
		//i row, j column
		for(int i = 0; i <n; i++){
			for(int j = 0; j<n; j++){
				//System.out.println(j);
				temp[j][n-1-i]=matrix[i][j];
		}
			
	}
		
		/*
		 *why return matrix = temp doesn't give right value???
		 */

		for(int i = 0; i<n; i++){
			for (int j = 0; j<n; j++){
				matrix[i][j]=temp[i][j];
			}
		}

		//System.out.println(matrix[1][0]);
	}
	
	
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(10, 10, 0, 9);
		//int[][]matrix2 = matrix;

		
		AssortedMethods.printMatrix(matrix);
		new p_1_6().solution(matrix, 10);
		//rotate(matrix, 10);
		//solution(matrix, 2);
		System.out.println();
		//AssortedMethods.printMatrix(matrix);
		AssortedMethods.printMatrix(matrix);
	}
}
