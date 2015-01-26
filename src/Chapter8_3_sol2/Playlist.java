package Chapter8_3_sol2;

import java.util.Queue;

public class Playlist {
	private Song song;
	private Queue<Song> que;
	public Playlist(Song song, Queue que){
		super();
		this.song = song;
		this.que =que;
	}
	
	public Song getNextSong(){
		return que.peek();
	}
	public void addsong(Song song){
		que.add(song);
	}
}
