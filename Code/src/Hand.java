import java.util.ArrayList;

public class Hand {
    private ArrayList<Integer> hand;

    public Hand(ArrayList<Integer> hand) {
        this.hand = hand;
    }

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
    
    public void swap(Player victim, int victimIndex, int playerIndex) {

    }
}
