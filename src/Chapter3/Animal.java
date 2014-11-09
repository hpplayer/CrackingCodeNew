package Chapter3;

public class Animal {
	/*Remember static is class variable that shared by all instances of the same class
	 * so dont make ID and Name static or the results will be same as the last settings
	 * 
	 */
	private String Name;
	private  int ID;
	public  String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getID() {
		return ID;
	}
	public  void setID(int iD) {
		ID = iD;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.ID < a.getID();
	}
	
	
}
