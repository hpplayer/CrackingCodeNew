package Chapter8_7_sol2;

import java.util.ArrayList;

public abstract class Conversation {
	protected ArrayList<User> participants = new ArrayList<User>();
	protected int id;
	protected ArrayList<Message> messages = new ArrayList<Message>();
	
	public ArrayList<Message> getMessage(){
		return messages;
	}
	
	public boolean addMessage(Message m){
		messages.add(m);
		return true;
	}
	
	public int getID(){
		return id;
	}
	
}
