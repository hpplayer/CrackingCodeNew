package Chapter11;

import CtCILibrary.AssortedMethods;

public class p_11_01_sol2 {
	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
		int indexA = lastA - 1; /* Index of last element in array b */
		int indexB = lastB - 1; /* Index of last element in array a */
		//System.out.println(indexMerged);
		/* Merge a and b, starting from the last element in each */
		while (indexB >= 0) {
			if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
				a[indexMerged] = a[indexA]; // copy element
				indexA--; 
			} else {
				a[indexMerged] = b[indexB]; // copy element
				indexB--;
			}
			indexMerged--; // move indices			
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0,0,0,0,0};
		int[] b = {1, 4, 5, 6, 7, 7};
		merge(a, b, 8, 6);
		System.out.println(AssortedMethods.arrayToString(a));
	}
}
