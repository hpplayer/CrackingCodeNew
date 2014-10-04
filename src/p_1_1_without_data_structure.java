
public class p_1_1_without_data_structure {
	public boolean solution(String str){
		if (str.length()>128) return false;
		
		boolean[] asc_set = new boolean[128];
		
		for (int i = 0; i < str.length(); i++){
			int val =str.charAt(i);
			if(asc_set[val]){
				return false;
			}
			asc_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args){
		String a = "a+a";
		p_1_1_without_data_structure test = new p_1_1_without_data_structure();
		System.out.println(test.solution(a));
		
	}
}
