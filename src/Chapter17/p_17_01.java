package Chapter17;

import java.util.Arrays;

public class p_17_01 {
	public static void test(int[] ary, int a, int b){
		ary[b] = ary[b] + ary[a];
		ary[a] = ary[b] - ary[a];
		ary[b] = ary[b] - ary[a];
	}
	
	public static void test(int a, int b){
		b = a + b;
		a = b -a;
		b = b - a;
		System.out.println("a: " + a + " b: " + b);
	}
	
	public static void test2(int a, int b){
		a = a -b;
		b = a + b;
		a = b -a;
		System.out.println("a: " + a + " b: " + b);
	}
	
	public static void main(String[] acrgs){
		int a = 1;
		int b = 2;
		test2(a, b);

		int a2 = 1672;
		int b2 = 9332;
		
		test(a2, b2);
		
		int[] testAry= {3,2,1};
		test(testAry, 0, 2);
		System.out.println(Arrays.toString(testAry));
	}
}
