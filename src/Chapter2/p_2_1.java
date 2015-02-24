package Chapter2;
import java.util.Random;

import CtCILibrary.*;

public class p_2_1 {
	//public static LinkedListNode Solution(LinkedListNode head){
	public static void Solution(LinkedListNode head){
		LinkedListNode pt1 = head;
		LinkedListNode pt2 = pt1;
		while(pt2.next != null){
			 pt2 = pt2.next; //jump out of the loop until t2 is the last node
		}
		//System.out.println("pt2: " + pt2.data);
		//System.out.println(pt1 == head);
		/*
		System.out.println(head.data);
		System.out.println(pt1.data);
		System.out.println(head.equals(head));
		pt1.data = 5;
		System.out.println(head.data);
		System.out.println(pt1.data);
		pt2.data = 9;
		System.out.println(head.data);
		System.out.println(pt1.data);
		*/
		
	
		//System.out.println(pt1.equals(pt2));

		while(pt1.next != pt2){//we constraint pt1 no next than the last second node, pt2 to be the last node
			while(pt2 != pt1){
				if(pt2.data == pt1.data){
						if(pt2.next == null){//handling tail case
							pt2.prev.next = null;
						}else{
					pt2.prev.next = pt2.next;
					pt2.next.prev = pt2.prev;}
			
				}
				if (pt2.prev != null){pt2 =pt2.prev;}
			}
			
			while(pt2.next != null){
				 pt2 = pt2.next; //jump out of the loop until t2 is the last node
			}
			
			if (pt1.next != null)
			{pt1 = pt1.next;}else{
				break;
			}
			
		
		}
		
		if(pt1.next == pt2 && pt1.data == pt2.data){ //handling only two nodes case
			pt1.next = null;
		}



	//	System.out.println(head.data);
		//System.out.println(head.next.data);
		//System.out.println(head.next.next.data);
		//System.out.println(pt1.data);
		//System.out.println(pt1 == head);
		
		//pt1.data = 5;
		//System.out.println(head.data);
		//System.out.println(pt1.data);
	

		/*
		while(pt2.prev != null){
			pt2 = pt2.prev;
		}
		head = pt2;
		return head;
*/
	}
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 20; i++) {
			Random rand = new Random();
			int z = rand.nextInt(20) + 1;
			second = new LinkedListNode(i % z, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		//LinkedListNode clone = head.clone();
		Solution(head);
		System.out.println(head.printForward());
	}
}
