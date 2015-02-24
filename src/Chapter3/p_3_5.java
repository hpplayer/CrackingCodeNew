package Chapter3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import CtCILibrary.AssortedMethods;
/*Idea:
 * stack A always store data in reverse order of time 
 * enqueue, just use A 
 * dequeue, transfer n-1 data in B
 * pop the last n from A
 */
public class p_3_5 {
	static Stack<Integer> A = new Stack<Integer>();//used to store values
	static Stack<Integer> B = new Stack<Integer>();
	public static void enqueue(int value){
		A.push(value);
	}
	
	public int size(){
		return A.size();
	}
	
	public int peek(){
		reset(A, B);
		int top = B.peek();
		reset(B, A);
		return top;
		
	}
	public static void reset(Stack sor, Stack des){
		int temp = sor.size();
		for (int i = 0; i < temp; i++){
			des.push(sor.pop());
		}
	}
	
	public static int dequeue(){
		int counter = A.size();
		for (int i = 0; i < counter -1; i++ ){
			B.push(A.pop());
		}
		int result = A.pop();//last element in stack A
		reset(B, A);//put values back
		return result;
	}
	
	public static void main(String[] args) {

		p_3_5 my_queue = new p_3_5();	
		long start = System.nanoTime();
		// Let's test our code against a "real" queue
		Queue<Integer> test_queue = new LinkedList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			int choice = AssortedMethods.randomIntInRange(0, 10);
			if (choice <= 5) { // enqueue
				int element = AssortedMethods.randomIntInRange(1, 10);
				test_queue.add(element);
				my_queue.enqueue(element);
				System.out.print("Enqueued " + element + " ");
			} else if (test_queue.size() > 0) {
				System.out.println();
				int top1 = test_queue.remove();
				int top2 = my_queue.dequeue();
				if (top1 != top2) { // Check for error
					System.out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
				} 
				System.out.print("Dequeued " + top1 + " ");
			}
			
			if (test_queue.size() == my_queue.size()) {
				if (test_queue.size() > 0 && test_queue.peek() != my_queue.peek()) {
					System.out.println("******* FAILURE - DIFFERENT TOPS: " + test_queue.peek() + ", " + my_queue.peek() + " ******");
				}
			} else {
				System.out.println("******* FAILURE - DIFFERENT SIZES ******");
			}
		}
		long end = System.nanoTime();
		System.out.println();
		System.out.println("Time cost: " + (end - start)/1000 + " ms");
	}
}
