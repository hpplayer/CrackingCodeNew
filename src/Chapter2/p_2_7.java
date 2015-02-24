package Chapter2;

import java.util.Stack;

import CtCILibrary.LinkedListNode;

public class p_2_7 {
	public static boolean solution(LinkedListNode head){
		LinkedListNode faster = head;
		LinkedListNode slower = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		while(faster != null && faster.next != null){
			stack.push(slower.data);
			slower = slower.next;
			faster = faster.next.next;
		}
		
		if(faster != null){
			slower = slower.next;//skip mid element & use slower to compare data
		}
		
		while (slower!= null){
			int popout = stack.pop().intValue();
			if(popout == slower.data){
				slower=slower.next;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int length = 10;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		 nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		p_2_7 q = new p_2_7();
		System.out.println(q.solution(head));
	}
}
