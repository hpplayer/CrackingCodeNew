package Chapter9;

import java.util.HashMap;

public class p_9_11_sol2 {

	public static int countR(String exp, boolean result, int start, int end) {
		
		if (start == end) {
			if (exp.charAt(start) == '1' && result) {
				return 1;
			}else if(exp.charAt(start) == '0' && result == false){ //
				return 1;
			}
			return 0;
		}

		int c = 0;
		if(result){ // case true
			for(int i = start +1; i <= end; i+=2){
				char op = exp.charAt(i);
				if(op == '&'){
					c += countR(exp, true, start, i -1) * countR(exp, true, i+1, end);
				}else if (op == '|'){
					c += countR(exp, true, start, i -1) * countR(exp, false, i+1, end);
					c += countR(exp, false, start, i -1) * countR(exp, true, i+1, end);
					c += countR(exp, true, start, i -1) * countR(exp, true, i+1, end);
				}else if (op == '^'){
					c += countR(exp, true, start, i -1) * countR(exp, false, i+1, end);
					c += countR(exp, false, start, i -1) * countR(exp, true, i+1, end);
				}
			}
		}else{
			for(int i = start +1; i <= end; i+=2){
				char op = exp.charAt(i);
				if(op == '&'){
					c += countR(exp, false, start, i -1) * countR(exp, true, i+1, end);
					c += countR(exp, true, start, i -1) * countR(exp, false, i+1, end);
					c += countR(exp, false, start, i -1) * countR(exp, false, i+1, end);
				}else if (op == '|'){
					c += countR(exp, false, start, i -1) * countR(exp, false, i+1, end);
				}else if (op == '^'){
					c += countR(exp, true, start, i -1) * countR(exp, true, i+1, end);
					c += countR(exp, false, start, i -1) * countR(exp, false, i+1, end);
				}
			}
		}
		//System.out.println(c);
		return c;
	}
	
	
	
	public static int countDP(String exp, boolean result , int start, int end, HashMap<String, Integer> cache){
		String Key = "" + result + start + end;
		if(cache.containsKey(Key)){
			return cache.get(Key);
		}
		if(start == end){
			if(exp.charAt(start) == '1' && result == true){
				return 1;
			}else if (exp.charAt(start) == '0' && result == false){
				return 1;
			}
			return 0;
		}
		int c = 0;
		if(result){
			for(int i = start +1; i <= end; i+=2){
				char op = exp.charAt(i);
				if(op == '&'){
					c += countDP(exp, true, start, i -1, cache) * countDP(exp, true, i+1, end, cache);
				}else if (op == '|'){
					c += countDP(exp, true, start, i -1, cache) * countDP(exp, false, i+1, end, cache);
					c += countDP(exp, false, start, i -1, cache) * countDP(exp, true, i+1, end, cache);
					c += countDP(exp, true, start, i -1, cache) * countDP(exp, true, i+1, end, cache);
				}else if (op == '^'){
					c += countDP(exp, true, start, i -1, cache) * countDP(exp, false, i+1, end, cache);
					c += countDP(exp, false, start, i -1, cache) * countDP(exp, true, i+1, end, cache);
				}
			}
		}else{
			for(int i = start +1; i <= end; i+=2){
				char op = exp.charAt(i);
				if(op == '&'){
					c += countDP(exp, true, start, i -1, cache) * countDP(exp, false, i+1, end, cache);
					c += countDP(exp, false, start, i -1, cache) * countDP(exp, true, i+1, end, cache);
					c += countDP(exp, false, start, i -1, cache) * countDP(exp, false, i+1, end, cache);
				}else if (op == '|'){
					c += countDP(exp, false, start, i -1, cache) * countDP(exp, false, i+1, end, cache);
				}else if (op == '^'){
					c += countDP(exp, true, start, i -1, cache) * countDP(exp, true, i+1, end, cache);
					c += countDP(exp, false, start, i -1, cache) * countDP(exp, false, i+1, end, cache);
				}
			}
			
		}
		cache.put(Key,  c);
	return c;
		
	}
	public static int countDPEff(String exp, boolean result, int start, int end, HashMap<String, Integer> cache){
		String  key = "" + start +end;
		int count = 0;
		if(!cache.containsKey(key)){
			if(start == end){
				if(exp.charAt(start) == '1'){
					count =1;
				}else{
					count  = 0;
				}
			}
			
			for(int i = start +1; i <=end; i+=2){
				char op = exp.charAt(i);
				if(op == '&'){
					count += countDPEff(exp, true, start, i -1, cache) * countDPEff(exp, true, i+1, end, cache);
				}else if(op == '|'){
					int left_ops = (i-1-start)/2;
					int right_ops = (end-i-1)/2;
					int total_ways = total(left_ops) * total(right_ops);
					int total_false =countDPEff(exp, false, start, i -1, cache) * countDPEff(exp, false, i+1, end, cache);
					count += total_ways - total_false;
				}else if (op == '^'){
					count += countDPEff(exp, true, start, i -1, cache) * countDPEff(exp, false, i+1, end, cache);
					count += countDPEff(exp, false, start, i -1, cache) * countDPEff(exp, true, i+1, end, cache);
				}
			}
			cache.put(key, count);
		}else{
			count = cache.get(key);
		}
		if(result){
			return count;
		}else{
			int num_ops = (end-start)/2;
			return total(num_ops) - count;
		}
	}
	
	public static int total(int n){
		long num = 1;
		long rem = 1;
		for(int i = 2; i <= n; i++){
			num *=(n+i);
			rem *=i;
			if(num % rem ==0){
				num /= rem;
				rem = 1;
			}
		}
		return (int) num;
	}
	
	public static void main(String[] args) {
		String terms = "0^0|1&1^1|0|1";
		boolean result = true;
		
		//bruteForce(terms, new HashMap<String, Boolean>(), result, new boolean[(terms.length() - 1) / 2]);
		System.out.println(countR(terms, result, 0, terms.length() - 1));
		System.out.println(countDP(terms, result, 0, terms.length() - 1, new HashMap<String, Integer>()));
	System.out.println(countDPEff(terms, result, 0, terms.length() - 1, new HashMap<String, Integer>()));
		
	}
}
