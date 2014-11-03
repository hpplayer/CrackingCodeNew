package Chapter2;
import CtCILibrary.*;


public class p_2_2 {
	public static LinkedListNode solution(LinkedListNode head, int k){
		LinkedListNode pt1 = head;
		LinkedListNode pt2 = head;
		
		for ( int i = 0; i < k-1; i ++){
			if (pt2 == null) return null;
			pt2 = pt2.next;
		}
		if (pt2 == null) return null;
	//pt2's position is pt1 + k
		
		while( pt2.next != null){
			pt1 = pt1.next;
			pt2 = pt2.next;
		}
		//pt2 reach end
		
		return pt1;
					
	}
	
	
	public static int nthToLastR1(LinkedListNode head, int n) {
		if (n == 0 || head == null) {
			return 0;
		}
		int k = nthToLastR1(head.next, n) + 1;
		if (k == n) {
			
			System.out.println(n + "th to last node is " + head.data);
		}
		return k;
	}
	
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth = 3;
		IntWrapper wr = new IntWrapper();

		 nthToLastR1(head, nth);
		 /*
		 LinkedListNode n = solution(head, nth);
		if (n != null) {
			System.out.println(nth + "th to last node is " + n.data);
		} else {
			System.out.println("Null.  n is out of bounds.");
		}
		*/
	}
	
	
	
	
}
