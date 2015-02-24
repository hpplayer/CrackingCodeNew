package Chapter8_5_sol2;

import java.util.Hashtable;

public class UserManager {
	private Hashtable<Integer, User> users;
	
	public User addUser(int id, String details, int accountType){
		if(users.contains(id)){
			return null;
		}
		
		User user = new User(id, details, accountType);
		users.put(id, user);
		return user;
	}
	
	public boolean remove(User u){
		return remove(u.getUserID());
	}
	
	public boolean remove(int id){
		if(!users.contains(id)){
			return false;
		}
		users.remove(id);
		return true;
	}
	
	public User find(int id){
		return users.get(id);
	}
}
