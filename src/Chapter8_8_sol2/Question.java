package Chapter8_8_sol2;

public class Question {
	public static void main(String[] args) {
		Game game = Game.getInstance();
		game.getBoard().initialize();
		game.getBoard().printBoard();
		Automator au = Automator.getInstance();
		while(!au.isOver() && au.playRandom()){
			
		}
		au.printScores();
	}
}
