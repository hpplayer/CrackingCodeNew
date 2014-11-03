package Chapter3;

import java.util.Stack;

import CtCILibrary.AssortedMethods;

public class p_3_2 extends Stack<Integer>{
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int n){
		if(n <= min()){
			minStack.push(n);
		}
		super.push(n);
		
	}
	
	public Integer pop(){
		int value = super.pop();
		if (value == min()){
			minStack.pop();
		}
		return value;
	}
	
	public int min(){
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return minStack.peek();
		}
	}
	
	public static void main(String[] args) {
		p_3_2 stack = new p_3_2();
		//p_3_2 stack2 = new p_3_2();
		for (int i = 0; i < 15; i++) {
			int value = AssortedMethods.randomIntInRange(0, 100);
			stack.push(value);
			System.out.print(value + "; ");
		}
		System.out.println('\n');
		for (int i = 0; i < 15; i++) {
			System.out.println("Popped " + stack.pop().intValue() );
			System.out.println("New min is " + stack.min());
		}
	}
	
}
