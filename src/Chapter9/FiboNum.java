package Chapter9;

public class FiboNum {
	
	int Rway(int n){
		if(n == 0 ) return 0;
		if(n == 1) return 1;
		//System.out.println(Rway(n-1) + Rway(n-2));
		return Rway(n-1) + Rway(n-2);
	}
	
	int[]  ary = new int[31];
	int DPway(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(ary[n] != 0) return ary[n];
		ary[n] = DPway(n-1) + DPway(n-2);
		return ary[n];
	}
	
	
	int DPway(int n, int[] ary){
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(ary[n] != 0) return ary[n];
		ary[n] = DPway(n-1) + DPway(n-2);
		return ary[n];
	}
	
	public static void main(String[] args){
		FiboNum test = new FiboNum();
		long time1 = System.currentTimeMillis();
		System.out.println(test.Rway(30));
		System.out.println(System.currentTimeMillis() - time1);
		
		long time2 = System.currentTimeMillis();
		System.out.println(test.DPway(30));
		System.out.println(System.currentTimeMillis() - time2);
		
		test.ary = new int[101];
		long time3 = System.currentTimeMillis();
		System.out.println(test.DPway(30, test.ary));
		System.out.println(System.currentTimeMillis() - time3);
	}
}
