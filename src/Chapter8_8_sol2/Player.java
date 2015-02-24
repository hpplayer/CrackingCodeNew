package Chapter8_8_sol2;

public class Player {
	private Color color;

	public Color getColor() {
		return color;
	}

	public Player(Color color) {
		super();
		this.color = color;
	}
	
	public int getScore(){
		return Game.getInstance().getBoard().getScoreForColor(color);
	}
	
	public boolean playPiece(int row, int column){
		return Game.getInstance().getBoard().placeColor(row, column, color);
	}
	
}
