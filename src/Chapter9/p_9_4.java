package Chapter9;

import java.util.ArrayList;

public class p_9_4 {
	static ArrayList<ArrayList<Integer>> allsubsets;
	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		if(set.size() == index){//base case each element in allsubsets should represent a number and its subsets.
			//System.out.println(index);
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}else{
			allsubsets = getSubsets(set, index+1);//get the subsets of index +1; previous??next???
			int item = set.get(index);//get the item in main set
			ArrayList<ArrayList<Integer>> moreSubsets =new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> s: allsubsets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();//create new subset that containing item
				newsubset.addAll(s);//add previous subsets into new set
				newsubset.add(item);//add new item
				moreSubsets.add(newsubset);
			}
			allsubsets.addAll(moreSubsets);
		}
		return allsubsets;
	}
	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set){
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for(int k = x; k > 0; k >>=1){ // k = k >> 1

			if((k & 1) == 1){ //if the last bit is 1, then true
				System.out.println(set.get(index));
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set){
		allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 <<set.size(); //compute 2^n
		for(int k = 0; k < max; k++){

			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
		System.out.println(subsets.toString());
		
		ArrayList<ArrayList<Integer>> subsets2 = getSubsets2(list);
		System.out.println(subsets2.toString());		
	}

}
