package Chapter3;
import java.util.Stack;

public class p_3_4 {
	static Stack<Integer> A = new Stack<Integer>();
	static Stack<Integer> B = new Stack<Integer>();
	static Stack<Integer> C = new Stack<Integer>();
	static int n = 10;//number of disks
	
	public static void main(String[] args) {
		// Set up code.


		for (int i = n - 1; i >= 0; i--) {
			A.push(i);
		}
		
		// Copy and paste output into a .XML file and open it with internet explorer.
		int size = C.size();
		for(int i = 0; i < size; i++){
			System.out.println("C contains: " + C.pop());
		}
		//System.out.println(A.size());
		/*
		System.out.println("A contains: " + A.pop());
		System.out.println("A contains: " + A.pop());
		System.out.println("A contains: " + A.pop());
		System.out.println("A contains: " + A.pop());
		System.out.println("A contains: " + A.pop());
		*/
		int size2 = A.size();
		for(int i = 0; i < size2; i++){
			System.out.println("A contains: " + A.pop());
			//System.out.println(i);
		}
		for (int i = n - 1; i >= 0; i--) {
			A.push(i);
		}
		
		new p_3_4().MoveAmongRods(n, C, A, B);
		System.out.println("after running codes");
		int size3 = C.size();
		for(int i = 0; i < size3; i++){
			System.out.println("C contains: " + C.pop());
		}
		int size4 = A.size();
		for(int i = 0; i < size4; i++){
			System.out.println("A contains: " + A.pop());
		}
	}

	public void add(int i, Stack<Integer> stk){
		if(stk.peek() > i){
			stk.push(i);
		}else{
			System.out.println("ERROR");
		}
	}

	
	//here last mean the largest the disk in that rod
	public static void MoveLastDisk(Stack<Integer> source, Stack<Integer> desti){
		int last = source.pop();
		desti.push(last);
	}
	
	public static void MoveAmongRods(int i, Stack desti, Stack source, Stack buffer){
		if(i > 0){
			MoveAmongRods(i-1, buffer, source, desti);
			MoveLastDisk(source, desti);
			MoveAmongRods(i-1, desti, buffer, source);
		}
	}
	
}
