package Chapter2;

import CtCILibrary.LinkedListNode;

public class p_2_4 {
	public static LinkedListNode solution (LinkedListNode head, int k){
		if (head == null) return null;
		LinkedListNode min = head;//always points to the head of 1st smaller node 
		LinkedListNode kfirst = head;
		LinkedListNode Ptmin = head;
		LinkedListNode Ptmax = head;
		LinkedListNode Ptk = head;
		LinkedListNode max = head;//always points to the head of 1st larger node
		LinkedListNode pt = head;
		//find the 1st smaller value
		while(min != null){
			if(min.data < k){
				Ptmin = min;
				break;
			}
			min = min.next;
		}

		
		while(kfirst!= null){
			if(kfirst.data == k){
				Ptk = kfirst;
				break;
			}
			 kfirst =  kfirst.next;
		}
		
		//find the 1st larger value
		while(max!= null){
			if(max.data > k){
				Ptmax = max;
				break;
			}
			max = max.next;
		}

		while(pt != null){
			if(pt.data > k && pt != max){
				Ptmax.next = pt;
				Ptmax = Ptmax.next;
				//System.out.println(Ptmax.data);
			}
			else if(pt.data < k && pt != min){
				Ptmin.next = pt;
				Ptmin = Ptmin.next;
			}
			else if (pt.data == k && pt != kfirst){
				Ptk.next = pt;
				Ptk = Ptk.next;
			}
			pt = pt.next;
		}//end while loop
	
		Ptmax.next = null;
		Ptmin.next = kfirst;
		Ptk.next = max;
		
		if(min != null && min.data < k){
				return min;
		}
		else {
			System.out.println("I'm here");
			return kfirst;
		}

	}
	


	public static void main(String[] args) {
		int length = 20;
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
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		
		LinkedListNode h = solution(head, 7);
		System.out.println(h.printForward());
	}

}
