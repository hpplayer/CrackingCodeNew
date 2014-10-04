import java.util.HashMap;

			
public class p_1_1 {
	public boolean solution(String str){
		if (str.length() < 1 || str == null)
			return true;
		
		str.trim();
		HashMap<Character, Character> map =  new HashMap<Character, Character>();
		
		for (int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			int temp2 = str.charAt(i);
			System.out.println(temp + " "+ temp2);
			if (map.get(temp) != null){
				return false;
			}else{
				map.put(temp, temp);
			}
		
		}
		return true;
		
	}
	
	public static void main(String[] args){
		String a = "a+a";
		p_1_1 test = new p_1_1();
		System.out.println(test.solution(a));
		
	}
}
