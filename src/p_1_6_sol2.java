import CtCILibrary.AssortedMethods;


public class p_1_6_sol2 {
	
	public void solution(int[][] matrix, int n){
	for(int layer = 0; layer < n/2; layer++){
		int first = layer;
		int last = n-1-layer;
		
		for (int i = first; i <last; i++){
			int offset = i - first;
			int top = matrix[first][i];
			
			matrix[first][i]=matrix[last-offset][first];
			matrix[last-offset][first]=matrix[last][last-offset];
			matrix[last][last-offset]=matrix[i][last];
			matrix[i][last]=top;
			                                
		}
	}
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(10, 10, 0, 9);
		//int[][]matrix2 = matrix;

		
		AssortedMethods.printMatrix(matrix);
		new p_1_6_sol2().solution(matrix, 10);
		//rotate(matrix, 10);
		//solution(matrix, 2);
		System.out.println();
		//AssortedMethods.printMatrix(matrix);
		AssortedMethods.printMatrix(matrix);
	}
}
