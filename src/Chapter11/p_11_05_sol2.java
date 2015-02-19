package Chapter11;

public class p_11_05_sol2 {
	public static int searchI(String[] strings, String str, int first, int last){
		while(first<=last){
			int mid = (last + first)/2;
			if(strings[mid].isEmpty()){//if mid is empty, find the closet non-empty string
				int left = mid-1;
				int right = mid+1;
				while(true){
					if(left < first && right > last){//out of bounday
						return -1;
					}else if ( right <= last && !strings[right].isEmpty()){//search right first, one by one
						mid = right;
						break;
					}else if(right >= first && !strings[left].isEmpty()){
						mid = left;
						break;
					}
					left --;
					right ++;
				}
			}
			
			int res = strings[mid].compareTo(str);
			if(res == 0){
				return mid;
			}else if (res < 0){ // search right
				first = mid+1;
			}else{
				last = mid -1;
			}	
		}
		return -1;
	}
	public static int searchR(String[] strings, String str, int first, int last){
		if(first > last) return -1;
		
		int mid = (last+first)/2;
		if(strings[mid].isEmpty()){//if mid is empty, find the closet non-empty string
			int left = mid-1;
			int right = mid+1;
			while(true){
				if(left < first && right > last){//out of bounday
					return -1;
				}else if ( right <= last && !strings[right].isEmpty()){//search right first, one by one
					mid = right;
					break;
				}else if(right >= first && !strings[left].isEmpty()){
					mid = left;
					break;
				}
				left --;
				right ++;
			}
		}
			//now we have updated non-empty string
			if(str.equals(strings[mid])){
				return mid;
			}else if (strings[mid].compareTo(str)<0){//mid < str, search right 
				return searchR(strings, str, mid+1, last);
			}else{
				return searchR(strings, str,first, mid -1);
			}
	}
	
	public static int search(String[] strings, String str){
		if(strings == null || str== null || str.isEmpty()){
			return -1;//if search "" return -1
		}
		return searchR(strings, str, 0, strings.length -1);		
	}
	
	public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "ac"));
        
		for (String s : stringList) {
			String cloned = new String(s);
        	System.out.println("<" + cloned + "> " + " appears at location " + search(stringList, cloned));
		}
		
		System.out.println("********************************************************************************");
		for (String s : stringList) {
			String cloned = new String(s);
        	System.out.println("<" + cloned + "> " + " appears at location " + searchI(stringList, cloned, 0, stringList.length -1));
		}
	}
}
