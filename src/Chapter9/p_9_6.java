package Chapter9;

import java.util.ArrayList;

public class p_9_6 {
	public static ArrayList<String> test(int n) {
		ArrayList<String> subsets = new ArrayList<String>();
		if (n == 0) {
			subsets.add("");
			return subsets;
		}
		if( n == 1){
			subsets.add("()");
			return subsets;
		}
		ArrayList<String> temp = test(n - 1);
		for (String s : temp) {
			if (s.split("\\(\\)").length == 0) {
				subsets.add(s + "()");
				subsets.add("("  + s + ")");
			} else {
				subsets.add(s + "()");
				subsets.add("()" + s);
				//System.out.println("insertmid: " + insertMid(s));
				subsets.add(insertMid(s));
			}
		}
		return subsets;
	}

	public static String insertMid(String str) {
	
		int mid = (str.length()) / 2;
	//	System.out.println("str: " + str + "length: " + str.length() + " index: " + mid);
		String subString = str.substring(0, mid);
		//System.out.println("s1: " + subString);
		String subString2 = str.substring(mid);
		//System.out.println("s2: " + subString2);
		return (subString + "()" + subString2);
	}

	public static void main(String[] args) {
		ArrayList<String> list = test(4);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
	}

}
