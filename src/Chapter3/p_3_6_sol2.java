package Chapter3;
import java.util.Stack;

import CtCILibrary.AssortedMethods;
public class p_3_6_sol2 {
	public static void  sort(Stack<Integer> stk){
		Stack<Integer> buf = new Stack<Integer>();
		while(!stk.isEmpty()){
			int temp = stk.pop();//step 1
			while(!buf.isEmpty() && buf.peek() > temp){//do step 2 only when buf.peek()> temp which means special handle is necessary 
				stk.push(buf.pop());
			}
			//after above loop, no data is larger than temp in buf
			buf.push(temp);//step 3
		}
	}
	
	static int c = 0;
	public static void main(String [] args) {
		long start = System.nanoTime();
		for (int k = 1; k < 100; k++) {
			c = 0;
			Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < 10 * k; i++) {
				int r = AssortedMethods.randomIntInRange(0,  1000);
				s.push(r);
			}
			if(k == 99){
				//System.out.println("ORI: " + s.toString());
			}
			
			sort(s);
			if(k == 99){
				//System.out.println("AFTER: " + s.toString());
			}
			//System.out.println("done");
			//System.out.println("input stack size:" + s.size());
			int last = Integer.MAX_VALUE;
			while(!s.isEmpty()) {
				int curr = s.pop();
				if (curr > last) {
					System.out.println("Error: " + last + " " + curr);
				}
				last = curr;
			}
			//System.out.println(c);
		}
		System.out.println("succeed !");
		long end = System.nanoTime();
		System.out.println("Time cost: " + (end - start)/1000 + " ms");
	}
}
