package Chapter9;

import java.util.ArrayList;

public class p_9_5_sol3 {
	public static ArrayList<String> test(String str){
		if(str == null) return null;
		ArrayList<String> subStrs = new ArrayList<String>();
		if(str.isEmpty()){
			subStrs.add("");
			return subStrs;
		}
		char first = str.charAt(0);
		String subString = str.substring(1);
		ArrayList<String> strs = test(subString);//old array contain 1 char less string collections
		for(String s: strs){
			for(int i = 0; i <= s.length(); i++){
				subStrs.add(combineString(i, s, first));//new array contain 1 char more string collections
			}
		}
		return subStrs;
	}
	
	public static String combineString(int index, String str, char c){
		String firstHalf = str.substring(0,index);
		String secondHalf = str.substring(index);
		return (firstHalf + c + secondHalf);
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = test("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
