package Chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class p_9_5 {
	public static ArrayList<String> allstrs;

	public static ArrayList<String> test(String str){
		//step 0. boundary case 
		if(str.isEmpty()){
			allstrs.add("");
			return allstrs;
		}
		// step 1. create hashmap from input str
		Set<Character> set = new HashSet<Character>();
		for(char c : str.toCharArray()){
			//System.out.println(set.size());
			//System.out.println("string: " + str + " char: " + c);
			if(c!= '\0'){
				set.add(c);
			}
		}
		//step 2. iterate hashset
		Iterator<Character> itr = set.iterator();
		while(itr.hasNext()){
			StringBuffer sb = new StringBuffer();
			str.replace(itr.next(), '\0');
			sb.append(test(str));
		}
		//step 3. add string together
		allstrs.add(str);
		return allstrs;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = test("abcde");
		
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
