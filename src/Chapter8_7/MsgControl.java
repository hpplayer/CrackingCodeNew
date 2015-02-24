package Chapter8_7;

import java.util.ArrayList;

public class MsgControl {
	Administor ad;
	Msg currentMsg;
	ArrayList<Msg> db;
	
	public MsgControl(ArrayList<Msg> db, Msg msg, Administor ad){
		this.ad =ad;
		this.db = db;
		this.currentMsg = msg;
	}
	
	public int ReturnMsgIndex(Msg msg){
		return db.indexOf(msg);
	}
	public void deleteMsg(Msg msg){
		db.remove(ReturnMsgIndex(msg));
	}
	
	public void block(User usr){
		DisplayPanel dp = new DisplayPanel().getInstance();
		dp.usrs.remove(usr);
		dp.spams.add(new Spam(usr.id, usr.currentDisplayMsg));
	}
}
