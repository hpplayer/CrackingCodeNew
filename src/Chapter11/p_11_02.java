package Chapter11;

import java.util.Arrays;
import java.util.Comparator;

public class p_11_02 {
	public static String convertStr(String str){
		char[] temp = str.toCharArray();
		 Arrays.sort(temp);
		// System.out.println(Arrays.toString(temp));
		return Arrays.toString(temp);
	}
	
	public static void test(String[] str){
		Arrays.sort(str, new Comparator<String>(){
			public int compare(String a, String b){
				//System.out.println(convertStr(a).equals(convertStr(b)));
				return convertStr(a).compareTo(convertStr(b));//compareTo!!!!!!!
			}
		});
	}
	
	public static void main(String[] args){
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		test(array);
		System.out.println(Arrays.toString(array));
		
	}
}
