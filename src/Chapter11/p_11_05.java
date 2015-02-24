package Chapter11;

public class p_11_05 {
	/*
	 * my method, when face "" need to binary search both the right and left
	 */
	public static int test(int left, int right, String[] ary, String target){
		if ( left > right ) return -1;
		int mid = left + (right-left)/2;
		if(ary[mid].equals(target)) return mid;
		if(ary[mid].isEmpty()){
			int result = test(left, mid - 1, ary, target);
			if(result == -1)
				result = test(mid+1, right, ary, target);
			return result;
		}else if(target.compareTo(ary[mid]) < 0){
			return  test(left, mid -1, ary, target);
		}else if(target.compareTo(ary[mid]) > 0){
			return test(mid+1, right, ary, target);
		}
		return -1;
	}
	
	public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(test(0, stringList.length -1, stringList, "banana"));
        
		for (String s : stringList) {
			String cloned = new String(s);
        	System.out.println("<" + cloned + "> " + " appears at location " + test(0, stringList.length -1, stringList, cloned));
		}
	}
}
