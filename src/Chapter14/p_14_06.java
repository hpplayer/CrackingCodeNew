package Chapter14;

public class p_14_06 {
	public static void main(String[] args){
		CircularArray2<String> temp2 = new CircularArray2<String>(3);
		temp2.set(0, "a");
		temp2.set(1, "b");
		temp2.set(2, "c");
		
		temp2.rotate(2);
		for(int i = 0; i < 3; i ++){
			System.out.print(temp2.get(i));
		}
		
		System.out.println();
		CircularArray<String> temp = new CircularArray<String>();
		temp.add("a");
		temp.add("b");
		temp.add("c");
		
		temp.rotate(2);
		System.out.println(temp.toString());
	}
}
