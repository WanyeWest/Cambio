import java.util.ArrayList;

public class Deck {
    private ArrayList<Integer> cards;

    public Deck(ArrayList<Integer> cards) {
        this.cards = cards;
    }

    public void addCard(int cardVal) {
        cards.add(cardVal);
    }

    public void addCard(int cardVal, int cardIndex) {
        cards.add(cardIndex, cardVal);
    }
}
