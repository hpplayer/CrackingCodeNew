package Chapter8_1;

public abstract class Card {
	private boolean avaiable = true;
	
	protected int faceValue;
	protected Suit suit;
	
	public Card(int c, Suit s){
		faceValue = c;
		suit = s;
	}
	
	public abstract int value();//not implemented yet, cuz we dont know what kind of cards it is 
	
	public Suit suit(){
		return suit;
	}
	
	public boolean isAvaiable(){
		return avaiable;
	}
	
	public void markUnavaiable(){
		avaiable =false;
	}
	
	public void markavaiable(){
		avaiable =true;
	}
	
}
