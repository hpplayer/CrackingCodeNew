package Chapter3;
import java.util.EmptyStackException;
/*For simplicity, three stacks have same length
 * 
 * 
 */
public class p_3_1 {
	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {-1, -1, -1}; //stackNum is 0, 1, 2
	
	
	int trueValue(int stackNum){
		return stackNum * stackSize +stackPointer[stackNum];
	}
	
	boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
	}
	void push(int stackNum, int value) throws Exception{
		if(stackPointer[stackNum] + 1 >= stackSize) throw new FullStackException();
		stackPointer[stackNum]++;
		buffer[trueValue(stackNum)] = value;
	}
	
	int pop(int stackNum) throws Exception{
		if(isEmpty(stackNum)) throw new EmptyStackException();
		int value = buffer[trueValue(stackNum)];
		buffer[trueValue(stackNum)] = -1;//set the corresponding value to -1
		stackPointer[stackNum]--;
		return value;
	}
	
	int peek(int stackNum){
		if(isEmpty(stackNum)) throw new EmptyStackException();
		return buffer[trueValue(stackNum)];
	}
	
	public static void main(String [] args) throws Exception  {
		p_3_1 test = new p_3_1();
		test.push(2, 4);
		System.out.println("Peek 2: " + test.peek(2));
		test.push(0, 3);
		test.push(0, 7);
		test.push(0, 5);
		System.out.println("Peek 0: " + test.peek(0));
		test.pop(0);
		System.out.println("Peek 0: " + test.peek(0));
		test.pop(0);
		System.out.println("Peek 0: " + test.peek(0));
	}
}
