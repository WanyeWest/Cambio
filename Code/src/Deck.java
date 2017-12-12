import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	/*
    Array of unshuffled deck
    -1 is red king
    11 is jack
    12 is queen
    13 is black king
     */
	public static final int[] cards = {
        -1,-1,0,0,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,
        6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,
        12,12,12,12,13,13
    };
	
	public static Deck mainDeck = new Deck(cards);
	public static Deck burnedDeck = new Deck();
    
    private ArrayList<Integer> deck;
    
    private Deck() {
    	this.deck = new ArrayList<Integer>();
    }
    
    private Deck(int[] cards) {
    	this.deck = new ArrayList<Integer>();
    	for (int card : cards) {
    		this.deck.add(card);
    	}
    	this.shuffle();
    }

    public void add(int card) {
    	this.deck.add(card);
    }
    
    public int getTop() {
    	return deck.get(deck.size() - 1);
    }
    
    public int get(int index) {
        return deck.get(index);
    }

	public int draw() {
		return deck.remove(0);
	}
	
	public int size() {
		return deck.size();
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}

}
