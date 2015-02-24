package Chapter8_3_sol2;

public class CDPlayer {
	private Playlist p;
	private CD c;
	public Playlist getP() {
		return p;
	}
	public void setP(Playlist p) {
		this.p = p;
	}
	public CD getC() {
		return c;
	}
	public void setC(CD c) {
		this.c = c;
	}
	
	public CDPlayer(Playlist p){
		this.p = p;
	}
	public CDPlayer(CD c){
		this.c = c;
	}
	public CDPlayer(CD c, Playlist p){
		this.p = p;
		this.c = c;
	}
	
	public void play(Song s){
		
	}
	
}
