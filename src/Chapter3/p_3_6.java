package Chapter3;
import java.util.Stack;

import CtCILibrary.AssortedMethods;
public class p_3_6 {
	/*This solution use an int called counter to count how many current minimum data occurs during the process of 
	 *transferring data from original stack to buffer stack. So, after the original is empty, we firstly put number of counts 
	 *minimum data back to original stack. Then we put remaining data back from buffer stack to original stack.
	 * We dispose all current minimum data. In the next run we start transfer data after current minimum data and so on
	 * The time cost of this algorithm is O(n^n), where n is the number of data in the original stack.
	 */
	
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
	
	public static void sort(Stack<Integer> input){
		int min = input.peek();//used as buffer hold current minimum data
		int max =input.peek();//mark the maximum data
		int count = 0;//count the appearances of one element
		int Maxcount = 0;
		Stack<Integer> buff = new Stack<Integer>();//used as buffer stack
		
		while(!input.isEmpty()){//don't push minimum data into buffer stack
			if(input.peek() > max){
				max = input.peek();
				Maxcount = 1;
			}
			else if (input.peek() == max){
				Maxcount++;
			}
				buff.push(input.pop());
		}//end while loop
		
		while(!buff.isEmpty()){
			input.push(buff.pop());
		}
		// now we get the max data and its counts in this stack

		//System.out.println("B");
		while(!input.isEmpty()){//don't push minimum data into buffer stack
			if(input.peek() <min){
				min = input.peek();
				count = 1;
			}
			else if (input.peek() == min){
				count ++;
			}
				buff.push(input.pop());
		}//end while loop
		//System.out.println("A");
		for(int i= 0; i <count; i++){//put minimum data back
			input.push(min);
		}
		count = 0;//reset data	
		while(!buff.isEmpty()){
			if(buff.peek() == min){
				buff.pop();	
				}
				else if(buff.peek()>min){
				input.push(buff.pop());
				}
				else{
						System.out.println("wrong");
				}
		}
	//	System.out.println("done initialization");

		while(min != max){

			//System.out.println("max: " + max);
			//System.out.println("input.peek() " + input.peek());
			//System.out.println("buffer.size() " + buff.size());
			int min2 = input.peek();
			//System.out.println("min: " + min);
			//System.out.println("min2: " + min2);
			//System.out.println("input.size() " + input.size());		
			while(input.peek() > min){//don't push minimum data into buffer stack
				//don't push minimum data into buffer stack
				//System.out.println(1);
					if(input.peek() < min2){
						min2 = input.peek();
						count =1;//count 1 cuz in the same loop it will be pop into buffer
					}
					else if (input.peek() == min2){
						count++;
					}
				buff.push(input.pop());
			}//found the next min data
		//	System.out.println("buffer.size() " + buff.size());
	
				//System.out.println(input.toString());

			//System.out.println(input.size());
			//System.out.println(count);
			for(int i= 0; i <count; i++){//put minimum data back
				input.push(min2);
			}
			while(!buff.isEmpty()){
				if(buff.peek() == min2){
				buff.pop();	
				}
				else if(buff.peek()>min2){
				input.push(buff.pop());
				}
				else{
						System.out.println("wrong");
				}
			}
			
		
			min = min2;
			count = 0;//reset data
		
		}
		//put max data back
	
		for (int i = 0; i < Maxcount; i++){
			input.push(max);
		}
		
	}
}
