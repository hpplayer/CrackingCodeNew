package Chapter8_1;

import java.util.ArrayList;
import java.util.Random;

/*
 * class xxx<T extends yyy>
 * now T can be used as yyy type in class xxx
 */
public class Deck<T extends Card> {
	private ArrayList<T> cards; // all cards
	private int dealtIndex = 0;// undealt card

	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		cards = deckOfCards;
	}

	public void shuffle() {
		Random rd = new Random();
		for (int i = 0; i < cards.size(); i++) {
			int j = rd.nextInt(56) + 1;// 50 maximum, 1 minimum
			T card1 = cards.get(i);
			T card2 = cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}
	
	public int remainingCards(){
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int number){
		if(remainingCards() < number){
			return null;
		}
		
		T[] hand = (T[]) new Card[number];
		int count = 0;
		while(count < number){
			T card = dealCard();
			if(card != null){
				hand[count] = card;
				count ++;
			}
		}
		return hand;
	}
	
	public T dealCard(){
		if(remainingCards() == 0){
			return null;
		}
		
		T card = cards.get(dealtIndex);
		card.markavaiable();
		dealtIndex ++;
		return card;
	}
	

}
