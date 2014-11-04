package Chapter3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import CtCILibrary.AssortedMethods;
public class p_3_5_sol2 {
	Stack<Integer> newest = new Stack<Integer>(); //always has newest on top
	Stack<Integer> oldest = new Stack<Integer>();//always has oldest on top
	
	public void enqueue(int value){
		newest.push(value);
	}
	
	public void shift(){
		//shift only if oldest is empty otherwise we can use stack oldest directly
		if(oldest.isEmpty()){
			while(!newest.isEmpty()){
				oldest.push(newest.pop());
			}
		}
	}
	
	public int dequeue(){
		shift();
		return(oldest.pop()); //may leave stack oldest empty
	}
	
	public int peek(){
		shift();
		return(oldest.peek());
	}
	
	public int size(){
		return (oldest.size() + newest.size());
	}
	
	public static void main(String[] args) {
		p_3_5_sol2 my_queue = new p_3_5_sol2();	
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
