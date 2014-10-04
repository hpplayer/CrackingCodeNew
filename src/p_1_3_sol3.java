
public class p_1_3_sol3 {
	public static void main(String[] args){
		String a = "22odg3";
		String b = "go232d";
		
		System.out.println(new p_1_3_sol3().solution(a, b));
		
		
	}
	public boolean solution(String a, String b){
		a=a.trim();
		b=b.trim();
		if (a.length() != b.length()){
			return false;
		}
		
		int[] letters = new int[128];
		char[] char_array = a.toCharArray();
		
		for(char c:char_array){
			letters[c]++;
		}
		
		for(int i = 0; i <a.length(); i++){
			if(--letters[b.charAt(i)] <0 ){
				return false;
			}
			
		}
		return true;
	}
}
