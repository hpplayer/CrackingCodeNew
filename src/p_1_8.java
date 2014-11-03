
public class p_1_8 {
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}
	
	
	public static boolean isSubstring(String small, String big){
		return big.indexOf(small) >= 0;
	}
	
	public static boolean isRotation(String a, String b){
		int lengthOfa = a.length();//we should only have one unique length() for a and b
		
		if(lengthOfa == b.length() && lengthOfa > 0){
			String d = a+a;
			return isSubstring(b, d);
		}else{
			return false;
		}
		
		
	}
}


