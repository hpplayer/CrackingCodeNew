package Chapter11;

import CtCILibrary.AssortedMethods;

public class p_11_06 {
	public static int[][] test(int[][] temp, int target){
		int indexX = -1;
		int indexY = -1;
		for(int i = 0; i < temp.length; i++){
			int end = temp[i].length-1;
			if(temp[i][end] > target){
				 indexX = binarySearch(temp[i], target);
				 if(indexX != -1){
					 indexY = i;
					 break;
				 }
			}
		}
		//System.out.println("i enter here");
		int [][] result = {{indexY, indexX}};
	//	System.out.println(result[1][0]);
		//System.out.println(result[0][0]);
		return result;
	}

	public static int binarySearch(int[] ary, int target){
		int left = 0;
		int right = ary.length-1;
		while(left < right){
			int mid = left + (right-left)/2;
			if(ary[mid] == target){
				return mid;
			}else if (ary[mid] > target){
				right = mid-1;
			}else{//ary[mid] < target
				left = mid +1;
			}
		}
		return -1;
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
				int[][] result =  test(matrix, v);
				if(result[0][0] >= 0 && result[0][1] >=0){
				System.out.println(v + ": " +"y: " + result[0][0]+ " x:  " + result[0][1]);
				}else{
				//	System.out.println("not found");
				}
			}
		}
		
	}
}
