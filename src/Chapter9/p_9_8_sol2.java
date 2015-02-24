package Chapter9;

public class p_9_8_sol2 {
	static int makeChange(int n){
		int[] tokens = {25,10,5,1};
		int[][]map = new int[n+1][tokens.length];
		return test(n, tokens, 0, map);
	}
	
	static int test(int amount, int[] tokens, int index, int[][] map){
		if(map[amount][index] > 0){//previous calculated values
			return map[amount][index];
		}
		if(index >= tokens.length -1){
			return 1; //only 1 penny remaining
		}
		int token = tokens[index];
		int total = 0;
		for(int i = 0; i * token <= amount; i++){
			int Remain = amount - token * i;
			total += test(Remain, tokens, index+1, map);
		}
		map[amount][index] = total;
		return total;
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			System.out.println("makeChange(" + i + ") = " + makeChange(i));
		}
	}
}
