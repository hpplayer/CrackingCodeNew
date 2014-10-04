
public class P_1_4 {
	public String solution(String str, int sz){
		if(str.length()<1 || str ==null){
			return "error";
		}
		//char[] ary = new char[sz];
		char[] ary = str.toCharArray();
		char[] result = new char[str.length()];
		System.out.println(new String(ary));
		//System.out.println(str.length());
		int i = 0;
		
		while(ary[i] == ' '){
			i++;
		}
		//System.out.println(i);
		for(int j = 0; j<str.length(); j++){
			if(ary[i] == ' '){
				 result[j]= '%';
				 result[j+1]= '2';
				 result[j+2]= '0';
				 j=j+2;
			}
			else{
				result[j] = ary[i];
			}
			i++;

		}
		
		return (new String(result));
		
	}
	
	public static void main(String[] args){
		String b = "t e s t      ";
		String a= "Mr John Smith    ";
		System.out.println(new P_1_4().solution(b, 7));		
	}
}
