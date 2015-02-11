package Chapter9;

import java.util.ArrayList;

public class p_9_5_sol2 {
	public static ArrayList<String> getPerms(String str){
		if(str == null){
			return null;
		}
		ArrayList<String> perm = new ArrayList<String>();
		if(str.length() == 0){
			perm.add("");
			return perm;
		}
		
		char first = str.charAt(0);//the one that we will insert around
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder); //each iteration, the words in the words get one char longer
		for(String word: words){
			for(int j = 0; j <= word.length(); j++){
				String s = insertCharAt(word, first, j);//s has the exactly same chars as the input
				perm.add(s);
			}
		}
		return perm;
	}
	
	public static String insertCharAt(String word, char c, int i){
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abcde");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
