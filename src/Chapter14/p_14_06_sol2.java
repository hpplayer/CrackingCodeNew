package Chapter14;

public class p_14_06_sol2 {
	public static void main(String[] args) {
		int size = 10;
		CircularArray2<String> array = new CircularArray2<String>(size);
		for (int i = 0; i < size; i++) {
			array.set(i, String.valueOf(i));
		}
		
		array.rotate(3);
		for (int i = 0; i < size; i++) {
			System.out.print(array.get(i) + " ");
		}
		
		System.out.println("");
		
		array.rotate(2);
		for (String s : array) {
			System.out.print(s + " ");
		}
	}
}
