package Chapter11;

import java.util.ArrayList;
import java.util.Collections;

public class p_11_07_sol2 {
	public static class HtWt implements Comparable{
		int h;
		int w;
		public HtWt(int h, int w){
			this.h = h;
			this.w = w;
		}
		/*
		 * useless method
		 */
		public int compareTo(Object o) {
			HtWt second = (HtWt) o;
			if(this.h !=second.h){
				return ((Integer) this.h).compareTo((Integer) second.h);
			}else{
				return ((Integer) this.w).compareTo((Integer) second.w);
			}
		}
		
		public String toString() {
			return "(" + h + ", " + w + ")";
		}
		
		public boolean isBefore(HtWt other){
			return (this.h < other.h && this.w< other.w);
		}
		
	}
	private static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2){
		if(seq1 == null){
			return seq2;
		}else if(seq2 == null){
			return seq1;
		}
		return seq1.size() > seq2.size()? seq1 : seq2;
	}
	
	private static void LongestIncreasingSubsequence(ArrayList<HtWt> array, ArrayList<HtWt>[] solutions, int current_index){
		if(current_index >= array.size() || current_index <0){
			return;
		}
		
		HtWt current_element = array.get(current_index);
		ArrayList<HtWt> best_sequence = null;
		for(int i = 0; i < current_index; i++){//search arraylist visted before
			if(array.get(i).isBefore(current_element)){ //element i before currentElement
				best_sequence = seqWithMaxLength(best_sequence, solutions[i]);//update best_sequence
			}
		}
		
		ArrayList<HtWt> new_solution = new ArrayList<HtWt>();
		if(best_sequence != null){
			new_solution.addAll(best_sequence);
		}
		new_solution.add(current_element);
		
		solutions[current_index] = new_solution;
		LongestIncreasingSubsequence(array, solutions, current_index+1);
		
	
	}
	
	private static ArrayList<HtWt> LongestIncreasingSubsequence(ArrayList<HtWt> array){
		ArrayList<HtWt>[] solutions = new ArrayList[array.size()];
		LongestIncreasingSubsequence(array, solutions, 0);
		ArrayList<HtWt> best_sequence = null;
		for(int i = 0; i < array.size(); i++){
			best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
		}
		
		return best_sequence;
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
	
	public static ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> items) {
		Collections.sort(items);
		return LongestIncreasingSubsequence(items);
	}
	
	public static void main(String[] args) {
		ArrayList<HtWt> items = initialize();
		ArrayList<HtWt> solution = getIncreasingSequence(items);
		printList(solution);
	}
}
