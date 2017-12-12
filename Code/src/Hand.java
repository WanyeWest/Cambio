import java.util.ArrayList;

public class Hand {
    public ArrayList<Integer> hand = new ArrayList<Integer>();

    public void addCard(int card) {
        hand.add(card);
    }

    public void addCard(int card, int index) {
        hand.add(index, card);
    }
    
    public void burnCard(int index) {
    	int myBurnedCard = hand.set(index, null);
    	Deck.burnedDeck.add(myBurnedCard);
    }
    
    public void burnCard(int index, int replaceCard) {
    	int myBurnedCard = hand.set(index, replaceCard);
    	Deck.burnedDeck.add(myBurnedCard);
    }

    public void discardCard(int index) {
    	int discardValue = hand.get(index);
    	int topBurned = Deck.burnedDeck.getTop();
    	
    	if (discardValue == topBurned) {
    		burnCard(index);
    	} else {
    		int newCard = Deck.mainDeck.draw();
    		hand.add(newCard);
    	}
    }
    
    public int getSum() {
    	int sum = 0;
    	for(int i = 0; i < hand.size(); i++) {
    		sum += hand.get(i);
    	}
    	return sum;
    }
}
