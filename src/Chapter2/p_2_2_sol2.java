package Chapter2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.IntWrapper;
import CtCILibrary.LinkedListNode;

public class p_2_2_sol2 {
	public static int solution(LinkedListNode head, int k){
		if(k == 0 ||head == null) return 0;
		
		int n = solution(head.next, k)+1;
		
		if( n == k){
			System.out.println(k+ " th data to last element is " + head.data);
		}
		
		return n;
		
		
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth = 3;
		IntWrapper wr = new IntWrapper();

		solution(head, nth);

	}
	
	
}
