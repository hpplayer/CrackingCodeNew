
public class p_1_5 {
	public static void main(String[] args){
		
		//int var = 0;
		//int var2 = ++var;
		//int var3 = var++;
		//System.out.println(var2+""+var3);
		
		//String a = "aabcccccaaa";
		String a = "abbccccccde";
		System.out.println(solution(a));
		
	}
	
	
	public static String solution(String str){
		if(str.length()<1 || str == null){
			return "error";
		}
		StringBuffer mybuf = new StringBuffer();
		String result = "";
		str.trim();
		for(int i = 0; i < str.length(); ++i){
			int count = 1;
			int pointer = i;
			//System.out.println(pointer);
			//int temp = i;
			while(pointer < str.length()-1 && str.charAt(pointer) == str.charAt(pointer+1)){
			//	System.out.println(i);
				count++;	
			
				pointer ++;
				//System.out.println(pointer);
			}
			//System.out.println(count);
			i = i + count-1;
			//System.out.println(i);
			//i = temp;
			//result = result+str.charAt(pointer)+ count;
			mybuf.append(str.charAt(pointer));
			mybuf.append(count);
			result = mybuf.toString();
			
		}
		
		
		if (result.length()>str.length()){
			result = str;
		}
		
		return result;
		
	}
	
	
	
	
}
