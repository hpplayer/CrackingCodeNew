package Chapter2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class p_2_3_sol2 {
	public static void solution(LinkedListNode c){
		if(c == null ||c.next == null)
			System.exit(0);
		
		c.data = c.next.data;
		c.next = c.next.next;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		//LinkedListNode head = null;
	    System.out.println(head.printForward());
		System.out.println("I will delete " + head.next.next.next.next.data);
		//Solution(head);
		solution(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}
}
