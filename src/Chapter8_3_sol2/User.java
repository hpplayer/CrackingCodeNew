package Chapter8_3_sol2;

public class User {
	private String name;
	private long ID;
	public User(String name, long id){
		name = name;
		ID = id;
	}
	
	public User getUser(){
		return this;
	}
	public static User addUser(String name, long id){
		return new User(name, id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}

}
