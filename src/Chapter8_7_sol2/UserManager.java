package Chapter8_7_sol2;

import java.util.Date;
import java.util.HashMap;

public class UserManager {
	private static UserManager instance;
	private HashMap<String, User> usersByAccountName = new HashMap<String, User>();
	private HashMap<Integer, User> onlineUsers = new HashMap<Integer, User>();
	public static UserManager getInstance(){
		if(instance == null){
			instance = new UserManager();
		}
		return instance;
	}
	
	public void addUser(User fromUser, String toAccountName){
		User toUser = usersByAccountName.get(toAccountName);
		AddRequest req = new AddRequest(fromUser, toUser, new Date());
		toUser.receivedAddRequest(req);
		fromUser.sentAddRequest(req);
	}
	
	public void approveAddrequest(AddRequest req){
		req.status = RequestStatus.accept;
		User from = req.getFromUser();
		User to = req.getToUser();
		from.addContact(to);
		to.addContact(from);
	}
	
	public void rejectAddrequest(AddRequest req){
		req.status = RequestStatus.reject;
		User from = req.getFromUser();
		User to = req.getToUser();
		from.removeAddRequest(req);
		to.removeAddRequest(req);
	}
	
	public void userSignedOn(String accountName){
		User user = usersByAccountName.get(accountName);
		if(user != null){
			user.setStatus(new UserStatus("", UserStatusType.Availabe));
			onlineUsers.put(user.getId(), user);	
		}	
	}
	
	public void userSignedOff(String accountName){
		User user = usersByAccountName.get(accountName);
		if(user != null){
			user.setStatus(new UserStatus("", UserStatusType.offline));
			onlineUsers.remove(user.getId());	
		}	
	}
}
