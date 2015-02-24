package Chapter11;

import java.util.ArrayList;

import CtCILibrary.AssortedMethods;

public class p_11_08 {
	static Heap heap = new Heap();;
	static ArrayList<Node> nodeList = new ArrayList<Node>();
	public p_11_08(){
	}
	public static void track(int n){
		Node newNode = new Node(n);
		nodeList.add(newNode);
		heap.insert(newNode);
	}
	
	public static int getRankOfNumber(Node n){
		return	heap.countRank(n);
	}
	
	public static void main(String[] args) {
		int size = 100;
		int[] list = AssortedMethods.randomArray(size, -100, 100);
		//int[] list = {-97,-5,-76,8,-15};
		for (int i = 0; i < list.length; i++) {
			track(list[i]);

		}
		//System.out.println(getRankOfNumber(new Node(1000)));//the linkedlist automatically return -1;
		//System.out.println(heap.heap.getFirst().value);
		int[] tracker = new int[size];
		for (int i = 0; i < list.length; i++) {
			int v = list[i];
			int rank1 = getRankOfNumber(nodeList.remove(0));
			//System.out.println(rank1);
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
