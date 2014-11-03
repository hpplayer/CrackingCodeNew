package Chapter2;

import java.util.HashMap;
import java.util.HashSet;

import CtCILibrary.LinkedListNode;

public class p_2_1_sol3 {
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 3, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		//LinkedListNode clone = head.clone();
		solution(head);
		//deleteDupsA(head);
		System.out.println(head.printForward());
	}
	
	
	public static void deleteDupsA(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	public static void solution(LinkedListNode head){
		HashSet hs = new HashSet();
		LinkedListNode current = head;
		int count = 0;
		while(current != null){

			if(hs.contains(current.data)){
		
				
				if(current.prev != null){
					if(current.next == null){
						current.prev.setNext(null);
					}else{
					current.next.setPrevious(current.prev);
					current.prev.setNext(current.next);}
					//current.next = head.next;
					}
			
			}else{
				hs.add(current.data);
				//current = head;
				
			}
			current = current.next;
		}

	}
}
