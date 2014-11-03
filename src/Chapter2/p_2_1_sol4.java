package Chapter2;
import CtCILibrary.*;
public class p_2_1_sol4 {
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 9; i++) {
			second = new LinkedListNode(i % 2, null, null);
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
	
	
	public static void solution(LinkedListNode head){
		LinkedListNode current = head;
		while(current != null){
			LinkedListNode runner = current.next;
			while (runner != null){
				if (runner.data == current.data){
					if(runner.next == null){
						runner.prev.next =null;
					}else{
					runner.prev.next = runner.next;
					runner.next.prev = runner.prev;
					}
					
				}
				runner = runner.next;
			}
	
			current = current.next;

		}


	}
	
	
}
