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
}
