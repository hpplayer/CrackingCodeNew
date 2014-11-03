package Chapter2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class p_2_3 {
	public static void Solution(LinkedListNode c){

		LinkedListNode pt = c;
		//if we search until the last node, then it would be too late cuz its data has been copid in previous node
		if (pt == null ||pt.next == null) {
			System.out.println("error occurs");
			System.exit(0);
		}
		while (pt.next != null ){
			if(pt.next.next == null){
				pt.data = pt.next.data;
				pt.next = null;
				break;
			}else{
			pt.data = pt.next.data;
			pt = pt.next;
			}
		
		}
		//pt is the 2th to last node
		
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		//LinkedListNode head = null;
	    System.out.println(head.printForward());
		System.out.println("I will delete " + head.next.next.next.next.data);
		//Solution(head);
		Solution(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}
}
