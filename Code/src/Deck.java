import java.util.ArrayList;
import static java.util.Collections.shuffle;

public class Deck {
    /*
    Array of unshuffled deck
    -1 is red king
    11 is jack
    12 is queen
    13 is black king
     */
	private final int[] cards = {
        -1,-1,0,0,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,
        6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,
        12,12,12,12,13,13
    };
    
    private ArrayList<Integer> deck = new ArrayList<Integer>();
    
    public Deck(ArrayList<Integer> cards) {
    	this.deck = cards;
    }
    
    public ArrayList<Integer> createAndShuffleDeck() {
    	for(int i: cards) {
    		deck.add(i);
    	}
    	shuffle(deck);
    	return deck;
    }

    public int get(int index) {
        return deck.get(index);
    }

	public int draw() {
		//deck.remove(0);
		return deck.get(0);
	}
	
	public ArrayList<Integer> shuffleBurned(){
		for(int i = 0; i < Hand.burned.size(); i++) {
			
		}
	}
}

