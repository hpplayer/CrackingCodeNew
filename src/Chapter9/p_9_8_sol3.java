package Chapter9;

public class p_9_8_sol3 {
	public static int test(int amount, int index, int[] tokens){
		if(index >= tokens.length-1) return 1;
		int total = 0;
		int token = tokens[index];
		for(int i =0; i*token <= amount; i++){
			int remain = amount - i*token;
			 total += test(remain, index+1, tokens); 
		}
		return total;
	}

	
	public static int test(int i){
		int[] tokens = {25,10,5,1};//must follow this order, since we have to start with 25 then replace 25 with smaller values
		return test(i, 0, tokens);
	}
	
	
	public static int test2(int[][] cache, int index, int amount, int[] tokens){
		if(cache[amount][index] > 0) return cache[amount][index];

		if(index >= tokens.length-1) return 1;
		int token = tokens[index];
		int total = 0; 
		for(int i = 0; i *token <=amount; i++){
			int remain = amount - i*token;
			total += test2(cache, index+1, remain, tokens);
		}

		cache[amount][index] = total;

		return total;

	}

	public static int test2(int n){
		int[] tokens = {25, 10,5,1};
		int[][] cache = new int[n+1][tokens.length];
		return test2(cache, 0, n, tokens);

	}
	
	public static int makeChange(int n){
		int x = test(n);
		int y = test2(n);
		if(x != y){
			System.out.println("Error: " + x + " " + y);
		}
		return x;
	}
	
	
		public static void main(String[] args) {
			for (int i = 0; i <= 100; i++) {
			System.out.println("makeChange(" + i + ") = " + makeChange(i));
			}
		}
		
		
}
