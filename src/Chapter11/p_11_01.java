package Chapter11;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class p_11_01 {
	public static void test3(int[] A, int[] B){
		int lastA = findeIndex(A);
		int lastB = B.length;
		//System.out.println(lastA);
		//System.out.println(lastB);
		int indexMerged = lastB + lastA -1;
		int indexA = lastA - 1;
		int indexB = lastB -1;
		
		while(indexB >=0){
			if(indexA >= 0 && A[indexA] > B[indexB]){
				A[indexMerged] = A[indexA];
				indexA--;
			}else{
				A[indexMerged] = B[indexB];
				indexB--;
			}
			indexMerged--;
		}
	}
	public static void test2(int A[], int B[]) {
		int lastA = findeIndex(A)-1;
		//System.out.println(lastA);
		int lastB = B.length-1;
		//System.out.println(lastB);
		int index = lastA + lastB + 1;
		final int temp = index+1;
		//lastA = findeIndex(A);
		//System.out.println(temp);
		for (int i = 0; i < temp; i++) {
		//	System.out.println(i);
			//System.out.println(lastB);
		//System.out.println(lastA);
		//System.out.println(B[lastB] );
		//System.out.println(A[lastA] );
	//	System.out.println(lastB );
			if (lastA < 0 || (lastB >= 0  &&B[lastB] > A[lastA])) {//dont remember the case: lastA < 0, since we are sorting in reverse order, A[] maybe firstly used up
				//if(A[lastA] == 1) System.out.println("lala");
				A[index] = B[lastB];
				index--;
				lastB--;
			} else {
				//if(A[lastA] == 1) System.out.println("lala");
				A[index] = A[lastA];
				index--;
				lastA--;
			}
		}
	}

	public static void test(int[] A, int[] B) {
		if (B.length > A.length)
			return;
		int[] aryHelper = A.clone();

		int cursorA = 0, cursorB = 0;
		int lastA = findeIndex(A);
		// System.out.println(lastA);
		for (int i = 0; i < lastA + B.length; i++) {
			/*
			 * if(aryHelper[i] == 0 && B[i] == 0 && i > lastA){ break; }
			 */
			// System.out.println("A: " + cursorA);
			// System.out.println("B: " + cursorB);
			// System.out.println("i: " + i);
			if (cursorB < B.length && aryHelper[cursorA] >= B[cursorB]) {

				A[i] = B[cursorB];
				// System.out.println(A[i]);
				cursorB++;
			} else {

				A[i] = aryHelper[cursorA];
				cursorA++;
			}
		}
	}

	public static int findeIndex(int[] A) {
		int index = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[index]) {
				index = i;
				return index;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// int[] a = {1,2,4,10,0,0,0,0};
		// int b[] = {3,5};

		int[] a = { 2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0,0,0};
		int[] b = { 1, 4, 5, 6, 7, 7 };
		test2(a, b);
		
		
		// System.out.println(AssortedMethods.arrayToString(a));

		// test(a, b);
		System.out.println(Arrays.toString(a));
		
		int[] a2 = { 2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0,0,0};
		test(a2, b);
		System.out.println(Arrays.toString(a2));
	}
}
