package Chapter11;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String>{
	public String sortChars(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	public int compare(String arg0, String arg1) {
			return sortChars(arg0).compareTo(sortChars(arg1));
	}
	
}
