package Chapter8_3_sol2;

public class SongSelector {
	private Song currentSong;
	public SongSelector(Song s){
		currentSong = s;
	}
	public Song getCurrentSong() {
		return currentSong;
	}
	public void setCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
	}
	
	
}
