package Chapter9;
import java.util.ArrayList;

public class p_9_4_sol2 {
	static ArrayList<ArrayList<Integer>> finalAry;
	public static ArrayList<ArrayList<Integer>> test(ArrayList<Integer> ary, int index){
		if(index == ary.size()){
			finalAry = new ArrayList<ArrayList<Integer>>();
			finalAry.add(new ArrayList<Integer>());
		}else{
			finalAry = test(ary, index+1);
			//ArrayList<Integer> newSubset = finalAry.get(index);
			int item = ary.get(index);
			//newsubsets is the new subsets that we added,
			//we need add all its new subsets as a whole, otherwise the order in finalAry will be ruined
			ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> temp: finalAry){
				ArrayList<Integer> newCopy = new ArrayList<Integer>();
				newCopy.addAll(temp);
				newCopy.add(item);
				newSubsets.add(newCopy);
			}
			finalAry.addAll(newSubsets);
		}
		return finalAry;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = test(list, 0);
		System.out.println(subsets.toString());
		

	}

}
