package Chapter11;

import CtCILibrary.AssortedMethods;

public class p_11_08_sol2 {
	private static RankNode root = null;
	
	public static void track(int Number){
		if(root == null){
			root = new RankNode(Number);//it is the first node!
		}else{
			root.insert(Number);
		}
	}
	
	public static int getRankOfNumber(int number){
		return root.getRank(number);
	}
	
	public static void main(String[] args) {
		int size = 100;
		int[] list = AssortedMethods.randomArray(size, -100, 100);
		for (int i = 0; i < list.length; i++) {
			track(list[i]);
		}
		
		int[] tracker = new int[size];
		for (int i = 0; i < list.length; i++) {
			int v = list[i];
			int rank1 = root.getRank(list[i]);
			tracker[rank1] = v;		
		}
		
		for (int i = 0; i < tracker.length - 1; i++) {
			if (tracker[i] != 0 && tracker[i + 1] != 0) {
				if (tracker[i] > tracker[i + 1]) {
					System.out.println("ERROR at " + i);
				}
			}
		}

		System.out.println("Array: " + AssortedMethods.arrayToString(list));
		System.out.println("Ranks: " + AssortedMethods.arrayToString(tracker));
	}
}
