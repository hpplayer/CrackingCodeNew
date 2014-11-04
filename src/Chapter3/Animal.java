package Chapter3;

public class Animal {
	private static String Name;
	private static int ID;
	public static String getName() {
		return Name;
	}
	public static void setName(String name) {
		Name = name;
	}
	public static int getID() {
		return ID;
	}
	public static void setID(int iD) {
		ID = iD;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.ID < a.getID();
	}
	
	
}
