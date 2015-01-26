package Chapter8_3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class jukebox {

	Queue<song> playlist = new LinkedList<song>();
	ArrayList<song> database = new ArrayList<song>();
	/*
	 * singlaton
	 */
	private static jukebox instance = null;
	
	public static jukebox getInstance(){
		if(instance == null){
			instance = new jukebox();
		}
		return instance;
	}
	
	public void addToDB(song song){
		database.add(song);
	}
	
	public void addToList(song song){
		playlist.add(song);
	}
	
	public void play(){
		if(!playlist.isEmpty()){
		playlist.poll();
		}
	}
	
	public void pause(){
		//depends on real code..
	}
	
	public void next(){
		if(!playlist.isEmpty()){
			playlist.poll();
		}

	}
	
	public song searchSong(String Name){
		for(song s: database){
			if(s.name == Name){
				return s;
			}
		}
		return null;// no such song
	}
	
}
