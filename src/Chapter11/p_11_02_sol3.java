package Chapter11;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class p_11_02_sol3 {
	public static void test(String[] str){
		Arrays.sort(str, new AnagramComparator());
	}
	
	
	public static void test2(String[] str){
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		for(String s : str){
			String key = sortChars(s);
			if(!hash.containsKey(key)){
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
		}
		
		int index = 0;
		for(String s : hash.keySet()){
			LinkedList<String> list = hash.get(s);
			for(String t : list){
				str[index] = t;
				index ++;
			}
		}
	}
	public static String sortChars(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		test(array);
		System.out.println(Arrays.toString(array));
		String[] array2 = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		test2(array2);
		System.out.println(Arrays.toString(array2));
	}
}
