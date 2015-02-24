package Chapter11;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class p_11_01_sol3 {
	public static void test2(int[] A, int[]B){
		if(B.length >= A .length) return;
		int LastA = FindLastIndex(A)-1;
		//System.out.println(LastA);
		int LastB = B.length-1;
		int index = LastA + LastB+1;
		//System.out.println(index);
		while(LastB >= 0){
			if(LastA >= 0 && A[LastA] >= B[LastB]){
				A[index] = A[LastA];
				LastA --;
			}else{
				A[index] = B[LastB];
				LastB --;
			}
				index --;	
		}

	}

	public static int FindLastIndex(int[] a){
		int index = 0;
		for(int c: a){
			//System.out.println(index);
			if (c <= a[0] && index != 0 ){
				//System.out.println("awsa");
				return index;
			}
			index++;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0,0,0,0,0};
		int[] b = {1, 4, 5, 6, 7, 7};
		test2(a, b);
		System.out.println(Arrays.toString(a));
	}
}
