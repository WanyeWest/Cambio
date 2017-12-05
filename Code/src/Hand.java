import java.util.ArrayList;

public class Hand {
    public ArrayList<Integer> hand = new ArrayList<Integer>();
    public static ArrayList<Integer> burned = new ArrayList<Integer>();

    public Hand(ArrayList<Integer> hand) {
        this.hand = hand;
    }

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
    }

    public int getSum() {
    	int sum = 0;
    	for(int i = 0; i < hand.size(); i++) {
    		sum += hand.get(i);
    	}
    	return sum;
    }
}
