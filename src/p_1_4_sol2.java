
public class p_1_4_sol2 {
	public String solution(String str, int sz){
		String result ="";
		for(int i = 0; i < sz; i++){
			if (str.charAt(i) == ' '){
				result = result + "%20";
			}
			else {
				result = result + str.charAt(i); 
			}
			
		}
		return result;
		
		
	}
	
	public static void main(String[] args){
		String a= "Mr John Smith    ";
		System.out.println(new p_1_4_sol2().solution(a, 13));		
	}
}
