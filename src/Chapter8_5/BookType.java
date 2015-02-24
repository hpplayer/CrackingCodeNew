package Chapter8_5;

public enum BookType {
	fiction(0), comics(1),Journal(2);
	private int value;
	
	private BookType(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
