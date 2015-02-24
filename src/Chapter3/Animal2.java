package Chapter3;


public abstract class Animal2 {
	private int order; 
	protected String name;
	public Animal2(String n) {
		name = n;
	}
	
	public abstract String name();
	
	public void setOrder(int ord) {
		order = ord;
	}
	
	public int getOrder() {
		return order;
	}
	
	public boolean isOlderThan(Animal2 a) {
		return this.order < a.getOrder();
	}
}
