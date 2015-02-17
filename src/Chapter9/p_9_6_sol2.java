package Chapter9;

import java.util.ArrayList;

public class p_9_6_sol2 {
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
		if(leftRem < 0|| rightRem < leftRem) return;
		
		if(leftRem == 0 && rightRem ==0){
			String s = String.copyValueOf(str);
			//String s = str.toString();
			list.add(s);
		}else{
			if(leftRem > 0){
				//count is like the index
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count +1);
			}
			if(rightRem > leftRem){
				str[count] = ')';
				addParen(list, leftRem, rightRem - 1, str, count +1);
			}
		}
	}
	
	public static ArrayList<String> generateParens(int count){
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}
	
	public static void main(String[] args){
		ArrayList<String> list = generateParens(4);
		for(String s: list){
			System.out.println(s);
		}
		System.out.println(list.size());
	}
}