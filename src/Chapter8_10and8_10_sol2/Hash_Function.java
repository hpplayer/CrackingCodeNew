package Chapter8_10and8_10_sol2;

public class Hash_Function {
	public int hashFunction(String str){
		char[] ary = str.toCharArray();
		int sum = 0;
		for(char c: ary){
			sum += (int) c;
		}
		return sum;
	}
	
	/*
	public static void main(String[] args){
		char[] ary = "abc".toCharArray();
		System.out.println((int)ary[0]);
	}
	*/
}
