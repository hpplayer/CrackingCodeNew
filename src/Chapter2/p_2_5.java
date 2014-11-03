package Chapter2;
import CtCILibrary.*;
public class p_2_5 {
	public static LinkedListNode solution(LinkedListNode x, LinkedListNode y){
		StringBuffer xb = new StringBuffer();
		StringBuffer yb = new StringBuffer();
		LinkedListNode Ptx = x;
		LinkedListNode Pty = y;
		
		while ( Ptx != null){
			xb.append(Ptx.data);
			Ptx = Ptx.next;
		}
		
		String strX = xb.reverse().toString();
		//System.out.println(strX);
		while ( Pty != null){
			yb.append(Pty.data);
			Pty = Pty.next;
		}
		String strY = yb.reverse().toString();
		//System.out.println(strY);
		String result = (Integer.parseInt(strY) + Integer.parseInt(strX))+"";
		
		String result2 = new StringBuffer(result).reverse().toString();
		char[] resultArray = result2.toCharArray();
		LinkedListNode head = new LinkedListNode();
		LinkedListNode current = new LinkedListNode();
		LinkedListNode previous = new LinkedListNode();
		
		//current.data=Character.getNumericValue(resultArray[0]);
		current.data = Integer.valueOf(resultArray[0]+"");
		//current.data = resultArray[0] - '0';
		//System.out.println(resultArray[0]);
	//	System.out.println(current.data);
		previous = current;
		head = current;
		
		for (int i = 1; i < resultArray.length; i++){
				current = new LinkedListNode();
				//System.out.println(current.data);
				//current.data = Character.getNumericValue(resultArray[i]);
			current.data = Integer.valueOf(resultArray[i]+"");
				previous.next = current;
				previous = current;
		}
		
		return head;
	}
	
	
	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}	
	
	
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(0, null, lB2);	
		
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
