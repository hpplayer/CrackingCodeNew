import java.util.Arrays;


public class p_1_3_sol2 {
	public static void main(String[] args){
		String a = "odg";
		String b = "god";
		
		System.out.println(new p_1_3_sol2().solution(a, b));
		
		
	}
	public String sort(String a){
		char[] str = a.toCharArray();
		Arrays.sort(str);
		return new String(str);//remember str is a char[], we need to convert it to String
	}
	
	public boolean solution(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		
		return sort(s).equals(sort(t));
		
	}
}
