package Chapter8_6;

public class Piece {
	Piece top;
	Piece bot;
	Piece left;
	Piece right;
	int AxisX;
	int AxisY;
	int Value;
	
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	public int getAxisX() {
		return AxisX;
	}
	public void setAxisX(int axisX) {
		AxisX = axisX;
	}
	public int getAxisY() {
		return AxisY;
	}
	public void setAxisY(int axisY) {
		AxisY = axisY;
	}
	public Piece getTop() {
		return top;
	}
	public void setTop(Piece top) {
		this.top = top;
	}
	public Piece getBot() {
		return bot;
	}
	public void setBot(Piece bot) {
		this.bot = bot;
	}
	public Piece getLeft() {
		return left;
	}
	public void setLeft(Piece left) {
		this.left = left;
	}
	public Piece getRight() {
		return right;
	}
	public void setRight(Piece right) {
		this.right = right;
	}
	
	
}
