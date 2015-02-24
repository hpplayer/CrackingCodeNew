package Chapter8_7;

public class Msg {
	static int id = 0;
	int user1;
	int user2;
	String msg;
	public Msg(int user1, int user2, String msg) {
		super();
		id ++;
		this.user1 = user1;
		this.user2 = user2;
		this.msg = msg;
	}
	
}
