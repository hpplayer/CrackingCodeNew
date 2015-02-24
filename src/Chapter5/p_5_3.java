package Chapter5;

public class p_5_3 {
	/*
	 * count the num of 1 in the input
	 */
	static int CountOne(int num){
		int count = 0;
		String binary = Integer.toBinaryString(num);
		for(int i = 0; i < binary.length(); i++){
			if(binary.charAt(i) == '1'){
				count ++;
			}
		}
		return count;
		
	}
	
	static int findmax(int num){
		int count = CountOne(num);
		String binary = Integer.toBinaryString(num);
		int firstOne = binary.length()-1;
		while(binary.charAt(firstOne) != '1'){
			firstOne --;
		}
		
		StringBuilder sb = new StringBuilder(); 
		sb.append("0B");
		for (int i = 0; i < count; i++){
			sb.append('1');
		}
		int temp  = Integer.valueOf(sb.toString());
		int max = temp << (firstOne - (count - 1));
		return max;		
	}
	
	public static void main(String[] args){
		System.out.println(CountOne(11));
		System.out.println(findmax(11));
	}
}
