package Chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class p_11_02_sol2 {
	public static void main(String[] args){
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		test(array);
		System.out.println(Arrays.toString(array));
		
	}
	
	public static void test(String[] str){
		HashMap<String, ArrayList<String>> hs = new HashMap<String, ArrayList<String>>();
		for(String s: str){
			String temp = StrConv(s);
			if(!hs.containsKey(temp)){
				hs.put(temp, new ArrayList<String>());
			}
			hs.get(temp).add(s);
		}

		int index = 0;
		for(String key : hs.keySet()){
				for(String s: hs.get(key)){
					str[index] = s; 
					index++;
				}
		}

		/*
		for(String s : str){
				Arrays.sort(s, new Comparator<String>(){
					public int compare(String a, String b){
						return strConv(a).compareTo(strConv(b));
				})
		}
		*/

	}

	public static String StrConv(String s){
		char[] temp= s.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}
}
