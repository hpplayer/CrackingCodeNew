package Chapter8_7;
import java.util.ArrayList;

public class DisplayPanel extends Service{
	private static ArrayList<Msg> db;
	ChatGroup CG;
	ArrayList<Vistor> vis;
	ArrayList<User> usrs;
	ArrayList<Spam> spams;
	ArrayList<Administor> ads;
	static DisplayPanel instance;
	
	public DisplayPanel getInstance(){
		if(instance == null){
			instance = new  DisplayPanel();
		}
		return instance;
	}
	
	public DisplayPanel(){
		db = new ArrayList<Msg>();
		vis = new ArrayList<Vistor>();
		usrs = new  ArrayList<User>();
		spams = new ArrayList<Spam>();
		ads = new ArrayList<Administor>();
	}

	public boolean joinChat(User usr1, User usr2){
		if(usr1 == null || usr2 == null) return false;
		if(!usrs.contains(usr1)){
			usrs.add(usr1);
		}
		if(!usrs.contains(usr2)){
			usrs.add(usr2);
		}
		CG = new ChatGroup(usr1,usr2);
		return true;
	}
	
	public boolean startChat(ChatGroup cg){
		User usr1 = cg.usr1;
		User usr2 = cg.usr2;
		String msg = usr1.currentDisplayMsg;
		if(cg.usr1 == null || cg.usr2 == null) return false;
		usr2.receive(msg);
		db.add(new Msg(usr1.id, usr2.id, msg));
		return true;
	}
	
	public MsgControl StartControl(Administor ad, Msg msg){
		if(ad == null || msg == null) return null;
		if(!ads.contains(ad)){
			ads.add(ad);
		}
		
		return new MsgControl(db, msg, ad);
	}
	

	public void display(String str){
		/*
		 * some codes here
		 */
	}

}
