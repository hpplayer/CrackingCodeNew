package Chapter11;

import java.util.ArrayList;
import java.util.HashMap;

public class p_11_07 {
	public static ArrayList<HtWt> test2(ArrayList<HtWt> people, HtWt line, HashMap<HtWt, ArrayList<HtWt>> hs){
		if(hs == null){
			hs = new HashMap<HtWt, ArrayList<HtWt>>();
		}
		if(hs.containsKey(line)){
			return hs.get(line);
		}
		int max = 0;
		ArrayList<HtWt> result=null;
		for(int i = 0; i < people.size(); i++){
			if(people.get(i).isBefore(line)){
				ArrayList<HtWt> newStack = test2(people, people.get(i), hs);
				if(newStack.size() > max){
		
					max = newStack.size();
					result = newStack;
				}
			}
		}
		
		if(result == null){
			result = new ArrayList<HtWt>();
		}

		if(line != null){
			result.add(0,line);
		}
		hs.put(line, result);//maximum it can get from this line
		return result;
	}
	public static ArrayList<HtWt> test(ArrayList<HtWt> people, HtWt line){
		int max = 0;
		ArrayList<HtWt> result=null;
		for(int i = 0; i < people.size(); i++){
			if(people.get(i).isBefore(line)){
				ArrayList<HtWt> newStack = test(people, people.get(i));
				if(newStack.size() > max){
					max = newStack.size();
					result = newStack;
				}
			}
		}
		
		if(result == null){//if now we are dealing with the base case, i.e. no one can be bofore the null
			result = new ArrayList<HtWt>();
		}

		if(line != null){
			result.add(0,line);
		}
		
		return result;
	}
	
	public static ArrayList<HtWt> test3(ArrayList<HtWt> htwts, HtWt currentLine, HashMap<HtWt, ArrayList<HtWt>> hs){
		if(hs == null) hs = new HashMap<HtWt, ArrayList<HtWt>>();
		if(hs.containsKey(currentLine)) return hs.get(currentLine);
		int max = 0;
		ArrayList<HtWt> results =null;
		for(HtWt htwt: htwts){
			if(htwt.isBefore(currentLine)){
				ArrayList<HtWt> currentStack = test3(htwts, htwt, hs);
				if(currentStack.size() > max){
					max = currentStack.size();
					results = currentStack;
				}
			}
		}

		if(results == null){
			results = new ArrayList<HtWt>();
		}

		if(currentLine != null){
			results.add(0, currentLine);
		}

		hs.put(currentLine, results);

		return results;
	}
	
	public static ArrayList<HtWt> initialize() {
		ArrayList<HtWt> items = new ArrayList<HtWt>();
		
		HtWt item = new HtWt(65, 60);
		items.add(item);
		
		item = new HtWt(70, 150);
		items.add(item);
		
		item = new HtWt(56, 90);
		items.add(item);
		
		item = new HtWt(75, 190);
		items.add(item);
		
		item = new HtWt(60, 95);
		items.add(item);
		
		item = new HtWt(68, 110);
		items.add(item);
		
		item = new HtWt(35, 65);
		items.add(item);
		
		item = new HtWt(40, 60);
		items.add(item);
		
		item = new HtWt(45, 63);
		items.add(item);
		
		return items;
	}
	
	public static void printList(ArrayList<HtWt> list) {
		for (HtWt item : list) {
			System.out.println(item.toString() + " ");
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<HtWt> items = initialize();
		ArrayList<HtWt> solution2 = test3(items, null, null);
		printList(solution2);
		ArrayList<HtWt> solution = test2(items, null, null);
		System.out.println();
		printList(solution);
	}
}
