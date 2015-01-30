package Chapter8_7;

public class User {
	int id;
	String name;
	AccessControl access;
	String currentDisplayMsg;
	
	public User(){
		access = AccessControl.User;
	}
	
	public String send(String str){
		currentDisplayMsg = str;
		return str;
	}
	
	public void receive(String str){
		currentDisplayMsg = str;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
