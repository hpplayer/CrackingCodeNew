package Chapter1;
import java.util.HashMap;


public class p_1_3 {
	/*
	public static void main(String[] args){
		String a = "dog";
		String b = "god";
		
		System.out.println(new p_1_3().solution(a, b));
		
		
	}
	*/
	
	public static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[128];
		 
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++;  
		}
		  
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
		    if (--letters[c] < 0) {
		    	return false;
		    }
		}
		  
		return true;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			boolean anagram2 = solution(word1, word2);
			//System.out.println(word1 + ", " + word2 + ": " + anagram+" ");

			System.out.println(word1 + ", " + word2 + ": " + anagram2+" ");
		}
	}
	
	public static boolean solution(String a, String b){
		if (a==null || b ==null||a.length()<1||b.length()<1||a.length()!=b.length()) return false;
		a.trim();
		b.trim();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		//String min = Min(a,b);
		//String max = Max(a,b);

		int lh = a.length();
			for (int i = 0; i < lh; i++){
				map.put(a.charAt(i), a.charAt(i));
			}
			
			for(int j = 0; j < lh; j++){
				if(map.get(b.charAt(j)) == null){
					return false;
				}
				
			}
			
			for (int i = 0; i < lh; i++){
				map2.put(b.charAt(i), b.charAt(i));
			}
			
			for(int j = 0; j < lh; j++){
				if(map2.get(a.charAt(j)) == null){
					return false;
				}
				
			}
			return true;
			
			

		
	}
	
	/*
	public String Min(String a, String b){
		if (a.length() <= b.length()){
			return a;
		}
		return b;
	}
	
	public String Max(String a, String b){
		if (a.length() <= b.length()){
			return b;
		}
		return a;
	}
	*/
}
