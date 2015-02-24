package Chapter1;

public class p_1_5_sol3 {
	public static void main(String[] args){

		String a = "Aabccccaaa";
		System.out.println(solution(a));
		
	}
	public static String solution(String str){
		if(str.isEmpty() || str == null) return "error";
		char last = str.charAt(0);
		int count = 1;
		StringBuffer result = new StringBuffer();
		
		for (int i = 1; i<str.length(); i++){//start with i = 1 not i = 0, since we have updated value at charAt(0)
			if(str.charAt(i) == last){
				count++;
			}else{
		
				result.append(last);
				result.append(count);
				last = str.charAt(i);
				count = 1;
				
			}

		}
		//the code updates result only when char changes, so we need consider the last char which we don't have changes after them.
		result.append(last);
		result.append(count);
		if(result.toString().length()>str.length()){
			return str;
		}else{
		
		return result.toString();
		}
	}
}
