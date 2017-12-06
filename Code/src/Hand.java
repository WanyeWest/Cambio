import java.util.ArrayList;

public class Hand {
    public ArrayList<Integer> hand = new ArrayList<Integer>();

    public void addCard(int card) {
        hand.add(card);
    }

    public void addCard(int card, int index) {
        hand.add(index, card);
    }
   
    public void removeCard(int index) {
    	hand.remove(index);
    	hand.add(index, null);
    }

    public int sum() {
    	int sum = 0;
    	for(int i = 0; i < hand.size(); i++) {
    		sum += hand.get(i);
    	}
    	return sum;
    }
}
