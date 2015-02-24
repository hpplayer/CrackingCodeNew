package Chapter8_7;

public class Administor {
	int id; 
	String name;
	AccessControl access;
	
	public Administor(){
		access = AccessControl.Administor;
	}
}
