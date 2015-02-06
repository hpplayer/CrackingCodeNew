package Chapter9;

/*y(0) = 0
 * y(1) = 1
 * y(2) = 2
 * y(3) = 3 +1 =4
 * y(4) = 5 +2 = 7 =y(1) + y(2) + y(3)
 * y(5) = 8 +5 = 13 =y(2) + y(3) + y(4)
 * y(6) = 13 + 11 = 24 = y(3) + y(4) + y(5)
 */
public class p_9_1 {
	int test(int n){
		if( n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		return test(n-1) + test(n-2) + test(n-3);
	}
	
	int[] ary = new int[100];
	int test2(int n){
		if( n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		if(ary[n] != 0) return ary[n];
		ary[n] = test(n-1) + test(n-2) + test(n-3);
		return ary[n];
	}
}
