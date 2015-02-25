package Chapter17;

public class p_17_01_sol2 {
	public static void swap(int a, int b){
			a = a^b;
			b = a ^ b;//get a
			a = a ^ b;//get b
			
			System.out.println("a: " + a + " b: " + b);
	}
	
	public static void main(String[] args) {
		int a = 1672;
		int b = 9332;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		swap(a, b);
	}
}
