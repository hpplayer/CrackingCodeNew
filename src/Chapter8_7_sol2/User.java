package Chapter8_7_sol2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class User {
	private int id;
	private UserStatus status = null;
	private HashMap<Integer, PrivateChat> privateChats = new HashMap<Integer, PrivateChat>();
	private ArrayList<GroupChat> groupChats = new ArrayList<GroupChat>();
	private HashMap<Integer, AddRequest> receivedAddRequests = new HashMap<Integer, AddRequest>();
	private HashMap<Integer, AddRequest> sentAddRequests = new HashMap<Integer, AddRequest>();

	private HashMap<Integer, User> contacts = new HashMap<Integer, User>();
	private String accountName;
	private String fullName;

	public User(int id, String accountName, String fullName) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.fullName = fullName;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public boolean sendMessageToUser(User toUser, String content) {
		PrivateChat chat = privateChats.get(toUser.getId());
		if (chat == null) {
			chat = new PrivateChat(this, toUser);
			privateChats.put(toUser.getId(), chat);
		}
		Message message = new Message(content, new Date());
		return chat.addMessage(message);
	}

	public boolean sendMessageToGroupUser(int groupID, String content){
		GroupChat chat = groupChats.get(groupID);
		if(chat != null){
			Message message = new Message(content, new Date());
			return chat.addMessage(message);
		}
		return false;
	}

	public int getId() {
		return id;
	}
	public boolean addContact(User user){
		if(contacts.containsKey(user.getId())){
			return false;
		}else{
			contacts.put(user.getId(), user);
			return true;
		}
	}
	
	public void receivedAddRequest(AddRequest req){
		int senderID = req.getFromUser().getId();
		if(!receivedAddRequests.containsKey(senderID)){
			receivedAddRequests.put(senderID, req);
		}
	}
	
	public void sentAddRequest(AddRequest req){
		int receiverID = req.getFromUser().getId();
		if(!sentAddRequests.containsKey(receiverID)){
			sentAddRequests.put(receiverID, req);
		}
	}
	
	public void removeAddRequest(AddRequest req){
		if(req.getToUser() == this){
			receivedAddRequests.remove(req);
		}else if (req.getFromUser() == this){
			sentAddRequests.remove(req);
		}
	}
	
	public void requestAddUser(String accountName){
		UserManager.getInstance().addUser(this, accountName);
	}
	
	public void addConverstaion(PrivateChat conv){
		User otherUser = conv.getOtherParticipants(this);
		privateChats.put(otherUser.getId(), conv);
	}
	
	public HashMap<Integer, PrivateChat> getPrivateChats() {
		return privateChats;
	}

	public void setPrivateChats(HashMap<Integer, PrivateChat> privateChats) {
		this.privateChats = privateChats;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getFullName() {
		return fullName;
	}

	public void addConverstaion(GroupChat conv){
		groupChats.add(conv);
	}
}
