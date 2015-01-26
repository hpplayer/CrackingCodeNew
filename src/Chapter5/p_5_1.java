package Chapter5;
import CtCILibrary.*;


public class p_5_1 {
	/*
	 * insertion() is my solution,
	 * updateBits() is official solution
	 * both give same results.
	 * it firstly clear all bits from j to i (inclusive)
	 * then insert M into N from ith position
	 * 
	 */
	static int insertion(int N, int M, int i, int j){
		//goal:11100011
		if(j> 32 || i < 0) return 0;
		int mask1 = (1 << (j + 1)) -1 ;//inclusive, so we need clear j also, 00011111

		int mask2 = -1 << i; //use -1 so that all starting bit is 1, 111111100
		int mask = ~(mask1 & mask2); // used to set M related bits in N to 0, initialization, ~00011100 -> 11100011
		
		System.out.println(AssortedMethods.toFullBinaryString(mask & N));
		
		return ((mask & N) | (M << i));	
	}
	
	public static int updateBits(int n, int m, int i, int j) {
		// Validation
		if (i >= 32 || j < i) {
			return 0;
		}
		
		/* Create a mask to clear bits i through j in n
		/* EXAMPLE: i = 2, j = 4. Result should be 11100011.
		 * (Using 8 bits for this example.  This is obviously not actually 8 bits.)
		 */
		int allOnes = ~0; // allOnes = 11111111
		
		int left = allOnes << (j + 1); // 1s through position j, then 0s. left = 11100000	
	  	int right = ((1 << i) - 1); // 1¡¯s after position i.  right = 00000011
		int mask = left | right; // All 1s, except for 0s between i and j. mask = 11100011

		/* Clear i through j, then put m in there */
		int n_cleared = n & mask; // Clear bits j through i.
		int m_shifted = m << i; // Move m into correct position.
		
		/* OR them, and we're done! */
		return n_cleared | m_shifted; 
	}
	
	
	public static void main(String[] args) {
		int a = 103217;
		System.out.println("a: " + AssortedMethods.toFullBinaryString(a));
		int b = 13;
		//System.out.println(AssortedMethods.toFullBinaryString(b));		
		
		
		int d = updateBits(a, b, 4, 12);
		System.out.println("d: " + AssortedMethods.toFullBinaryString(d));
		
		int c = insertion(a, b, 4, 12);
		//System.out.println(AssortedMethods.toFullBinaryString(-1));
		//System.out.println(AssortedMethods.toFullBinaryString(1024));
		//System.out.println(AssortedMethods.toFullBinaryString(19));	
		System.out.println("c: " + AssortedMethods.toFullBinaryString(c));

	}
}
