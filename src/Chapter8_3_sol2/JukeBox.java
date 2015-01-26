package Chapter8_3_sol2;

import java.util.Set;

public class JukeBox {
	private CDPlayer cdPlayer;
	private User user;
	private Set<CD> cdCollection;
	private SongSelector ss;
	
	public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection,
			SongSelector ss) {
		super();
		this.cdPlayer = cdPlayer;
		this.user = user;
		this.cdCollection = cdCollection;
		this.ss = ss;
	}
	
	public Song getCurrentSong(){
		return ss.getCurrentSong();
	}
	public void setUser(User u){
		this.user = u;
	}

}
