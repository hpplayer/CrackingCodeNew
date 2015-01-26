package Chapter8_2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * test add method of queue class
 * 
 */
public class testqueue {
	public static void main(String[] args){
		Queue que = new LinkedList();
		que.add(1);
		que.add(2);
		que.add(3);
		System.out.println(que.peek());
		
	}
}
