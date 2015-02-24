package Chapter9;

public class p_9_8 {
	public static int test(int amount, int[] tokens, int index){
		if(index >= tokens.length -1) return 1; // time to count!
		int token = tokens[index];
		int total = 0;
		for(int i = 0; i*token <= amount; i++){
			int remain = amount - i*token;
			total +=test(remain, tokens, index+1);
		}
		return total;
	}
	
	public static int makeChange(int n){
		int[] tokens = {25,10,5,1};
		return test(n, tokens, 0);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			System.out.println("makeChange(" + i + ") = " + makeChange(i));
		}
	}
}
