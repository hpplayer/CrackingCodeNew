package Chapter5;

import CtCILibrary.AssortedMethods;

public class p_5_1_sol2 {
	static int updateBits(int n, int m, int i, int j){
		//goal: 11100011
		int allones = ~0;
		int left = allones <<(j+1);//11100000
		int right = ((1<<i) -1); //00000011
		
		int mask = left | right;
		
		return ((mask & n) | m <<i);
	}
	
	public static void main(String[] args) {
		int a = 103217;
		System.out.println("a: " + AssortedMethods.toFullBinaryString(a));
		int b = 13;
		//System.out.println(AssortedMethods.toFullBinaryString(b));		
		
		
		int d = updateBits(a, b, 4, 12);
		System.out.println("d: " + AssortedMethods.toFullBinaryString(d));


	}
}
