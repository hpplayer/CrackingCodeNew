package Chapter2;
import CtCILibrary.*;

/*
 * use hare and tortoise algorithm to detect loop
 * 
 * 
 */
public class p_2_6 {
	public static LinkedListNode solution (LinkedListNode head){
		LinkedListNode faster = head;
		LinkedListNode slower = head;
		
		while (faster != null || faster.next != null){
			faster = faster.next.next;
			slower = slower.next;
			if(faster == slower){
				break;
			}
		}
		
		
		if (faster == null || faster.next == null) {
			System.out.println("no loop");
			return null;
		}
		slower = head;
		while(faster != slower){
			slower = slower.next;
			faster = faster.next;
		}
		
		return slower;
	}
	
	public static void main(String[] args) {
		int list_length = 50;
		int k = 5;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = solution(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
	}
}
