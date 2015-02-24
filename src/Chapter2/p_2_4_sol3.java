package Chapter2;

import CtCILibrary.LinkedListNode;
/*This method improve the official solution but cannot handle the case, where k has duplicate nodes 
 * flaghead and flagtail are flags for indicating the initial case where node(has k value).next = tail
 * and head.next = node (has k value) 
 * 
 */
public class p_2_4_sol3 {
	public static LinkedListNode solution(LinkedListNode node, int k){

		LinkedListNode head = node;
		LinkedListNode tail = node;
		LinkedListNode pt = node;
		LinkedListNode start = node;
		int flaghead = 0;
		int flagtail = 0;
		while (pt != null){
			if(pt.data == k){
				start = pt;
			}
			pt = pt.next;
			
		}
		LinkedListNode next2 = start.next;
		//System.out.println(start.data);
		while(node != null){
			
			LinkedListNode next = node.next;//move node before it is changed
			if (node.data < k ){
				if(flaghead == 0){
					node.next = start;
					head = node;
					flaghead = 1;
				}else{
				node.next = head;
				head = node; //head always first
				}
				node = next;
			}
			else if (node.data > k){
				if(flagtail == 0){
					start.next = node;
					tail = node;
					flagtail = 1;
					//System.out.println(node.data);
				}else{
				tail.next = node;
				tail = node;//tail always last 
				node = next;
				}
			}else{node  = next2;}	
			
		}
		
		
		flaghead = 0;
		flagtail = 0;
		tail.next = null;
		return head;
	}
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {1, 3, 7, 5, 2, 9, 4};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		/* Partition */
		LinkedListNode h = solution(head, 5);
		
		/* Print Result */
		System.out.println(h.printForward());
	}
}
