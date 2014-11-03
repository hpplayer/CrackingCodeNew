package Chapter3;

import java.util.ArrayList;

public class p_3_3 {
	 int capacity;
	 static int counter = 0;
	 static ArrayList<Stack> ary;
	 
		public static void main(String[] args) {
			int capacity_per_substack = 5;
			p_3_3 set = new p_3_3(capacity_per_substack);
			for (int i = 0; i < 34; i++) {
				set.push(i);
			}
			//set.popAt(3);//counter 3 appears 4 times
			set.popAt2(3);
			for (int i = 0; i < 34; i++) {
				System.out.println("Popped " + set.pop());
				System.out.println(set.counter);
			}		
		}
		
	 public p_3_3(int capacity){
		 this.capacity = capacity;
		 Stack stac = new Stack(capacity);
		 ary= new ArrayList<Stack>();
		 ary.add(stac);
	 }
	 
	 Integer popAt2(int index){
		 return shiftleft(index, true);//when we call shiftleft, the inital step is pop()
	 }
	 
	int shiftleft(int index, boolean bool){
		 Stack stak = ary.get(index);
		 int removed_item;
		 if(bool) removed_item=  stak.pop();
		 else removed_item = stak.removeBottom();
		 if(stak.isEmpty()){
			 ary.remove(index);
		 }
		 else if (ary.size() > index+1){
			 int v = shiftleft(index +1, false);//recursively, pump the bottom node from later stack to previous stack
			 stak.push(v);
		 }
		 return removed_item;

	 }
	 
	 int popAt(int index){
			Stack tempStack = ary.get(index);
			int value = tempStack.pop();
			if(tempStack.size() <= 0){
				ary.remove(index);
				counter--;
			}
			return value;
		 
	 }

	 void push(int value){
		Stack tempStack = ary.get(counter);
		if(tempStack.size() >= capacity){
			counter ++;
			Stack stac = new Stack(capacity);
			stac.push(value);
			ary.add(stac);
		}else{
		tempStack.push(value);
		//ary.set(counter, tempStack);
		}
	 }
	 
	 Integer pop(){
		 if(counter < 0){
			 System.out.println("WRONG");
			 System.exit(0);
		 }
		 Stack tempStack = ary.get(counter);
	
		 int value = tempStack.pop();
		 if(tempStack.size()<=0){
			 counter--;
		 }
		 return value;
	 }
	 
	 Integer peek(){
		 Stack tempStack = ary.get(counter);
		 int value = tempStack.peek();
		 return value;
	 }
}
