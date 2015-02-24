package Chapter2;

import CtCILibrary.LinkedListNode;

public class p_2_5_followUp {
	public static LinkedListNode solution(LinkedListNode x, LinkedListNode y){
		StringBuffer xb = new StringBuffer();
		StringBuffer yb = new StringBuffer();
		LinkedListNode Ptx = x;
		LinkedListNode Pty = y;
		
		while ( Ptx != null){
			xb.append(Ptx.data);
			Ptx = Ptx.next;
		}
		
		String strX = xb.toString();
		//System.out.println(strX);
		while ( Pty != null){
			yb.append(Pty.data);
			Pty = Pty.next;
		}
		String strY = yb.toString();
		//System.out.println(strY);
		String result = (Integer.parseInt(strY) + Integer.parseInt(strX))+"";
		
		char[] resultArray = result.toCharArray();
		LinkedListNode head = new LinkedListNode();
		LinkedListNode current = new LinkedListNode();
		LinkedListNode previous = new LinkedListNode();
		
		current.data=Character.getNumericValue(resultArray[0]);
		//System.out.println(resultArray[0]);
	//	System.out.println(current.data);
		previous = current;
		head = current;
		
		for (int i = 1; i < resultArray.length; i++){
				current = new LinkedListNode();
				//System.out.println(current.data);
				current.data = Character.getNumericValue(resultArray[i]);
			
				previous.next = current;
				previous = current;
		}
		
		return head;
	}
	
	
	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		while (node != null) {
			value = value * 10 + node.data;
			node = node.next;
		}
		return value;
	}	
	
	

		public static void main(String[] args) {
			LinkedListNode lA1 = new LinkedListNode(3, null, null);
			LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
			LinkedListNode lA3 = new LinkedListNode(5, null, lA2);
			
			LinkedListNode lB1 = new LinkedListNode(5, null, null);
			LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
			LinkedListNode lB3 = new LinkedListNode(1, null, lB2);	
			LinkedListNode lB4 = new LinkedListNode(0, null, lB3);	
			
			LinkedListNode list3 = solution(lA1, lB1);
			
			System.out.println("  " + lA1.printForward());		
			System.out.println("+ " + lB1.printForward());			
			System.out.println("= " + list3.printForward());	
			
			int l1 = linkedListToInt(lA1);
			int l2 = linkedListToInt(lB1);
			int l3 = linkedListToInt(list3);
			
			System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
			System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		
		}
}
