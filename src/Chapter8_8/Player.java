package Chapter8_8;

public class Player {
	String name;
	Color color;
	Game game;
	public void joinGame(){
		game = Game.getInstance();
		game.assignPlayer(this);
	}
	
	public Piece newMove(int x, int y){
		Piece p = new Piece();
		p.setColor(color);
		p.setX(x);
		p.setY(y);
		return p;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
