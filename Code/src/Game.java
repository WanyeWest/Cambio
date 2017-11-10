import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        //create and shuffle full Deck
        ArrayList<Integer> deck = new ArrayList<Integer>();
        Deck gameDeck = new Deck(deck);
        Deck shuffledDeck = new Deck(gameDeck.createAndShuffleDeck());
        
        Player pTest = new Player();

        System.out.println(deck.size());
        //testing things
        for(int i = 0; i < deck.size(); i++) {
        	System.out.print(shuffledDeck.get(i) + ", ");
        }

        System.out.println(shuffledDeck.draw());
        for(int i = 0; i < deck.size(); i++) {
        	System.out.print(shuffledDeck.get(i) + ", ");
        }
    }
}
