package Chapter9;

public class p_9_11 {
	static int count = 0;
	public static int test(String str, boolean result){
		for(int i = 0; i < str.length()-1; i+=2){
			if(str.charAt(i) < (int) '0' || str.charAt(i) > (int) '1'){
				//System.out.println(str.charAt(i));
				str = str.substring(i+1);
				continue;
			}
			//String temp = insert1(i, str);
			String temp = insert1(i, str);
			System.out.println(temp);
			if(Boolean.valueOf(temp) == result){
				count ++;
				//System.out.println(temp);
				test(temp.substring(2, temp.length()-1), result);
			}
		}
		return count;
	}
	
	public static String insert1(int index, String str){
		char c = str.charAt(index);
		String sub1 = str.substring(0, index);
		String sub2 = str.substring(index+1, str.length());
		return (sub1 + "(" + String.valueOf(c) + ")" + sub2);
	}
	
	public static void main(String[] args){
		System.out.println(test("1^0|0|1", false));
	}
}
