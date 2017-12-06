import java.util.ArrayList;

public class Hand {
    public ArrayList<Integer> hand = new ArrayList<Integer>();
    public static ArrayList<Integer> burned = new ArrayList<Integer>();

    public void addCard(int card) {
        hand.add(card);
    }

    public void addCard(int card, int index) {
        hand.add(index, card);
    }
   
    public void burnCard(int index) {
    	int burnedCard = hand.get(index);
    	burned.add(burnedCard);
    	hand.remove(index);
    	hand.add(index, null);
    	
    	boolean isLegal = false;
    	if(burnedCard == burned.get(index - 1)) {
    		isLegal = true;
    	}else {
    		addCard(Deck.draw());
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
